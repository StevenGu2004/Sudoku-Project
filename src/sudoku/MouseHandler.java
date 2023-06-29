/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * MouseHandler is a specific class that detects right clicks and removes the
 * Value of the button clicked on
 *@since 2021-11-30
 * @author Steven Gu
 */
public class MouseHandler implements MouseListener{
    private Sudoku game;
    
    /**
     * Constructor of the MouseHandler class
     * @param game takes in an instance of the Sudoku game to use its methods
     */
    public MouseHandler(Sudoku game) {
        this.game = game;
    }


    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON3 && me.getSource() instanceof Button) {
            Button b = (Button)me.getSource();
            if (!b.isDisplayed()) {
                b.clear();
                b.setNum(0);
                game.bHighlight(0);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        // Unused
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
        // Unused
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // Unused
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // Unused
    }
    
}
