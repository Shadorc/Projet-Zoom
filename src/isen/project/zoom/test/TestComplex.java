package isen.project.zoom.test;

import isen.project.zoom.utility.Complex;

public class TestComplex
{
	public static void testAddition()
	{
		Complex complex1 = new Complex(2, 3);
		Complex complex2 = new Complex(1, -1);
		Complex result = complex1.add(complex2);
		if (complex1.getReal() + complex2.getReal() == result.getReal()
				&& complex1.getImaginary() + complex2.getImaginary() == result.getImaginary())
		{
			System.out.println("Test addition : ok");
			System.out.println(complex1 + " + " + complex2 + " = " + result);
		}
		else
		{
			System.err.println("Test addition : erreur");
		}
	}

	public static void testSubstraction()
	{
		Complex complex1 = new Complex(2, 3);
		Complex complex2 = new Complex(1, -1);
		Complex result = complex1.substract(complex2);
		if (complex1.getReal() - complex2.getReal() == result.getReal()
				&& complex1.getImaginary() - complex2.getImaginary() == result.getImaginary())
		{
			System.out.println("Test substraction : ok");
			System.out.println(complex1 + " - " + complex2 + " = " + result);
		}
		else
		{
			System.err.println("Test substraction : erreur");
		}
	}

	public static void testMultiplication()
	{
		Complex complex1 = new Complex(2, 3);
		Complex complex2 = new Complex(1, -1);
		Complex result = complex1.multiply(complex2);
		double real = complex1.getReal() * complex2.getReal() - complex1.getImaginary() * complex2.getImaginary();
		double imaginary = complex1.getReal() * complex2.getImaginary() + complex1.getImaginary() * complex2.getReal();
		if (real == result.getReal() && imaginary == result.getImaginary())
		{
			System.out.println("Test multiplication : ok");
			System.out.println(complex1 + " x " + complex2 + " = " + result);
		}
		else
		{
			System.err.println("Test multiplication : erreur");
		}
	}
}
