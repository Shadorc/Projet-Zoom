package isen.project.zoom;

import isen.project.zoom.utility.Complex;

public class FFTCplx
{
	public static Complex[][] zoom(int facteur, double[][] tableau)
	{
		final int taille = tableau.length;
		Complex[][] imageZoomee = new Complex[taille][taille];
		for (int y = 0; y < taille; ++y)
		{
			for (int x = 0; x < taille; ++x)
			{
				imageZoomee[y][x] = new Complex(tableau[y][x], 0);
			}
		}

		FFT2D fft2d = new FFT2D();
		Complex[][] fft2dMatrix = fft2d.fft2d(imageZoomee);
		Complex[][] paddedMatrix = new ZeroPadding(facteur).zeroPadding(fft2dMatrix);
		Complex[][] reversedMatrix = fft2d.reverseFft2d(paddedMatrix);
		
		// Multiplie les amplitudes par le facteur au carré pour obtenir l'amplitude d'origine
		for(int i = 0; i < reversedMatrix.length; i++) {
			for(int j = 0; j < reversedMatrix[0].length; j++) {
				reversedMatrix[i][j] = reversedMatrix[i][j].multiply(new Complex(facteur*facteur, 0));
			}
		}
		
		return reversedMatrix;
	}
}
