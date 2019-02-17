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
public class SimpleOpsImplTest {
    
    public SimpleOpsImplTest() {
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
     * Test of add method, of class SimpleOpsImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int a = 0;
        int b = 0;
        SimpleOpsImpl instance = new SimpleOpsImpl();
        int expResult = 0;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class SimpleOpsImpl.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        int a = 0;
        int b = 0;
        SimpleOpsImpl instance = new SimpleOpsImpl();
        int expResult = 0;
        int result = instance.subtract(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class SimpleOpsImpl.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        int a = 0;
        int b = 0;
        SimpleOpsImpl instance = new SimpleOpsImpl();
        int expResult = 0;
        int result = instance.multiply(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class SimpleOpsImpl.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        int a = 0;
        int b = 0;
        SimpleOpsImpl instance = new SimpleOpsImpl();
        float expResult = 0.0F;
        float result = instance.divide(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
