package computeExample;

import compute.Compute;
import simpleXMLRMI.ProxyFactory;

/**
 *
 * @author Paul Wolfgang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Compute compute = (Compute)ProxyFactory.createProxy(Compute.class);
        assert 12 == compute.add(5, 7);
        assert -2 == compute.sub(5, 7);
        assert 35 == compute.mul(5, 7);
        assert 7 == compute.div(35, 5);
        try {
            int x = compute.div(10, 0);
            assert false;
        } catch (Exception ex) {
            assert true;
        }
    }
    
}
