package isen.project.zoom.test;

public class MainTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Test de la classe Complex:");
		TestComplex.testAddition();
		TestComplex.testSubstraction();
		TestComplex.testMultiplication();
		
		System.out.println("\nTest de la classe MatrixUtils:");
		TestMatrixUtils.testTranspose();
		TestMatrixUtils.testArrayEquals();
		TestMatrixUtils.testMatrixEquals();

		System.out.println("\nTest de la classe FFT1D:");
		TestFFT1D.testFft1d();
		TestFFT1D.testReverseFft1d();

		System.out.println("\nTest de la classe FFT2D:");
		TestFFT2D.testFft2d();
		TestFFT2D.testReverseFft2d();
		
		System.out.println("\nTest de la classe ZeroPadding:");
		TestZeroPadding.testZeroPadding();
	}

}
