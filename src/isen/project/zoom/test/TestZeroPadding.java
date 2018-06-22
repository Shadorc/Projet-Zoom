package isen.project.zoom.test;

import isen.project.zoom.ZeroPadding;
import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class TestZeroPadding
{
	public static void testZeroPadding()
	{
		Complex[][] testMatrix = new Complex[][] { { new Complex(1, 0), new Complex(2, 0) },
				{ new Complex(3, 0), new Complex(4, 0) } };

		Complex[][] zeroPaddedMatrix = new ZeroPadding(2).zeroPadding(testMatrix);

		Complex[][] result = new Complex[][] {
				{ new Complex(1, 0), new Complex(0, 0), new Complex(0, 0), new Complex(2, 0) },
				{ new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0) },
				{ new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0) },
				{ new Complex(3, 0), new Complex(0, 0), new Complex(0, 0), new Complex(4, 0) } };

		if (MatrixUtils.equalsMatrix(zeroPaddedMatrix, result))
		{
			System.out.println("Test zero padding : ok");
		}
		else
		{
			System.out.println("Test zero padding : erreur");
		}
		System.out.println("Matrice test: ");
		MatrixUtils.printMatrix(testMatrix);
		System.out.println("Résultat: ");
		MatrixUtils.printMatrix(zeroPaddedMatrix);
	}
}
