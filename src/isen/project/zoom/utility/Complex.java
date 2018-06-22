package isen.project.zoom.utility;

public class Complex
{
	private double real;
	private double imaginary;

	public Complex(double real, double imaginary)
	{
		this.setReal(real);
		this.setImaginary(imaginary);
	}

	public void setReal(double real)
	{
		this.real = real;
	}

	public void setImaginary(double imaginary)
	{
		this.imaginary = imaginary;
	}

	public double getReal()
	{
		return this.real;
	}

	public double getImaginary()
	{
		return this.imaginary;
	}

	public double getModule()
	{
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	}

	public double getArgument()
	{
		if (this.real == 0)
		{
			return Math.PI / 2;
		}
		return Math.atan(this.imaginary / this.real);
	}

	public Complex add(Complex complex)
	{
		return new Complex(this.real + complex.getReal(), this.imaginary + complex.getImaginary());
	}

	public Complex substract(Complex complex)
	{
		return new Complex(this.real - complex.getReal(), this.imaginary - complex.getImaginary());
	}

	public Complex multiply(Complex complex)
	{
		double real = this.real * complex.real - this.imaginary * complex.imaginary;
		double imaginary = this.real * complex.imaginary + this.imaginary * complex.real;
		return new Complex(real, imaginary);
	}

	@Override
	public String toString()
	{
		return this.getReal() + "+i" + this.getImaginary();
	}
}