/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

// Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionHandler class which controls the actions needed when a button or
 * A pad button is pressed
 * @since 2021-11-30
 * @author Steven Gu
 */
public class ActionHandler implements ActionListener{
    // Variable
    private Sudoku game;
    private boolean won;
        
    
    /** 
     * Constructor of the ActionHandler class
     * @param game an instance of the Sudoku game that grants 
     * The ActionHandler the methods inside the Sudoku class
     */
    public ActionHandler(Sudoku game) {
        this.game = game;
    }

    /**
     * Method that will use checks based on the type that was clicked and the 
     * State of the game to perform actions for the game
     * @param ae keeps track of the action event which has information on the 
     * type of object being clicked
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // When getInput == 0 (null) no pad button has been pressed yet, meaning
        // The player shouldn't be able to click on any buttons
        
        if (ae.getSource() instanceof Button && game.getInput() != 0) {
            Button b = (Button)ae.getSource();
            game.changeNum(b);
            if (game.hasWon()) {
                won = true;
                // Game Screen preparations
                game.clearNums();
                game.padColors();
                game.clearColors();
                game.clearBorders();
                game.setInput(0);
                game.setTitle("Paint");
                
            }
        } 
        if (ae.getSource() instanceof PadButton && !won) {
            PadButton b = (PadButton)ae.getSource();
            game.setInput(b.getPadNum());
        } 
        if (ae.getSource() instanceof PadButton && won) {
            PadButton b = (PadButton)ae.getSource();
            game.setColor(b.getPadColor());
        }
        if (ae.getSource() instanceof Button && won) {
            Button b = (Button)ae.getSource();
            game.changeColor(b);
        }
        if (ae.getSource() instanceof Button && !won) {
            Button b = (Button)ae.getSource();
            if (b.isDisplayed()) {
                game.bHighlight(b.getAnsNum());
            } else {
                game.bHighlight(b.getNum());
            }
        }
    }
    
}
