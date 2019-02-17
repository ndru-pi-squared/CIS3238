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
public class SimpleOpsImpl implements SimpleOps{
    
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
