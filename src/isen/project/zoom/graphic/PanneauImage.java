package isen.project.zoom.graphic;
// À compiler par javac PanneauImage.java

// À exécuter par java PanneauImage <nomImage> [zoom], oÃ¹ <nomImage> est le nom
// de l'image à zoomer et [zoom] une puissance de 2 facultative indiquant le
// niveau de zoom désiré (s'il n'est pas fourni, le zoom sera de 2)

import java.awt.Dimension; // Pour définir une dimension d'élément graphique
import java.awt.Graphics; // Pour manipuler un contexte de dessin
import java.awt.image.BufferedImage; // Pour contenir l'image lue d'un fichier
import java.io.File; // Pour manipuler un fichier

import javax.imageio.ImageIO; // Pour pouvoir lire une image
// Pour manipuler tous les composants Swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import isen.project.zoom.FFTCplx;
import isen.project.zoom.utility.Complex;

public class PanneauImage extends JPanel
{
	private BufferedImage image; // Pour stocker une image
	private static final int Rouge = 0;
	private static final int Vert = 1;
	private static final int Bleu = 2;

	// Passage d'une image lue aux couches RVB
	private double[][][] imageVers3Couches(BufferedImage image)
	{
		final int largeur = image.getWidth();
		final double[][] rouge = new double[largeur][largeur];
		final double[][] vert = new double[largeur][largeur];
		final double[][] bleu = new double[largeur][largeur];
		for (int y = 0; y < largeur; ++y)
			for (int x = 0; x < largeur; ++x)
			{
				final int pixel = image.getRGB(x, y);
				// On sépare chacune des composantes rouge, verte et bleue en
				// les extrayant du pixel d'une image
				rouge[y][x] = (pixel >> 16) & 0x0FF;
				vert[y][x] = (pixel >> 8) & 0x0FF;
				bleu[y][x] = pixel & 0x0FF;
			}
		double[][][] valeurRetour = { rouge, vert, bleu };
		return valeurRetour;
	}

	// Assure que l'on n'utilise pas de valeur supérieure à 255
	private int satCplx(Complex complexe)
	{
		return (int) Math.min(complexe.getModule(), 255);
	}

	// Passage de couches RVB complexes en image
	private void couches_dansImage(Complex[][] rouge, Complex[][] vert, Complex[][] bleu, BufferedImage image)
	{
		final int largeur = rouge.length;
		for (int y = 0; y < largeur; ++y)
			for (int x = 0; x < largeur; ++x)
			{
				// On fabrique un pixel en reconstituant ses composantes
				// rouge, verte et bleue, chacune sur un octet, dans un int 32b
				final int pixel = (satCplx(rouge[y][x]) << 16) | (satCplx(vert[y][x]) << 8) | satCplx(bleu[y][x]);
				image.setRGB(x, y, pixel);
			}
	}

	// Lecture et zoom de l'image
	public PanneauImage(String nomImage, int zoom) throws Exception
	{
		image = ImageIO.read(new File(nomImage));
		final double[][][] couches = imageVers3Couches(image);
		final Complex[][] coucheZoomeeRouge = FFTCplx.zoom(zoom, couches[Rouge]);
		final Complex[][] coucheZoomeeVerte = FFTCplx.zoom(zoom, couches[Vert]);
		final Complex[][] coucheZoomeeBleue = FFTCplx.zoom(zoom, couches[Bleu]);
		image = new BufferedImage(coucheZoomeeRouge.length, coucheZoomeeRouge.length, BufferedImage.TYPE_INT_RGB);
		couches_dansImage(coucheZoomeeRouge, coucheZoomeeVerte, coucheZoomeeBleue, image);

		setPreferredSize(new Dimension(image.getWidth(), image.getHeight())); // Fixe la taille du panneau à la taille
																				// de l'image
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // Exécute les actions graphiques héritées
		g.drawImage(image, 0, 0, null); // Dessine l'image
	}

	public static void main(String[] args)
	{
		if (args.length != 0)
		{
			JFrame fenetre = new JFrame(); // Fabrique la fenètre
			fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Quand on ferme la fenètre, l'application
			// s'arrète
			try
			{
				int niveauDeZoom = 2;
				try
				{
					if (args.length >= 2)
						niveauDeZoom = Integer.parseInt(args[1]);
				}
				catch (Exception e)
				{
				} // conserver 2 dans niveauDeZoom si le niveau de zoom n'a pas été fourni

				PanneauImage panneauImage = new PanneauImage(args[0], niveauDeZoom); // Fabrique l'élément image
				fenetre.getContentPane().add(panneauImage); // Ajoute l'élément image au contenu de la fenètre
				fenetre.pack(); // Fixe la taille de la fenètre relativement à son contenu
				fenetre.setLocationRelativeTo(null); // Place la fenètre au milieu de l'écran
				fenetre.setVisible(true); // Affiche la fenètre
			}
			catch (Exception e)
			{
				System.out.println("Impossible de traiter l'image");
			}
		}
	}
}
