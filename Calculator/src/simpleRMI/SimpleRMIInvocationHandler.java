package simpleRMI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * InvocationHandler that uses a simple RMI protocol to delegate the
 * invocation of proxy methods.
 * @author Paul Wolfgang
 * Modified by Andrew D. Pitt
 * Adapted to support matrix multiplication and addition
 */
public class SimpleRMIInvocationHandler implements InvocationHandler {
    
    private final URL url;
    
    public SimpleRMIInvocationHandler(URL url) {
        this.url = url;
    }

    /**
     * Method to invoke a proxy method by passing the complete method
     * name and two int parameters to the remote computer.
     * @param proxy The proxy object on which the method was invoked
     * @param method The Method object representing the method being invoked
     * @param args An array of actual arguments. (Primitive types are their
     * corresponding wrapper objects).
     * @return The result of invoking the method on a actual object in the
     * remote computer.
     * @throws Throwable Any exception thrown from the remote computer (indicated
     * by a String return that is not convertible to an int) or
     * any exception thrown during the process of communicating with the
     * remote computer.
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        BufferedReader br = null;
        String sResult = null;
        Object returnValue = null;
        InputStream in = null;
        OutputStream out = null;
        HttpURLConnection connection = null;
        StringBuilder content = new StringBuilder();
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName().trim();
        content.append(className).append(".").append(methodName).append("\r\n");
        if(args[0].toString().length()>2){//if the arg is longer than 2 (in our case it will be a matrix if len>2)
            double[][] a = (double[][])args[0];
            double[][] b = (double[][])args[1]; 
            content.append(Arrays.deepToString(a)); //lets try this instead. Unzip using stringToDeep(String s); on server side
            content.append(Arrays.deepToString(b));
        }
        else{//if it's not longer than 2, then it must be an int and a newline, so use compute's version
            for (Object arg:args) {//this simply appends ints
            content.append(arg).append("\r\n");
            }
            
        }
        
        //System.out.println(content);//verify content before sending
        //send the content
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setFixedLengthStreamingMode(content.length());
            connection.connect();
            out = connection.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            pw.print(content);
            pw.flush();
            
            in = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            sResult = br.readLine();
            //System.out.println("test");
            if(args[0].toString().length()>2){//if its a matrix
                //System.out.println("THE RESULT: " + sResult);//string form
                sResult += "\n";
                double[][] test = stringToDeep(sResult);
                returnValue = (double[][]) test;
            }
            else{//if its compute
                int result = Integer.parseInt(sResult);
                returnValue = new Integer(result);
                
            }
            
        } catch (NumberFormatException nf) {
            StringBuilder stb = new StringBuilder(sResult);
            stb.append("\r\n");
            while ((sResult = br.readLine()) != null) {
                stb.append(sResult).append("\r\n");
            }
            throw new Exception(stb.toString());//sresult is null
        } catch (IOException e) {
            throw e;
        } finally {
            try {if (in != null) in.close();} catch (IOException e) {}
            try {if (out != null) out.close();} catch (IOException e) {}
            if (connection != null) connection.disconnect();
        }
        return returnValue;
    }
    private static double[][] stringToDeep(String str) { //reverse of deepToString()
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
