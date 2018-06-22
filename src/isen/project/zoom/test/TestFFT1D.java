package isen.project.zoom.test;

import java.util.Arrays;

import isen.project.zoom.FFT1D;
import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class TestFFT1D
{

	public static void testFft1d()
	{
		Complex[] testSignal = new Complex[] { new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0),
				new Complex(0, 0), new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0) };
		FFT1D fft1d = new FFT1D();

		Complex[] result = new Complex[] { new Complex(0, 0), new Complex(0, 0), new Complex(4, 0), new Complex(0, 0),
				new Complex(0, 0), new Complex(0, 0), new Complex(4, 0), new Complex(0, 0) };

		if (MatrixUtils.equalsArray(fft1d.fft1d(testSignal), result))
		{
			System.out.println("Test fft1D : ok");
			System.out.println("Signal test: " + Arrays.toString(testSignal));
			System.out.println("Résultat: " + Arrays.toString(result));
		} else
		{
			System.err.println("Test fft1D : erreur");
		}
	}

	public static void testReverseFft1d()
	{
		Complex[] testSignal = new Complex[] { new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0),
				new Complex(0, 0), new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0) };
		FFT1D fft1d = new FFT1D();

		Complex[] result = fft1d.reverseFft1d(fft1d.fft1d(testSignal));

		if (MatrixUtils.equalsArray(result, testSignal))
		{
			System.out.println("Test reverse fft1D : ok");
			System.out.println("Signal test: " + Arrays.toString(testSignal));
			System.out.println("Résultat: " + Arrays.toString(result));
		} else
		{
			System.err.println("Test reverse fft1D : erreur");
		}
	}
}
