
package sudoku;

// Imports
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * Classic Sudoku game with a special win-screen that turns the game
 * into a white board for pixel art
 * 
 * Puzzle link (intermediate puzzle)
 * https://sandiway.arizona.edu/sudoku/examples.html 
 * @since 2021-11-30
 * @author Steven Gu
 */
public class Sudoku extends JFrame{
    
    // Constructor (using super() to name the JFrame)
    public Sudoku(){
        super("Sudoku");
    }
    
    
    // Fields    
    // Panel containing the 9 3x3buttonPanels
    // initiated here so it could be accessed later in other Sudoku methods
    JPanel gamePanel = new JPanel();
    private int currentInput;   
    private Color currentColor = Color.WHITE;
    
    
    // Arrays
    private static final int[][] numsArray = {
                            {1,2,3,6,7,8,9,4,5},
                            {5,8,4,2,3,9,7,6,1},
                            {9,6,7,1,4,5,3,2,8},
                            {3,7,2,4,6,1,5,8,9},
                            {6,9,1,5,8,3,2,7,4},
                            {4,5,8,7,9,2,6,1,3},
                            {8,3,6,9,2,4,1,5,7},
                            {2,1,9,8,5,7,4,3,6},
                            {7,4,5,3,1,6,8,9,2}};
    private static final boolean[][] booleanArray = {
                                    {false,true,false,true,false,true,false,false,false},
                                    {true,true,false,false,false,true,true,false,false},
                                    {false,false,false,false,true,false,false,false,false},
                                    {true,true,false,false,false,false,true,false,false},
                                    {true,false,false,false,false,false,false,false,true},
                                    {false,false,true,false,false,false,false,true,true},
                                    {false,false,false,false,true,false,false,false,false},
                                    {false,false,true,true,false,false,false,true,true},
                                    {false,false,false,true,false,true,false,true,false}};
    private static final Color[] colorArray = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.BLACK, Color.WHITE};
    private Button[][] buttonArray = new Button[9][9];
    private PadButton[] padArray = new PadButton[9];
    private ArrayList buttonPanelArray = new ArrayList(9);
    private boolean[][] testArray = new boolean[9][9];   //For Testing win
    private boolean checkWin = false;   // Change to true for checking winning screen
    private boolean displayed;
    
    
    // Helpter Methods
    /**
     * Setter method for Sudoku variable 'currentColor'
     * @param color The color to be set as the new 'currentColor'
     */
    public void setColor(Color color) {
        this.currentColor = color;
    }
    /** 
    * Getter method for Sudoku variable 'currentInput'
    * @return int currentInput
    */
    public int getInput() {
        return currentInput;
    }
    /**
     * Setter method for Sudoku variable 'currentInput'
     * @param num The input that will be set as the new 'currentInput'
     */
    public void setInput(int num) {
        this.currentInput = num;
    }
    
    /**
     * Method that create the GUI of the program
     * Makes the buttons and panels needed for the game 
     */
    private void createGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Border blackline = BorderFactory.createLineBorder(Color.black, 2);
        GridLayout panelLayout = new GridLayout(3,3);
        gamePanel.setLayout(panelLayout);
        this.setFocusable(true);
        ActionHandler ah = new ActionHandler(this);
        MouseHandler mh = new MouseHandler(this);
        KeyHandler kh = new KeyHandler(this);
        this.addKeyListener(kh);
        
        // For loop for creating button panels
        for (int r = 0; r<3; r++){
            for (int c = 0; c<3; c++){
                JPanel buttonPanel = new JPanel();
                // Button panels are stored in buttonPanelArray to be used later
                buttonPanelArray.add(buttonPanel);
                GridLayout buttonLayout = new GridLayout(3,3);
                buttonPanel.setLayout(buttonLayout);
                
                // For loop for creating buttons
                for (int i = 0; i<3; i++){
                    for (int j = 0; j<3; j++){
                        int ansNum = numsArray[r*3 + i][c*3 + j];
                        if (checkWin) {
                            displayed = testArray[r*3 + i][c*3 + j];
                        } else {
                            displayed = booleanArray[r*3 + i][c*3 + j];
                        }
                        Button b = new Button(ansNum, displayed);
                        b.addActionListener(ah);
                        b.addMouseListener(mh);
                        b.setFocusable(true);
                        b.addKeyListener(kh);
                        // Adding buttons to buttonArray to be used later
                        buttonArray[r*3 + i][c*3 + j] = b;
                        buttonPanel.add(b);  
                    }
                }
                buttonPanel.setBorder(blackline);   
                gamePanel.add(buttonPanel);
            }
        }
        gamePanel.setBorder(blackline); 
        this.add(gamePanel);
        this.pack();

        // Creating the numpad buttons   
        Border whiteline = BorderFactory.createLineBorder(Color.WHITE, 4);
        JPanel padButtonPanel = new JPanel();
        GridLayout padButtonLayout = new GridLayout(3,3);
        padButtonPanel.setLayout(padButtonLayout);
        for (int i = 0; i < 9; i++) {
            int num = i+1;
            PadButton b = new PadButton(num);
            padButtonPanel.add(b);
            b.addActionListener(ah);
            // adding the pad buttons to padArray for later use
            padArray[i] = b;
        }
        padButtonPanel.setBorder(whiteline);
        
        // Full panel: contains both the sudoku game panel and numpad panel 
        JPanel fullPanel = new JPanel();
        FlowLayout fullLayout = new FlowLayout();
        fullPanel.setLayout(fullLayout);
        fullPanel.add(gamePanel);
        fullPanel.add(padButtonPanel);
        fullPanel.setBackground(Color.getHSBColor(123/360f,.32f, 89f));
        this.add(fullPanel);
        this.pack();
    }
    
    /**
     * Method for changing the number to be displayed on the button
     * @param b takes in the button
     */
    public void changeNum(Button b) {
        if (!b.isDisplayed()) {
            b.setNum(currentInput);  
            b.clicked();
        }
    }
    
    /**
     * Method for changing the color to be displayed on the button
     * @param b takes in the button
     */
    public void changeColor(Button b) {
        b.setBackground(currentColor);
    }
    /**
     * Method for checking whether or not the game has been won 
     * By comparing the value of the button to the key from the numsArray
     * @return boolean won
     */
    public boolean hasWon() {
        boolean won = true;
        for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                Button b = buttonArray[r][c];
                if (checkWin) {
                    if (!testArray[r][c]) {    
                        if (b.getNum() != numsArray[r][c]) {
                            won = false;
                        }
                    }
                } else {
                    if (!booleanArray[r][c]) {    // CHANGE TO booleanArray WHEN DONE CHECKING WIN
                        if (b.getNum() != numsArray[r][c]) {
                            won = false;
                        }
                    }
                }

            }
        }
        return won;
    }
    
    /**
     * Method for clearing all the numbers showing on the buttons and 
     * Pad buttons in preparation for the win screen
     */
    public void clearNums() {
        for (int i = 0; i<9; i++) {
            PadButton pb = padArray[i];
            pb.clear();
            for (int j = 0; j<9; j++) {
                Button b = buttonArray[i][j];
                b.clear();
            }
        }
    }
    
    /**
     * Method that sets the colors assigned to the pad buttons 
     */
    public void padColors() {
        for (int i=0; i<9; i++) {
            PadButton b = padArray[i];
            b.setPadColor(colorArray[i]);
            b.setBackground(colorArray[i]);
        }
    }
    
    /**
     * Method to clear all the borders around the panels and buttons in 
     * Preparation for the win screen
     */
    public void clearBorders() {
        gamePanel.setBorder(null);
        this.remove(gamePanel);

        for (int i =0; i<9; i++) {
            JPanel panel = (JPanel)buttonPanelArray.get(i);
            panel.setBorder(null);
            this.remove(panel);
        }

        for (int j=0; j<9;j++) {
            for (int k=0; k<9; k++) {
                Button b = buttonArray[j][k];
                b.setBorder(null);
            }
        }        
    }
    
    /**
     * Method that removes the background color of the buttons once the game 
     * Has been won
     */
    public void clearColors() {
        for (int j=0; j<9;j++) {
            for (int k=0; k<9; k++) {
                Button b = buttonArray[j][k];
                b.setBackground(Color.WHITE);
            }
        }     
    }
    
    /**
     * Method that highlights all existing number on the screen that are 
     * The same and un-highlights all other numbers
     * Method is ran every time a button is pressed
     * @param num the number displayed at the button pressed
     */
    public void bHighlight(int num) {
        for (int j=0; j<9;j++) {
            for (int k=0; k<9; k++) {
                Button b = buttonArray[j][k];
                if (b.isDisplayed()) {
                    if (b.getAnsNum() == num) {
                        b.setForeground(Color.WHITE);
                    } else {
                        b.setForeground(Color.BLACK);
                    }
                } else {
                    if (b.getNum() == num) {
                        b.setForeground(Color.WHITE);
                    } else {
                        b.setForeground(Color.BLACK);
                    }
                }
                
            }
        }     
    }
    
    /**
     * The main method that first initiates the program by running the 
     * 'createGUI() method 
     * (contains commented out code used for testing)
     * @param args command line arguments
     */
    public static void main(String[] args){
        Sudoku game = new Sudoku();  
        // Code used for testing
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                
                game.testArray[r][c] = true;
                
                if (booleanArray[r][c]){
                    System.out.print(numsArray[r][c]+" ");
                }else{
                    System.out.print("` ");
                }
            }
            System.out.println();
        }       
        //game.testArray[8][8] = true;  // just for test array generation
        game.createGUI();   
        }
    }
    

