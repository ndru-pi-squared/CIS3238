package calculator;

import .simpleXMLRMI.ProxyFactory;
import edu.temple.cis.wolfgang.matrixops.MatrixOps;

/**
 *
 * @author Paul Wolfgang
 */
public class MatrixOpsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatrixOps matrixOps = (MatrixOps)ProxyFactory.createProxy(MatrixOps.class);
        testAdd(matrixOps);
        testMult(matrixOps);
    }
    
    private static void testAdd(MatrixOps matrixOps) {
        double[][] a = {{1, 2, 3}, {4, 5, 6}};
        double[][] b = {{7, 8, 9}, {10, 11, 12}};
        double[][] expResult = {{8, 10, 12}, {14, 16, 18}};
        double[][] result = matrixOps.add(a, b);
        assert doubleMatricesAreEqual(expResult, result);
    }
    
    private static void testMult(MatrixOps matrixOps) {
        double[][] a = {{1, 2, 3}, {4, 5, 6}};
        double[][] b = {{7, 10}, {8, 11}, {9, 12}};
        double[][] expResult = {{50, 68}, {122, 167}};
        double[][] result = matrixOps.mult(a, b);        
        assert doubleMatricesAreEqual(expResult, result);
    }
    
    public static boolean doubleMatricesAreEqual(double[][] a, double[][] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) return false;
            for (int j = 0; j < a[i].length; j++) {
                if (Math.abs(a[i][j] - b[i][j]) > 1e-9) return false;
            }
        }
        return true;
    }
    
}
