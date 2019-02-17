/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpleXMLRMI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

/**
 *
 * @author Paul Wolfgang
 */
public class SimpleRMIInvocationHandler implements InvocationHandler {
    
    private HTTPConnectionFactory connectionFactory = new URLHTTPConnectionFactory();
    
    protected void setConnectionFactory(HTTPConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        InputStream in = null;
        OutputStream out = null;
        HttpURLConnection connection = null;
        StringBuilder content = new StringBuilder();
        Object returnValue = null;
        // Construct a MethodCall object
        // Append the XML string of the MethodCall object to the content
        try {
            connection = connectionFactory.getConnection("babyhuey.cis.temple.edu", 
                          "/~wolfgang/cgi-bin/j?-jar+CGIXMLInvoke.jar");
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
            // Read and decode the returned MethodResponse object
            // returnValue =  methodResponse.getResult(); // This may throw and exception.
        } catch (Throwable e) {
            throw e;
        } finally {
            try {if (in != null) in.close();} catch (IOException e) {}
            try {if (out != null) out.close();} catch (IOException e) {}
            if (connection != null) connection.disconnect();
        }
        return returnValue;
    }

}
