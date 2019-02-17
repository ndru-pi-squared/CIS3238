/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleXMLRMI;


import java.net.HttpURLConnection;

/**
 *
 * @author Paul Wolfgang
 */
public interface HTTPConnectionFactory {
    
    
    HttpURLConnection getConnection(String host, String resource);
    
}
