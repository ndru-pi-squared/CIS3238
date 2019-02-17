/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Andrew
 */
public interface SimpleOps {//modular design for various calculators. 
                        //start w/ simple operations and work your way up
                        //adding classes for specific functionality(?)
                        //2-3 methods per class. 
                        //Try to use interfaces
    
    public int add(int a, int b);
    
    public int subtract(int a, int b);
    
    public int multiply(int a, int b);
    
    public float divide(int a, int b);
    
}
