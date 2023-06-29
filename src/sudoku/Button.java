/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

// Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
/**
 * Button class which contains information and methods needed for the buttons
 * @since 2021-11-30
 * @author Steven Gu
 */

public class Button extends JButton{
    // Variables
    private int ansNum;
    private boolean displayed;
    private int inputNum;
    
    
    /**
     * Constructor of the Button class
     * Displays buttons that should be initially shown
     * @param ansNum the correct number of the puzzle
     * @param displayed whether or not the ansNum should be displayed
     */
    public Button(int ansNum, boolean displayed) {
        this.ansNum = ansNum;
        this.displayed = displayed;

        this.setPreferredSize(new Dimension(100, 100));
        //this.setBackground(Color.white);
        if (displayed) {
            String strNum = String.valueOf(this.ansNum);
            this.setFont(new Font("Arial", Font.PLAIN, 50));
            this.setText(strNum);        
            this.setBackground(Color.getHSBColor(189/360f, 0.25f, 0.5f));
        } else {
            this.setBackground(Color.getHSBColor(168/360f, 0.25f, 0.7f));
        }
    }
    
    
    // Methods
    /**
     * Getter method for the 'displayed' variable
     * @return boolean displayed
     */
    public boolean isDisplayed() {
        return this.displayed;
    }

    /**
     * Getter method for the 'ansNum' variable
     * @return int ansNum
     */
    public int getAnsNum() {
        return this.ansNum;
    }
    
    /**
     * Setter method for the inputted number to be displayed on the button
     * @param num 
     */
    public void setNum(int num) {
        this.inputNum = num;
    }
    
    /**
     * Getter method for the currently displaying input number of the button
     * @return int inputNum
     */
    public int getNum() {
        return this.inputNum;
    }
    
    /**
     * Method that clears the number displayed on the button
     * Used in preparation of the win screen
     */
    public void clear() {
        this.setText("");
    }
    
    /**
     * Method that shows the numbers inputted onto the button by setting
     * the text to the inputNum
     */
    public void clicked() {
        String strNum = String.valueOf(this.inputNum);
        this.setFont(new Font("Arial", Font.PLAIN, 50));
        this.setText(strNum);
    }
    
    
}
