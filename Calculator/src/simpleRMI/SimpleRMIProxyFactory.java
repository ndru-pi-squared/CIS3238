package simpleRMI;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Factory to create a SimpleRMIProxy
 *
 * @author Paul Wolfgang
 */
public class SimpleRMIProxyFactory {

    /**
     * Create a SimpleRMIProxy object. The proxy will pass all method calls to
     * the SimpleRMIInvocationHandler.
     *
     * @param clazz The interface to be implemented by the proxy.
     * @param host The host name of the remote computer
     * @param  userName The userName on the remote computer to process
     * the that has the CGI handler
     * @return A proxy object that implements this class.
     * @throws IllegalArgumentException if any of the restrictions on the
     * parameters that may be passed to Proxy.getProxyClass are violated
     * @throws NullPointerException of the clazz parameter is null.
     * @throws Error if an unknown protocol is passed to the
     * URL constructor (Should never happen.)
     */
    public static Object createProxy(Class clazz, String host, String userName){
        URL url = null;
        try {
            url = new URL("http", host, 
                          "/~" + userName + "/cgi-bin/j?-jar+CGIInvoke.jar");
        } catch (MalformedURLException ex) {
            throw new Error("Unexpected Exception", ex);
        }
        return Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new SimpleRMIInvocationHandler(url));
    }
}
