package simpleXMLRMI;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Wolfgang
 */
public class ProxyFactory {
    public static Object createProxy(Class clazz) throws IllegalArgumentException {
        InvocationHandler handler = new SimpleRMIInvocationHandler();
        Object proxy = Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[] {clazz},
                handler);
        return proxy;
    }
}
