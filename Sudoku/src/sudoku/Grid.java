package sudoku;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Part 2: The GUI

public class Grid extends JPanel {
	
	public Grid(int[][] solved, boolean[][] isShown, int gridRow, int gridColumn, Sudoku game) {
		super();
		
		// Grid is each box of numbers from 1 - 9; is a 3x3 layout
		this.setLayout(new GridLayout(3, 3));
		
		// Passing in value stored in each button to Button constructor
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				
				// Creates and adds a button to the grid
				int rowIndex = 3 * gridRow + row;
				int columnIndex = 3* gridColumn + column;
				GameBoardButton button = new GameBoardButton(solved[rowIndex][columnIndex], 
										isShown[rowIndex][columnIndex], rowIndex, columnIndex, game);
				
				this.add(button);
			}
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);
	}
}