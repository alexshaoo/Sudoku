package sudoku;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Grid extends JPanel {
	
	// Constructs a new grid which holds the JButtons to be displayed on the 
	public Grid(int[][] solved, boolean[][] isShown, int gridRow, int gridColumn, Sudoku game) {
		super();
		
		// Grid is each box of numbers from 1 - 9; is a 3x3 layout
		this.setLayout(new GridLayout(3, 3));
		
		// Passing in value stored in each button to GameBoardButton constructor
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				
				// Indices of each button
				int rowIndex = 3 * gridRow + row;
				int columnIndex = 3* gridColumn + column;
				
				// Creates and adds a button to the grid
				GameBoardButton button = new GameBoardButton(solved[rowIndex][columnIndex], 
										isShown[rowIndex][columnIndex], rowIndex, columnIndex, game);
				
				this.add(button);
			}
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);
	}
}