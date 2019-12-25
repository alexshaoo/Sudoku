package sudoku;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sudoku extends JFrame {
	
	int[][] solved = {	
			 		 {1, 6, 8, 7, 2, 5, 9, 3, 4}, 
			 		 {7, 9, 3, 6, 4, 8, 2, 1, 5}, 
			 		 {4, 2, 5, 1, 3, 9, 7, 6, 8}, 
			 		 {6, 5, 7, 8, 9, 4, 1, 2, 3}, 
			 		 {3, 4, 2, 5, 6, 1, 8, 9, 7}, 
			 		 {8, 1, 9, 2, 7, 3, 5, 4, 6}, 
			 		 {5, 3, 4, 9, 1, 7, 6, 8, 2}, 
			 		 {9, 7, 6, 4, 8, 2, 3, 5, 1}, 
			 		 {2, 8, 1, 3, 5, 6, 4, 7, 9}
			 		 };

	boolean[][] isShown = {
				  		  {false, false, false, false, true , true , true , false, true }, 
				  		  {false, false, true , true , false, false, false, true , true }, 
				  		  {true , false, false, false, true , false, true , true , false}, 
				  		  {false, false, true , true , false, true , false, false, false}, 
				  		  {true , false, false, false, false, false, false, false, true }, 
				  		  {false, false, false, true , false, true , true , false, false}, 
				  		  {false, true , true , false, true , false, false, false, true }, 
				  		  {true , true , false, false, false, true , true , false, false},
				  		  {true , false, true , true , true , false, false, false, false}
				  		  };
	
	// Integer player is currently entering / has stored
	int valueStored;
	
	public int getValueStored() {
		return valueStored;
	}
	
	public void setValueStored(int newValue) {
		valueStored = newValue;
	}
	
	// Prints puzzle in grid form
	public static void printBoard(int[][] arr, boolean[][] shown) {
		System.out.println("-------------------------------------");
		for (int row = 0; row < 9; row++) {
			System.out.print("| ");
			for (int column = 0; column < 9; column++) {
				if (shown[row][column] == true) {
					System.out.print(arr[row][column]);
				} else {
					System.out.print(" ");
				}
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("-------------------------------------");
		}
	}
	
	// Check to see if puzzle is solved by comparing 
	// the values that each button is supposed to display with the actual value that the button displays
	public boolean isSolved(GameBoardButton[][] buttons) {
		boolean isMatching = true;
		for (GameBoardButton[] buttonRow: buttons) {
			for (GameBoardButton button: buttonRow) {
				if (button.value != button.valueShown) {
					isMatching = false;
				}
			}
		}
		return isMatching;
	}
	
	public Sudoku() {
		super("Sudoku");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		// JPanel that holds all game board's buttons
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(3, 3));
		
		// 3x3 array of JPanels
		JPanel[][] grids = new JPanel[3][3];
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				Grid grid = new Grid(solved, isShown, row, column, this);
				grids[row][column] = grid;
				container.add(grid);
			}
		}
		
		// JPanel that holds the numberPad, from 1 - 9
		JPanel numberPad = new JPanel();
		numberPad.setLayout(new GridLayout(3, 3));
		for (int number = 1; number < 10; number++) {
			numberPad.add(new NumberPadButton(number, this));
			
		}
		
		// Adding panels and buttons to frame, setting padding
		this.add(numberPad, BorderLayout.EAST);
		this.add(container, BorderLayout.WEST);
		this.add(new ClearValueButton(this), BorderLayout.SOUTH);
		container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		numberPad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		container.setVisible(true);
		numberPad.setVisible(true);
		this.setVisible(true);
		
		this.pack();
	}
	
	public static void main(String[] args) {
		Sudoku game = new Sudoku();
	}

}