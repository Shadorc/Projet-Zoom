package isen.project.zoom;

import isen.project.zoom.utility.Complex;

public class FFT1D
{
	/**
	 * @return Un tableau de la taille du signal contenant la transformée de Fourier
	 *         de tous les coefficients du signal
	 */
	public Complex[] fft1d(Complex[] signal)
	{
		Complex[] S = new Complex[signal.length];

		if (signal.length == 1)
		{
			S[0] = new Complex(signal[0].getReal(), signal[0].getImaginary());
		}
		else
		{
			Complex[] pairs = new Complex[signal.length / 2];
			Complex[] impairs = new Complex[signal.length / 2];
			for (int i = 0; i < signal.length; i++)
			{
				if (i % 2 == 0)
				{
					pairs[i / 2] = signal[i];
				}
				else
				{
					impairs[(i - 1) / 2] = signal[i];
				}
			}

			Complex[] P0 = fft1d(pairs);
			Complex[] P1 = fft1d(impairs);

			for (int k = 0; k < signal.length / 2; k++)
			{
				Complex M = new Complex(1 * Math.cos(-2 * Math.PI * k / signal.length),
						1 * Math.sin(-2 * Math.PI * k / signal.length));
				S[k] = P0[k].add(P1[k].multiply(M));
				S[k + signal.length / 2] = P0[k].substract(P1[k].multiply(M));
			}
		}
		return S;
	}

	/**
	 * @return Un tableau de la taille du signal contenant la transformée inverse du
	 *         signal
	 */
	public Complex[] reverseFft1d(Complex[] signal)
	{
		Complex[] reverseFft = reverseFft1dUndivided(signal);
		final int length = signal.length;
		for (int i = 0; i < length; i++)
		{
			reverseFft[i] = new Complex(reverseFft[i].getReal() / length, reverseFft[i].getImaginary() / length);
		}
		return reverseFft;
	}

	/**
	 * @return Un tableau de la taille du signal contenant la transformée de Fourier
	 *         inverse de tous les coefficients du signal multipliés par la taille
	 *         du signal
	 */
	protected Complex[] reverseFft1dUndivided(Complex[] signal)
	{
		Complex[] S = new Complex[signal.length];

		if (signal.length == 1)
		{
			S[0] = new Complex(signal[0].getReal(), signal[0].getImaginary());
		}
		else
		{
			Complex[] pairs = new Complex[signal.length / 2];
			Complex[] impairs = new Complex[signal.length / 2];
			for (int i = 0; i < signal.length; i++)
			{
				if (i % 2 == 0)
				{
					pairs[i / 2] = signal[i];
				}
				else
				{
					impairs[(i - 1) / 2] = signal[i];
				}
			}

			Complex[] P0 = reverseFft1dUndivided(pairs);
			Complex[] P1 = reverseFft1dUndivided(impairs);

			for (int k = 0; k < signal.length / 2; k++)
			{
				Complex M = new Complex(1 * Math.cos(2 * Math.PI * k / signal.length),
						1 * Math.sin(2 * Math.PI * k / signal.length));
				S[k] = P0[k].add(P1[k].multiply(M));
				S[k + signal.length / 2] = P0[k].substract(P1[k].multiply(M));
			}
		}
		return S;
	}

}
