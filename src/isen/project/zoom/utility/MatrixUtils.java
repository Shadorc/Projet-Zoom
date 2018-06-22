package isen.project.zoom.utility;

import java.util.Arrays;

public class MatrixUtils {

	/**
	 * @return Une matrice correspondant à la transposée de {@code matrix}
	 */
	public static Complex[][] transpose(Complex[][] matrix)
	{
		Complex[][] transposed = new Complex[matrix[0].length][matrix.length]; 
		for(int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				transposed[j][i] = matrix[i][j];
			}
		}
		return transposed;
	}

	/**
	 * @return {@code true} si les deux listes sont égales, {@code false} sinon
	 */
	public static boolean equalsArray(Complex[] matrix1, Complex[] matrix2)
	{
		if (matrix1.length != matrix2.length)
		{
			return false;
		}
		for (int i = 0; i < matrix1.length ; i++)
		{
			if (matrix1[i].getReal() != matrix2[i].getReal() || matrix1[i].getImaginary() != matrix2[i].getImaginary())
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * @return {@code true} si les deux matrices sont égales, {@code false} sinon
	 */
	public static boolean equalsMatrix(Complex[][] matrix1, Complex[][] matrix2) {
		if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
			return false;
		}
		for (int i = 0; i < matrix1.length ; i++)
		{
			if (!MatrixUtils.equalsArray(matrix1[i], matrix2[i]))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Affiche une matrice de complexes dans la console
	 */
	public static void printMatrix(Complex[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
