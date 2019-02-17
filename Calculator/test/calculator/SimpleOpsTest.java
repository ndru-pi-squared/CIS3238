/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class SimpleOpsTest {
    
    public SimpleOpsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class SimpleOps.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int a = 1;
        int b = 2;
        SimpleOps instance = new SimpleOpsImpl();
        int expResult = 3;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class SimpleOps.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        int a = 0;
        int b = 0;
        SimpleOps instance = new SimpleOpsImpl();
        int expResult = 0;
        int result = instance.subtract(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class SimpleOps.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        int a = 1;
        int b = 2;
        SimpleOps instance = new SimpleOpsImpl();
        int expResult = 2;
        int result = instance.multiply(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class SimpleOps.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        int a = 2;
        int b = 1;
        SimpleOps instance = new SimpleOpsImpl();
        float expResult = 2.0F;
        float result = instance.divide(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class SimpleOpsImpl implements SimpleOps {

        @Override
        public int add(int a, int b){
            return a + b;
        }

        @Override
        public int subtract(int a, int b){
            return a - b;
        }

        @Override
        public int multiply(int a, int b){
            return a * b;
        }

        @Override
        public float divide(int a, int b){
            return (float) a / b;
        }
    }
    
}
