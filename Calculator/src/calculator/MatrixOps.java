/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Andrew
 */
public interface MatrixOps {
    
    /**
     * Add two matrices. Matrices must be of the same size
     * @param a One matrix
     * @param b The other matrix
     * @return sum of the matrices
     * @throws IllegalArgumentException if the matrices are not of the 
     * same size.
     */
    double[][] add(double[][] a, double[][] b);
    
    /**
     * Compute the product of two matrices. The second dimension of a
     * must be the same as the first dimension of b
     * @param a
     * @param b
     * @return product of the matrices
     * @throws IllegalArgumentException if the number of columns in a
     * is not equal to the number of rows in b
     */
    double[][] mult(double[][] a, double[][] b);
    
}
