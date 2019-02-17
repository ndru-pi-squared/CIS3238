package calculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class MatrixOpsImpl implements MatrixOps{
     /**
     * Add two matrices. Matrices must be of the same size
     * @param a One matrix
     * @param b The other matrix
     * @return sum of the matrices
     * @throws IllegalArgumentException if the matrices are not of the 
     * same size.
     */
    @Override
    public double[][] add(double[][] a, double[][] b) {
        if (a.length != b.length)
            throw new IllegalArgumentException("Arrays have different number of rows");
        int numRows = a.length;
        int numColumns = a[0].length;
        for (int i = 0; i < numRows; i++) {
            if (a[i].length != numColumns) {
                throw new IllegalArgumentException(String.format("Row %d of a does not contain %d columns", i, numColumns));
            }
            if (b[i].length != numColumns) {
                throw new IllegalArgumentException(String.format("Row %d of b does not contain %d columns", i, numColumns));                
            }
        }
        double[][] c = new double[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
    
    /**
     * Compute the product of two matrices. The second dimension of a
     * must be the same as the first dimension of b
     * @param a
     * @param b
     * @return product of the matrices
     * @throws IllegalArgumentException if the number of columns in a
     * is not equal to the number of rows in b
     */
    @Override
    public double[][] mult(double[][] a, double[][] b) {
        int numRows = a.length;
        int innerProduct = a[0].length;
        int numCols = b[0].length;
        if (b.length != innerProduct) {
            throw new IllegalArgumentException("Matricies not compatible for multiply");
        }
        for (int i = 0; i < numRows; i++) {
            if (a[i].length != innerProduct) {
                throw new IllegalArgumentException(String.format("Row %d of a does not contain %d columns", i, innerProduct));
            }
        }
        for (int i = 0; i < innerProduct; i++) {
            if (b[i].length != numCols) {
                throw new IllegalArgumentException(String.format("Row %d of b does not contain %d columns", i, numCols));                                
            }
        }
        double[][] c = new double[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                c[i][j] = 0;
                for (int k = 0; k < innerProduct; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    
}
