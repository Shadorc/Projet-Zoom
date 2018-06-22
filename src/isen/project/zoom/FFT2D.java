package isen.project.zoom;

import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class FFT2D extends FFT1D
{
	/**
	 * @return Une matrice de même dimension que le signal contenant la transformée
	 *         de Fourier de tous les coefficients du signal
	 */
	public Complex[][] fft2d(Complex[][] signal)
	{
		Complex[][] fftLine = new Complex[signal.length][signal[0].length];
		for (int i = 0; i < signal.length; i++)
		{
			fftLine[i] = fft1d(signal[i]);
		}

		Complex[][] fftTransposed = MatrixUtils.transpose(fftLine);
		Complex[][] fftColumn = new Complex[fftTransposed.length][fftTransposed[0].length];
		for (int j = 0; j < fftTransposed.length; j++)
		{
			fftColumn[j] = fft1d(fftTransposed[j]);
		}
		return MatrixUtils.transpose(fftColumn);
	}

	/**
	 * @return Une matrice de même dimension que le signal contenant la transformée
	 *         de Fourier inverse de tous les coefficients du signal multipliés par
	 *         la taille du signal au carré
	 */
	public Complex[][] reverseFft2d(Complex[][] signal)
	{
		Complex[][] reverseFft = reverseFft2dUndivided(signal);
		final int length = signal.length * signal[0].length;
		for (int i = 0; i < signal.length; i++)
		{
			for (int j = 0; j < signal[0].length; j++)
			{
				reverseFft[i][j] = new Complex(reverseFft[i][j].getReal() / length,
						reverseFft[i][j].getImaginary() / length);
			}
		}
		return reverseFft;
	}

	/**
	 * @return Une matrice de même dimension que le signal contenant la transformée
	 *         de Fourier inverse de tous les coefficients du signal
	 */
	public Complex[][] reverseFft2dUndivided(Complex[][] signal)
	{
		Complex[][] fftLine = new Complex[signal.length][signal[0].length];
		for (int i = 0; i < signal.length; i++)
		{
			fftLine[i] = reverseFft1dUndivided(signal[i]);
		}

		Complex[][] fftTransposed = MatrixUtils.transpose(fftLine);
		Complex[][] fftColumn = new Complex[fftTransposed.length][fftTransposed[0].length];
		for (int j = 0; j < fftTransposed.length; j++)
		{
			fftColumn[j] = reverseFft1dUndivided(fftTransposed[j]);
		}
		return MatrixUtils.transpose(fftColumn);
	}

}
