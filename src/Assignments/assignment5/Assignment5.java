//Austin O'Boyle 10147479
//Austin wrote this code.
//This program just contains the main function
//Majority of code is in MainPanel.java

package assignment5;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Austin O'Boyle
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
              UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
            
        } catch (Exception ex) {
            System.out.println("Not found.");        
        } 
        // create a  top level window
        JFrame frame = new JFrame("Market Checkout");
        frame.setSize(1000, 400);
        frame.setLocationRelativeTo(null);
        
        frame.add(new MainPanel());  
        
        // define close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show frame
        frame.setVisible(true);
    }
    
}
