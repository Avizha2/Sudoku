package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class GUI extends JFrame {
	public static final int G_SIZE = 9;    // Size of the board
	public static final int SUBG_SIZE = 3; // Size of the sub-grid
	 
	// Name-constants for UI control (sizes, Colors and fonts)
	public static final int C_SIZE = 60;   // Cell width/height in pixels
	public static final int WIDTH  = C_SIZE * G_SIZE;
	public static final int HEIGHT = C_SIZE * G_SIZE;
	                                             // Board width/height in pixels
	public static final Color OPEN_CELL_BGCOlOR = Color.YELLOW;
	public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  // RGB
	public static final Color OPEN_CELL_TEXT_NO = Color.RED;
	public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
	public static final Color CLOSED_CELL_TEXT = Color.BLACK;
	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
	 
	// The game board composes of 9x9 JTextFields,
	// each containing String "1" to "9", or empty String
	private JTextField[][] tfCells = new JTextField[G_SIZE][G_SIZE];
	 
	public GUI() {
		//
	}

	   public GUI(SudokuBoard s) {
	      Container con = getContentPane();
	      con.setLayout(new GridLayout(G_SIZE, G_SIZE));  // 9x9 GridLayout
	 
	      // Allocate a common listener as the ActionEvent listener for all the
	      //  JTextFields
	      InputListener listener = new InputListener();
	 
	      // Construct 9x9 JTextFields and add to the content-pane
	      for (int i = 0; i < G_SIZE; ++i) {
	         for (int j = 0; j < G_SIZE; ++j) {
	            tfCells[i][j] = new JTextField(); // Allocate element of array
	            con.add(tfCells[i][j]);            // ContentPane adds JTextField
	            if (s.board[i][j].hidden) {
	               tfCells[i][j].setText("");     // set to empty string
	               tfCells[i][j].setEditable(true);
	               tfCells[i][j].setBackground(OPEN_CELL_BGCOlOR);
	 
	               // Add ActionEvent listener to process the input
	               tfCells[i][j].addActionListener( listener);
	            } else {
	               tfCells[i][j].setText(s.board[i][j].num + "");
	               tfCells[i][j].setEditable(false);
	               tfCells[i][j].setBackground(CLOSED_CELL_BGCOLOR);
	               tfCells[i][j].setForeground(CLOSED_CELL_TEXT);
	            }
	            // Beautify all the cells
	            tfCells[i][j].setHorizontalAlignment(JTextField.CENTER);
	            tfCells[i][j].setFont(FONT_NUMBERS);
	         }
	      }
	 
	      // Set the size of the content-pane and pack all the components
	      //  under this container.
	      con.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	      pack();
	 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
	      setTitle("Sudoku");
	      setVisible(true);
	   }
	 
	   // Define the Listener Inner Class
	   private class InputListener implements ActionListener {
	           
	        private int numberIn;
	        int counter = 0;
	        int j = 0;
	        int i = 0;
	          public void actionPerformed(ActionEvent e, SudokuBoard s) {
	             // All the 9*9 JTextFileds invoke this handler. We need to determine
	             // which JTextField (which i and jumn) is the source for this invocation.
	             int x = -1;
	             int y = -1;
	     
	             // Get the source object that fired the event
	             JTextField source = (JTextField)e.getSource();
	             // Scan JTextFileds for all is and jumns, and match with the source object
	             boolean found = false;
	             for (int i = 0; i < G_SIZE && !found; ++i) {
	                for (int j = 0; j < G_SIZE && !found; ++j) {
	                   if (tfCells[i][j] == source) {
	                      x = i;
	                      y = j;
	                      found = true;  // break the inner/outer loops
	                   }
	                }
	             }
	              
	            numberIn = Integer.parseInt(tfCells[x][y].getText());
	            if ((char) (numberIn + 48) == s.board[x][y].num) {
	                tfCells[x][y].setBackground(Color.GREEN);
	                s.board[x][y].hidden = false;
	                }
	            else {
	                tfCells[x][y].setBackground(Color.RED);
	            }	                   
	            counter = 0;
	            for (i = 0;i < 9;i++) {
	                for (j = 0;j < 9;j++) {
	 
	                    if (s.board[i][j].hidden == true){
	                        break;
	                    }
	                    else{
	                       
	                        counter++;
	                    }
	                } 
	            }
	            if(counter == 81){
	                JOptionPane.showMessageDialog(null, "Congratulations!");
	            }
	 
	          }
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
	       }
	}

