package CGIInvoke;

import RPCUtil.Util;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //try{PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        //System.setOut(out);
        //out.println("TESTMF");
        //out.close();}
        //catch(Exception e){e.printStackTrace();}
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String fullMethodName = in.readLine();
            int posLastDot = fullMethodName.lastIndexOf('.');
            String simpleMethodName = fullMethodName.substring(posLastDot + 1);
            String fullInterfaceName = fullMethodName.substring(0, posLastDot);
            String sParam1 = in.readLine();//read until \n will either read an int or a formatted string matrix. 
            String sParam2 = in.readLine();//must unpack matrix
            Object obj = Util.findAndLoadClass(fullInterfaceName);
            //{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
            String result = null;
            if(sParam1.length()>2){//if its a matrix
                double[][] a = stringToDeep(sParam1);//allocate matrix from string
                double[][] b = stringToDeep(sParam2);
                result = callMatrixMethod(obj, simpleMethodName, a, b);//just use a and b for now
            }
            else{//if its compute
                int param1 = Integer.parseInt(sParam1);
                int param2 = Integer.parseInt(sParam2);
                result = callComputeMethod(obj, simpleMethodName, param1, param2);
                }
            outputResult(result);
        } catch (Exception ex) {
            outputResult(createStackTrace(ex));
        }
    }

    private static void outputResult(String result) {
        StringBuilder stb = new StringBuilder();
        stb.append(result);
        stb.append("\r\n");
        System.out.print("Content-Type: text/plain\r\n");
        System.out.print("Content-Length: " + stb.length());
        System.out.print("\r\n\r\n");
        System.out.print(stb.toString());
    }
    
    private static String callComputeMethod(Object obj, //original version of callMethod()
            String methodName,
            int param1,
            int param2) {
        try {
            Class clazz = obj.getClass();
            Method m = clazz.getMethod(methodName, int.class, int.class);
            Integer result = (Integer) m.invoke(obj,
                    new Integer(param1),
                    new Integer(param2));
            return result.toString();
        } catch (Exception ex) {
            return createStackTrace(ex);
        }
    }
    private static String callMatrixMethod(Object obj,//callMethod() adapted for matrices
            String methodName,
            double[][] param1,
            double[][] param2) {

        try {
            Class clazz = obj.getClass();
            Method m = clazz.getMethod(methodName, double[][].class, double[][].class);//apparently this is  correct
            double[][] result = (double[][]) m.invoke(obj,param1,param2);//this is where the issue is
                    //new Object[]{param1},//this is where the issue is. 
                    //new Object[]{param2}); //add/mult take 2 double arrays, this passes 1 Object array
            return Arrays.deepToString(result);
        } catch (Exception ex) {
            return createStackTrace(ex);
        }
    }

    private static String createStackTrace(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
    
    static int countCols(String sParam1){//count columns routine
        int nrows = 0;
        for(int i=0;i<=sParam1.length()-1;i++)
            if(sParam1.charAt(i)=='#')
                nrows++;
        System.out.println(nrows);
        return nrows;
    }
    
    private static double[][] stringToDeep(String str) {//my new favorite method
        int row = 0;
        int col = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                row++;
            }
        }
        row--;
        for (int i = 0;; i++) {
            if (str.charAt(i) == ',') {
                col++;
            }
            if (str.charAt(i) == ']') {
                break;
            }
        }
        col++;

        double[][] out = new double[row][col];

        str = str.replaceAll("\\[", "").replaceAll("\\]", "");

        String[] s1 = str.split(", ");

        int j = -1;
        for (int i = 0; i < s1.length; i++) {
            if (i % col == 0) {
                j++;
            }
            out[j][i % col] = Double.parseDouble(s1[i]);
            //System.out.println(s1[i] + "\t" + j + "\t" + i % col);
        }
    return out;
    }
}
