package simpleRMIExample;

import compute.Compute;
import matrixOps.MatrixOps;
import simpleRMI.SimpleRMIProxyFactory;
import java.util.Arrays;

/**
 *//****************************************
 * @author Paul Wolfgang
 * Modified by Andrew D. Pitt
 * CIS 3238 Lab 06
 * //****************************************
 */
public class Main {

    //compute functionality remains for testing (commented out)
    public static void main(String[] args) throws Exception {
        //Compute compute = (Compute) SimpleRMIProxyFactory.createProxy(Compute.class, 
                //"osprey.cis.temple.edu", "tug84943");
        MatrixOps mops = (MatrixOps) SimpleRMIProxyFactory.createProxy(MatrixOps.class, 
                "osprey.cis.temple.edu", "tug84943");
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        callM(mops,"add",a,b);
        callM(mops,"mult",a,b);
        /*call(compute, "add", 5, 7);
        call(compute, "sub", 7, 5);
        call(compute, "mul", 7, 5); //left this in for testing
        call(compute, "div", 15, 3);*/
        //call(compute, "div", 10, 0);
    }

    private static void callM(MatrixOps m, String op, double[][] x, double[][] y) {//call function adapted for matrices
        try {
        double[][] result=null;
        //System.out.println("op= " +op);
        if ("add".equals(op))
            result = m.add(x, y);
        else if ("mult".equals(op))
            result = m.mult(x, y);
        System.out.printf("%s(\nMatrix one: \n%s, \nMatrix two:\n %s) \n== \n%s%n\n", op, 
                Arrays.deepToString(x), Arrays.deepToString(y), Arrays.deepToString(result));
   
        } catch (Exception ex) {
            System.out.printf("%s(%s, %s) FAILED%n", op, Arrays.deepToString(x), Arrays.deepToString(y));
            ex.printStackTrace();
        }
    }
    private static void call(Compute c, String op, int x, int y) {//original call function for compute
        try {
        int result = Integer.MIN_VALUE;
        if ("add".equals(op))
            result = c.add(x, y);
        else if ("sub".equals(op))
            result = c.sub(x, y);
        else if ("mul".equals(op))
            result = c.mul(x, y);
        else if ("div".equals(op))
            result = c.div(x, y);
        System.out.printf("%s(%d, %d) == %d%n", op, x, y, result);
        } catch (Exception ex) {
            System.out.printf("%s(%d, %d) FAILED%n", op, x, y);
            ex.printStackTrace();
        }
    }
}
