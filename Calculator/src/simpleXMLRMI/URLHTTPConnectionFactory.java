package simpleXMLRMI;

import java.net.HttpURLConnection;
import java.net.URL;


public class URLHTTPConnectionFactory implements HTTPConnectionFactory {

    @Override
    public HttpURLConnection getConnection(String host, String resource) {
        try {
            URL url = new URL("http", host, resource);
            return (HttpURLConnection) url.openConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

