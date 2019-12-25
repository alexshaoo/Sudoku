package sudoku;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Part 2: The GUI

public class Grid extends JPanel {
	
	public Grid(int[][] solved, boolean[][] isShown, int gridRow, int gridColumn, Sudoku game) {
		super();
		
		this.setLayout(new GridLayout(3, 3));
		
		// Passing in value stored in each button to Button constructor
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				GameBoardButton button = new GameBoardButton(solved[3 * gridRow + row][3 * gridColumn + column], 
										isShown[3 * gridRow + row][3 * gridColumn + column], 
										3 * gridRow + row, 3 * gridColumn + column, game);
				
				this.add(button);
			}
		}
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);
	}
	
}