package isen.project.zoom;

import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class FFT2D extends FFT1D
{
	public FFT2D()
	{
		super();
	}

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
	 *         de Fourier inverse de tous les coefficients du signal
	 */
	public Complex[][] reverseFft2d(Complex[][] signal)
	{
		Complex[][] fftLine = new Complex[signal.length][signal[0].length];
		for (int i = 0; i < signal.length; i++)
		{
			fftLine[i] = reverseFft1d(signal[i]);
		}

		Complex[][] fftTransposed = MatrixUtils.transpose(fftLine);
		Complex[][] fftColumn = new Complex[fftTransposed.length][fftTransposed[0].length];
		for (int j = 0; j < fftTransposed.length; j++)
		{
			fftColumn[j] = reverseFft1d(fftTransposed[j]);
		}
		return MatrixUtils.transpose(fftColumn);
	}

}
