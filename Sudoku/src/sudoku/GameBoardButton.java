package sudoku;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GameBoardButton extends JButton {
	
	JButton[][] buttons = new JButton[9][9];
	
	// Actual value
	int value;
	
	// For when number is given when game starts
	boolean isShown;
	
	// Integer actually shown on button
	int valueShown;
	
	public GameBoardButton(int value, boolean isShown, int row, int column, Sudoku game) {
		super();
		this.setPreferredSize(new Dimension(30, 30));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setBackground(Color.WHITE);
		
		// Store buttons in 2D list
		buttons[row][column] = this;
		
		this.value = value;
		this.isShown = isShown;
		
		// Show buttons if corresponding boolean is true
		if (isShown) {
			this.setText(Integer.toString(value));
			valueShown = value;
		}
		
		// Add actionListener
		this.addActionListener(new MouseClickHandler(game));
	}
	
	public int getValueShown() {
		return valueShown;
	}
	
	// Sets value shown on button based on value stored
	public void setDisplayedValue(GameBoardButton button, int newValue) {
		valueShown = newValue;
		button.setText(Integer.toString(newValue));
	}
	
	public JButton[][] getButtons() {
		return buttons;
	}
	
}
