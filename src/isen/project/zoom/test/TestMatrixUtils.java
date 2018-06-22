package isen.project.zoom.test;

import isen.project.zoom.utility.Complex;
import isen.project.zoom.utility.MatrixUtils;

public class TestMatrixUtils {

	public static void testTranspose() {
		Complex[][] testMatrix = new Complex[][] {{new Complex(1, 1), new Complex(2, 2)}, 
			{new Complex(3, 3), new Complex(4, 4)}};

		Complex[][] result = new Complex[][] {{new Complex(1, 1), new Complex(3, 3)}, 
			{new Complex(2, 2), new Complex(4, 4)}};

		if(MatrixUtils.equalsMatrix(MatrixUtils.transpose(testMatrix), result))
		{
			System.out.println("Test transpose : ok");
			System.out.println("Matrice test: ");
			MatrixUtils.printMatrix(testMatrix);
			System.out.println("Résultat: ");
			MatrixUtils.printMatrix(MatrixUtils.transpose(testMatrix));
		}
		else 
		{
			System.err.println("Test transpose : erreur");
		}
	}

	public static void testArrayEquals() {
		Complex[] testArray = new Complex[] {new Complex(1, 1), new Complex(2, 2), new Complex(3, 3), new Complex(4, 4)};
		if(MatrixUtils.equalsArray(testArray, testArray)) 
		{
			System.out.println("Test array equals : ok");
		}
		else 
		{
			System.err.println("Test array equals : erreur");
		}
	}

	public static void testMatrixEquals() {
		Complex[][] testMatrix = new Complex[][] {{new Complex(1, 1), new Complex(2, 2)}, 
			{new Complex(3, 3), new Complex(4, 4)}};
		if(MatrixUtils.equalsMatrix(testMatrix, testMatrix)) 
		{
			System.out.println("Test matrix equals : ok");
		}
		else 
		{
			System.err.println("Test matrix equals : erreur");
		}
	}

}
