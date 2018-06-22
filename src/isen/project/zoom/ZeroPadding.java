package isen.project.zoom;

import isen.project.zoom.utility.Complex;

public class ZeroPadding {

	private final int zoom;

	public ZeroPadding(int zoom) {
		this.zoom = zoom;
	}

	public Complex[][] zeroPadding(Complex[][] matrix) 
	{
		// Nombre de lignes de la matrice
		int matrixLines = matrix.length;
		// Nombre de colonnes de la matrice
		int matrixColumns = matrix[0].length;

		Complex[][] paddedMatrix = new Complex[this.zoom*matrixLines][this.zoom*matrixColumns];

		// Nombre de z�ros contenus dans une ligne non nulle
		int zerosLine = (this.zoom-1)*matrixColumns;
		// Nombre de z�ros contenus dans une colonne non nulle
		int zerosColumn = (this.zoom-1)*matrixLines;
		
		for (int i = 0; i < paddedMatrix.length; i++)
		{
			for (int j = 0; j < paddedMatrix[0].length; j++)
			{
				// Coin sup�rieur gauche
				if (i < matrixLines/2 && j < matrixColumns/2)
				{
					paddedMatrix[i][j] = matrix[i][j];
				}
				// Coin sup�rieur droit
				else if (i < matrixLines/2 && j >= matrixColumns/2+zerosLine)
				{
					paddedMatrix[i][j] = matrix[i][j-zerosLine];
				}
				// Coin inf�rieur gauche
				else if (i >= matrixLines/2+zerosColumn && j < matrixColumns/2)
				{
					paddedMatrix[i][j] = matrix[i-zerosColumn][j];
				}
				// Coin inf�rieur droit
				else if (i >= matrixLines/2+zerosColumn && j >= matrixColumns/2+zerosLine)
				{
					paddedMatrix[i][j] = matrix[i-zerosColumn][j-zerosLine];
				}
				// Sinon, on remplit de z�ros
				else
				{
					paddedMatrix[i][j] = new Complex(0, 0);
				}
			}
		}
		return paddedMatrix;
	}
}
