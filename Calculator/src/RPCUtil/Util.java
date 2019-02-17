package RPCUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Util {

    /**
     * Method to find an load a class that implements the specified interface.
     * It is assumed that the desired class is packaged in a .jar file that
     * includes a file in META-INF/services that has the same name as the
     * interface. This file contains a single line that gives the name of the
     * implementing class. A search is first made of the class path for the
     * services resource. If not found, then the current directory is searched
     * for .jar files.
     *
     * @param fullInterfaceName The interface for which the class is sought.
     * @return An object that implements the interface.
     * @throws ClassNotFoundException if no implementing class can be found.
     */
    public static Object findAndLoadClass(String fullInterfaceName) throws ClassNotFoundException {
        String resourceName = "META-INF/services/" + fullInterfaceName;
        Object obj;
        try {
            obj = FindImplementingClass(ClassLoader.getSystemClassLoader(), resourceName);
            return obj;
        } catch (ClassNotFoundException ex) {
            // Ignore for now, we will keep looking
        }
       File localDir = new File(".");
        File[] files = localDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File aFile) {
                return aFile.getName().endsWith(".jar");
            }
        });
        Class clazz;
        for (File file : files) {
            URL url;
            try {
                url = file.toURI().toURL();
            } catch (MalformedURLException ex) {
                throw new Error("toURO().toURL() should always create a valid URL", ex); 
            }
            ClassLoader loader = URLClassLoader.newInstance(new URL[]{url});
            try {
                obj = FindImplementingClass(loader, resourceName);
                return obj;
            } catch (ClassNotFoundException ex) {
                // Ingore for now, we will keep looking
            }
        }
        // Did not find
        throw new ClassNotFoundException(fullInterfaceName);
    }

    /**
     * Method to find, load and instantiate a class implementing an interface.
     * @param loader The class loader to use
     * @param resourceName The sought interface as a subfile of META-INF/services
     * @return An object that implements the sought interface
     * @throws ClassNotFoundException If a class cannot be found
     */
    private static Object FindImplementingClass(ClassLoader loader, String resourceName)
            throws ClassNotFoundException {
        try {
            Object obj = null;
            Class clazz;
            InputStream in = loader.getResourceAsStream(resourceName);
            if (in != null) {
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = r.readLine()) != null) {
                    clazz = loader.loadClass(line);
                    obj = clazz.newInstance();
                    break;
                }
            }
            if (obj != null) {
                return obj;
            } else {
                String interfaceName = resourceName.substring(resourceName.lastIndexOf("/"));
                throw new ClassNotFoundException(interfaceName);
            }
        } catch (IOException | IllegalAccessException | InstantiationException ex) {
            throw new RuntimeException("Unexpected Exception", ex);
        }
    }
}
