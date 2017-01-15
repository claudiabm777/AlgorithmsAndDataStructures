package Algorithms.MatrixFolder;

public class MatrixClass {
	/**
	 * This method multiplies two square matrices of the same length
	 * <b>Precondition:</b> the matrices must be of the same length
	 * Worst case running time complexity: O(n^3).
	 * Average case running time complexity: O(n^3).
	 * Worst case extra-spatial complexity: O(n^3).
	 * @param a - first matrix
	 * @param b - second matrix
	 * @return c - a*b=c. Multiplication result
	 */
	public static Double[][] squareMatrixMultiply(Double a[][],Double b[][]){
		Double [][]c=new Double[a.length][a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				c[i][j]=0.0;
				for(int k=0;k<a.length;k++){
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		return c;
	}

}
