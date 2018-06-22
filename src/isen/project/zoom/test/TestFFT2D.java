package isen.project.zoom.test;

import isen.project.zoom.FFT2D;
import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class TestFFT2D
{
	public static void testFft2d()
	{
		Complex[][] testSignal = new Complex[][] {
				{ new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0) },
				{ new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0) },
				{ new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0) },
				{ new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0) } };

		FFT2D fft2D = new FFT2D();

		Complex[][] result = new Complex[][] {
				{ new Complex(0, 0), new Complex(8, 0), new Complex(0, 0), new Complex(8, 0) },
				{ new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0) },
				{ new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0) },
				{ new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0) } };

		if (MatrixUtils.equalsMatrix(result, fft2D.fft2d(testSignal)))
		{
			System.out.println("Test fft2D : ok");
			System.out.println("Signal test: ");
			MatrixUtils.printMatrix(testSignal);
			System.out.println("Résultat: ");
			MatrixUtils.printMatrix(fft2D.fft2d(testSignal));
		} else
		{
			System.err.println("Test fft2D : erreur");
		}
	}

	public static void testReverseFft2d()
	{
		Complex[][] testSignal = new Complex[][] {
				{ new Complex(0, 0), new Complex(0, 1), new Complex(0, 0), new Complex(0, -1) },
				{ new Complex(0, 0), new Complex(0, 1), new Complex(0, 0), new Complex(0, -1) },
				{ new Complex(0, 0), new Complex(0, 1), new Complex(0, 0), new Complex(0, -1) },
				{ new Complex(0, 0), new Complex(0, 1), new Complex(0, 0), new Complex(0, -1) } };

		FFT2D fft2D = new FFT2D();
		if (MatrixUtils.equalsMatrix(testSignal, fft2D.reverseFft2d(fft2D.fft2d(testSignal))))
		{
			System.out.println("Test reverse fft2D : ok");
			System.out.println("Signal test: ");
			MatrixUtils.printMatrix(testSignal);
			System.out.println("Résultat: ");
			MatrixUtils.printMatrix(fft2D.reverseFft2d(fft2D.fft2d(testSignal)));
		} else
		{
			System.err.println("Test reverse fft2D : erreur");
		}
	}
}
