package sudoku;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GameBoardButton extends JButton {
	
	// Actual value
	private int value;
	
	public int getValue() {
		return value;
	}
	
	// For when number is given when game starts
	private boolean isShown;
	
	public boolean getIsShown() {
		return isShown;
	}
	
	// Integer actually shown on button
	private int valueShown;
	
	public int getValueShown() {
		return valueShown;
	}
	
	public GameBoardButton(int value, boolean isShown, int row, int column, Sudoku game) {
		super();
		this.setPreferredSize(new Dimension(30, 30));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setBackground(Color.WHITE);
		
		// So the button knows its own value
		this.value = value;
		this.isShown = isShown;
		
		// Sets array containing board buttons at each row and column to the corresponding button
		game.gameBoardButtons[row][column] = this;
		
		// The button is shown if the boolean is true
		if (isShown) {
			this.setText(Integer.toString(value));
			valueShown = value;
		}
		
		// Button knows when a click registers
		this.addActionListener(new MouseClickHandler(game));
	}
	
	// Sets value shown on button based on value stored
	public void setDisplayedValue(GameBoardButton button, int newValue) {
		valueShown = newValue;
		button.setText(Integer.toString(newValue));
	}
}
