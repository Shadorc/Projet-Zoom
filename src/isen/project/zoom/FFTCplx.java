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
		
		Complex[][] matrixFft2d = new FFT2D().fft2d(imageZoomee);
		Complex[][] matrixPadded = new ZeroPadding(facteur).zeroPadding(matrixFft2d);
		
		return new FFT2D().reverseFft2d(matrixPadded);
	}
}
