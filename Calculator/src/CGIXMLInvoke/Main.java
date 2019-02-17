package CGIXMLInvoke;

import edu.temple.cis.c3238.methodcall.MethodResponse;

public class Main {

    public static void main(String[] args) {
        Class resultType = null;
        Object result = null;
        try {
            // Insert code to read and decode the method call XML file from System.in
            // Find and load a class that implements the interface
            // Find the method that matches the methodName and paramTypes
            // Set the resultType from the method
            // Call the method storing the result in result
        } catch (Throwable ex) {
            resultType = ex.getClass();
            result = ex;
        } finally {
            outputResult(resultType,result);
        }
    }

    private static void outputResult(Class resultType, Object result) {
        StringBuilder stb = new StringBuilder();
        MethodResponse methodResponse = new MethodResponse(resultType, result);
        stb.append(methodResponse.toXML());
        stb.append("\r\n");
        System.out.print("Content-Type: text/plain\r\n");
        System.out.print("Content-Length: " + stb.length());
        System.out.print("\r\n\r\n");
        System.out.print(stb.toString());
    }

}
