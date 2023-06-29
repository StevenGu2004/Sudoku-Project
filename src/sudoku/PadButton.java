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
 * PadButton class which contains information and methods needed for the pad
 * Buttons
 *@since 2021-11-30
 * @author Steven Gu
 */
public class PadButton extends JButton{
    
    // Variables
    private int padNum;    
    private Color padColor;
    
    
    /**
     * Constructor of the PadButton class
     * Displays the pad buttons
     * @param padNum the number this padButton is assigned
     */
    public PadButton(int padNum) {
        this.padNum = padNum;
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.white);
        String strNum = String.valueOf(padNum);
        this.setFont(new Font("Arial", Font.PLAIN, 50));
        this.setText(strNum);
    }    

    
    // Methods
    /**
     * Getter method for the 'padColor' variable
     * @return Color padColor
     */
    public Color getPadColor() {
        return this.padColor;
    }
    
    /**
     * Setter method for the variable 'padColor'
     * @param color the color this pad button is assigned to
     */
    public void setPadColor(Color color) {
        this.padColor = color;
    }
    
    /**
     * Getter method for the 'padNum' variable
     * @return int padNum
     */
    public int getPadNum() {
        return this.padNum;
    }
    
    /**
     * Method that clears the number displayed on the pad button
     */
    public void clear() {
        this.setText("");
    }
}
