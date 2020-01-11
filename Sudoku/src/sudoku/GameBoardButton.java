package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GameBoardButton extends JButton {
	
	// Actual/correct value that the button has stored
	private int value;
	
	public int getValue() {
		return value;
	}
	
	// Dictates if button will be displayed at game start
	private boolean isShown;
	
	public boolean getIsShown() {
		return isShown;
	}
	
	// Integer actually shown/entered on button (doesn't need to match the actual value!)
	private int valueShown;
	
	public int getValueShown() {
		return valueShown;
	}
	
	public GameBoardButton(int value, boolean isShown, int row, int column, Sudoku game) {
		super();
		
		// Sets button appearances
		this.setPreferredSize(new Dimension(30, 30));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setBackground(Color.WHITE);
		
		// Button needs to know its own value
		this.value = value;
		this.isShown = isShown;
		
		// Sets the 2D array of gameBoardButtons at each row and index to its corresponding index
		game.setGameBoardButton(row, column, this);
		
		// Which buttons to display at game start
		if (isShown) {
			this.setText(Integer.toString(value));
			valueShown = value;
		}
		
		this.addActionListener(new MouseClickHandler(game));
	}
	
	// Sets the new value (1 - 9) shown on button based on value player has stored
	public void setDisplayedValue(GameBoardButton button, int newValue) {
		valueShown = newValue;
		button.setText(Integer.toString(newValue));
	}
	
	// Array of possible different colours that buttons can have
	private static final Color[] colours = {
			Color.RED, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.BLUE, Color.PINK,
			Color.MAGENTA, Color.GREEN, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY
			};
	
	// Method that changes background colour of button
	public void changeBG(Sudoku game) {
		Random random = new Random();
		
		// Chooses random index and sets the background of the button to the colour at that index
		int randomColourIndex = random.nextInt(colours.length);
		this.setBackground(colours[randomColourIndex]);
	}
}
