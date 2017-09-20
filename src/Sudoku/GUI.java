package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUI extends JFrame {
	public static final int WIDTH  = 60 * 9;
	public static final int HEIGHT = 60 * 9;
	 
	private JTextField[][] cell = new JTextField[9][9];
	 
	public GUI() {
		//
	}
	public GUI(SudokuBoard s) {
	  Container con = getContentPane();
	  con.setLayout(new GridLayout(9, 9));  
	  logic listener = new logic();
	  listener.setBoard(s);
	      for (int i = 0; i < 9; ++i) {
	         for (int j = 0; j < 9; ++j) {
	            cell[i][j] = new JTextField(); 
	            con.add(cell[i][j]);            
	            if (s.board[i][j].hidden) {
	               cell[i][j].setText("");     
	               cell[i][j].setEditable(true);
	               cell[i][j].setBackground(Color.GRAY);
	               cell[i][j].addActionListener( listener);
	               
	            } else {
	               cell[i][j].setText(s.board[i][j].num + "");
	               cell[i][j].setEditable(false);
	               cell[i][j].setBackground(Color.WHITE);
	               cell[i][j].setForeground(Color.BLACK);
	            }
	            
	            cell[i][j].setHorizontalAlignment(JTextField.CENTER);
	         }
	      }
	      con.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	      pack();
	 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	      setTitle("Sudoku Game");
	      setVisible(true);
	   }
	   private class logic implements ActionListener {
	           
	        private int numberIn;
	        int counter = 0;
	        int j = 0;
	        int i = 0;
	        SudokuBoard s;
	        
	        public void setBoard(SudokuBoard x)
	        {
	        	s = x;
	        }
	        public void actionPerformed(ActionEvent e) {
	             int x = -1;
	             int y = -1;
	             JTextField source = (JTextField)e.getSource();
	             boolean found = false;
	             for (int i = 0; i < 9 && !found; ++i) {
	                for (int j = 0; j < 9 && !found; ++j) {
	                   if (cell[i][j] == source) {
	                      x = i;
	                      y = j;
	                      found = true;  
	                   }
	                }
	             }
	            numberIn = Integer.parseInt(cell[x][y].getText());
	            if ((char) (numberIn + 48) == s.board[x][y].num) {
	                cell[x][y].setBackground(Color.GREEN);
	                s.board[x][y].hidden = false;
	                }
	            else {
	                cell[x][y].setBackground(Color.RED);
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
	                JOptionPane.showMessageDialog(null, "Congratulations! You beat the game.");
	            }
	          }
	       }
	}

