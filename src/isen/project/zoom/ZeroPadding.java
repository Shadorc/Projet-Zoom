package isen.project.zoom;

import isen.project.zoom.utility.Complex;

public class ZeroPadding
{

	private final int zoom;

	public ZeroPadding(int zoom)
	{
		this.zoom = zoom;
	}

	public Complex[][] zeroPadding(Complex[][] matrix)
	{
		// Nombre de lignes de la matrice
		int matrixLines = matrix.length;
		// Nombre de colonnes de la matrice
		int matrixColumns = matrix[0].length;

		Complex[][] paddedMatrix = new Complex[this.zoom * matrixLines][this.zoom * matrixColumns];

		// Nombre de zéros contenus dans une ligne non nulle
		int zerosLine = (this.zoom - 1) * matrixLines;
		// Nombre de zéros contenus dans une colonne non nulle
		int zerosColumn = (this.zoom - 1) * matrixColumns;

		for (int i = 0; i < paddedMatrix.length; i++)
		{
			for (int j = 0; j < paddedMatrix[0].length; j++)
			{
				// Coin supérieur gauche
				if (i < matrixLines / 2 && j < matrixColumns / 2)
				{
					paddedMatrix[i][j] = matrix[i][j];
				}
				// Coin supérieur droit
				else if (i < matrixLines / 2 && j >= matrixColumns / 2 + zerosLine)
				{
					paddedMatrix[i][j] = matrix[i][j - zerosLine];
				}
				// Coin inférieur gauche
				else if (i >= matrixLines / 2 + zerosColumn && j < matrixColumns / 2)
				{
					paddedMatrix[i][j] = matrix[i - zerosColumn][j];
				}
				// Coin inférieur droit
				else if (i >= matrixLines / 2 + zerosColumn && j >= matrixColumns / 2 + zerosLine)
				{
					paddedMatrix[i][j] = matrix[i - zerosColumn][j - zerosLine];
				}
				// Sinon, on remplit de zéros
				else
				{
					paddedMatrix[i][j] = new Complex(0, 0);
				}
			}
		}
		return paddedMatrix;
	}
}
