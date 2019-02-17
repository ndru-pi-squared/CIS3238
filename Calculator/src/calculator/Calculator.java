/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import javax.swing.*;
/**
 *
 * Author: Andrew D Pitt.
 * NO MATH LIBRARIES ALLOWED. EVERYTHING IS IN-HOUSE
 * developed using TDD and highly modular code 
 * Calculator will scrub input? (secure--prevent scripting when i upload it to public facing domain) and then parse the input to compute the expression
 * It will handle a wide range of expressions: simple operations, square root (program newtons method?), exponents, algebraic expressions,
 * matrix ops, integrals, derivatives, and possibly applications of graph theory like shortest path
 * root finder, series/sequence stuff,
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        JPanel p = new JPanel(new GridLayout(5,4));
        final int WINDOW_WIDTH = 300;
        final int WINDOW_HEIGHT = 400;
        JFrame window = new JFrame();
        window.setTitle("Simple Calculator");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocation(300,200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea(10, 5);//create text area
        addButtons(p,textArea);
        window.getContentPane().add(BorderLayout.NORTH, textArea);//add a text area in the center of content
        window.getContentPane().add(BorderLayout.CENTER, p);//add a text area in the center of content
        //final JButton button = new JButton("Click Me"); //create jbutton and set text
        //window.getContentPane().add(GridLayout.SOUTH, button);//add a button on the bottom of content
        /**/
        
        window.setVisible(true);   //jframe stuff
    }
    
    public static void addButtons(JPanel panel, final JTextArea textArea) {
        JButton[][] buttons = new JButton[5][4];
        for (int k = 0; k < 5; k++) {
            for (int j = 0; j < 4; j++) {
                if (k == 0 && j == 0){
                    buttons[k][j] = new JButton("AC");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.setText("");
                        }
                    });
                }
                else if (k == 0 && j ==1){
                    buttons[k][j] = new JButton("N/A ");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //textArea.setText("N/A");
                        }
                    });
                }
                else if (k == 0 && j ==2){
                    buttons[k][j] = new JButton("^");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("^");
                        }
                    });
                }
                else if (k == 0 && j ==3){
                    buttons[k][j] = new JButton("/");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("/");
                        }
                    });
                }
                else if (k == 1 && j ==0){
                    buttons[k][j] = new JButton("7");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("7");
                        }
                    });
                }
                    
                else if (k == 1 && j ==1){
                    buttons[k][j] = new JButton("8");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("8");
                        }
                    });
                }
                else if (k == 1 && j ==2){
                    buttons[k][j] = new JButton("9");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("9");
                        }
                    });
                }
                else if (k == 1 && j ==3){
                    buttons[k][j] = new JButton("*");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("*");
                        }
                    });
                }
                else if (k == 2 && j ==0){
                    buttons[k][j] = new JButton("4");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("4");

                        }
                    });
                }
                else if (k == 2 && j ==1){
                    buttons[k][j] = new JButton("5");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("5");
                        }
                    });
                }
                else if (k == 2 && j ==2){
                    buttons[k][j] = new JButton("6");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("6");
                        }
                    });
                }
                else if (k == 2 && j ==3){
                    buttons[k][j] = new JButton("-");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("-");
                        }
                    });
                }
                else if (k == 3 && j ==0){
                    buttons[k][j] = new JButton("1");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("1");
                        }
                    });
                }
                else if (k == 3 && j ==1){
                    buttons[k][j] = new JButton("2");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("2");
                        }
                    });
                }
                else if (k == 3 && j ==2){
                    buttons[k][j] = new JButton("3");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("3");
                        }
                    });
                }
                else if (k == 3 && j ==3){
                    buttons[k][j] = new JButton("+");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("+");
                        }
                    });
                }
                else if (k == 4 && j ==0){
                    buttons[k][j] = new JButton("0");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("0 ");
                        }
                    });
                }
                else if (k == 4 && j ==1){
                    buttons[k][j] = new JButton(".");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append(". ");
                        }
                    });
                }
                else if (k == 4 && j ==2){
                    buttons[k][j] = new JButton("N/A");
                    buttons[k][j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textArea.append("N/A ");
                        }
                    });
                }
                else if (k == 4 && j ==3){
                    buttons[k][j] = new JButton("=");
                    buttons[k][j].addActionListener(new ActionListener() {
                        
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //go through the array backwards, scooping up all the input and computing its expression
                            String s = textArea.getText();
                            //int result = 0;
                            float floatResult = 0.0f;
                            int i = 0;
                            SimpleOps simpleopsInstance = new SimpleOpsImpl();
                            //ADD EXPONENT ^
                            while (i < s.length()){ //check for * 
                                if(s.charAt(i) == '*'){ //use simpleops here
                                    
                                    try{floatResult = (float) simpleopsInstance.multiply(Integer.parseInt(Character.toString(s.charAt(i-1))), Integer.parseInt(Character.toString(s.charAt(i+1))));}
                                    catch(Exception E){}
                                }
                                i++;
                            }//end while
                            System.out.println(floatResult);
                            i = 0;
                            while (i < s.length()){ //check for /
                                if(s.charAt(i) == '/'){//use simpleops here
                                    try{floatResult = (float) simpleopsInstance.divide(Integer.parseInt(Character.toString(s.charAt(i-1))), Integer.parseInt(Character.toString(s.charAt(i+1))));}
                                    catch(Exception E){}
                                }
                                i++;
                            }//end while
                            System.out.println(floatResult);
                            i = 0;
                            while (i < s.length()){ //check for +. in exp like 6+2+2 it gives 4 since it goes around until the end of hte string
                                if(s.charAt(i) == '+'){//use simpleops here
                                    try{floatResult = (float) simpleopsInstance.add(Integer.parseInt(Character.toString(s.charAt(i-1))), Integer.parseInt(Character.toString(s.charAt(i+1))));}
                                    catch(Exception E){}
                                }
                                i++;
                            }//end while 
                            System.out.println(floatResult);
                            i = 0;
                            while (i < s.length()){ //check for -
                                if(s.charAt(i) == '-'){//use simpleops here
                                    //result = result + (Integer.parseInt(s.charAt(i-1)+"") - Integer.parseInt(s.charAt(i+1)+""));
                                    try{floatResult = (float) simpleopsInstance.subtract(Integer.parseInt(Character.toString(s.charAt(i-1))), Integer.parseInt(Character.toString(s.charAt(i+1))));}
                                    catch(Exception E){} 
                                }
                                i++;
                            }
                            System.out.println(floatResult);
                            textArea.setText(Float.toString(floatResult));      
                        }
                    });
                }   
                panel.add(buttons[k][j]);
                //options here are: 1. append all here as strings, read strings in as number or operation and act accordingly
                //2. find a way to compute the expression within the onlicklistener
                //#if I simply put an expression into its proper form to be computed, java will take care of order of operations
            }   //for 0 through 9 we can just do textArea.getText(), and thenw ork with it in an array?
                
                //arraystack: array of methods (add/sub/div/mult), array of floats or ints whatever im using an output
            
        }
    }
}
    

