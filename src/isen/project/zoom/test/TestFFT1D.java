package isen.project.zoom.test;

import isen.project.zoom.FFT1D;
import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class TestFFT1D {

	public static void testFft1d() {
		Complex[] testSignal = new Complex[] {new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0),
				new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0)};
		FFT1D fft1d = new FFT1D();
		
		Complex[] result = new Complex[] {new Complex(0, 0), new Complex(0, 0), new Complex(4, 0), new Complex(0, 0),
				new Complex(0, 0), new Complex(0, 0), new Complex(4, 0), new Complex(0, 0)};
		
		if (MatrixUtils.equalsArray(fft1d.fft1d(testSignal), result))
		{
			System.out.println("Test fft1D : ok");
		}
		else
		{
			System.err.println("Test fft1D : erreur");
		}
	}

	public static void testReverseFft1d() 
	{
		Complex[] testSignal = new Complex[] {new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0),
				new Complex(1, 0), new Complex(0, 0), new Complex(-1, 0), new Complex(0, 0)};
		FFT1D fft1d = new FFT1D();

		if (MatrixUtils.equalsArray(fft1d.reverseFft1d(fft1d.fft1d(testSignal)), testSignal))
		{
			System.out.println("Test reverse fft1D : ok");
		}
		else
		{
			System.err.println("Test reverse fft1D : erreur");
		}		
	}
}
