/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyHandler collects the values of the keys pressed (numbers) and changes "currentInput" 
 * using "setInput" to the value of the key pressed
 * 
 * @since 2023-06-28
 * @author Steven Gu
 */
public class KeyHandler implements KeyListener{
    private Sudoku game;
    
    /**
     * Constructor of the KeyHandler class
     * @param game takes in an instance of the Sudoku game to use its methods
     */
    public KeyHandler(Sudoku game) {
        this.game = game;
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_1 || keyCode == KeyEvent.VK_NUMPAD1) {
            game.setInput(1);
        }
        if (keyCode == KeyEvent.VK_2 || keyCode == KeyEvent.VK_NUMPAD2) {
            game.setInput(2);
        }        
        if (keyCode == KeyEvent.VK_3 || keyCode == KeyEvent.VK_NUMPAD3) {
            game.setInput(3);
        }        
        if (keyCode == KeyEvent.VK_4 || keyCode == KeyEvent.VK_NUMPAD4) {
            game.setInput(4);
        }
        if (keyCode == KeyEvent.VK_5 || keyCode == KeyEvent.VK_NUMPAD5) {
            game.setInput(5);
        }    
        if (keyCode == KeyEvent.VK_6 || keyCode == KeyEvent.VK_NUMPAD6) {
            game.setInput(6);
        }    
        if (keyCode == KeyEvent.VK_7 || keyCode == KeyEvent.VK_NUMPAD7) {
            game.setInput(7);
        }    
        if (keyCode == KeyEvent.VK_8 || keyCode == KeyEvent.VK_NUMPAD8) {
            game.setInput(8);
        }    
        if (keyCode == KeyEvent.VK_9 || keyCode == KeyEvent.VK_NUMPAD9) {
            game.setInput(9);
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused
    }
}
