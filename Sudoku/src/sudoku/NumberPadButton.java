package sudoku;

import java.awt.Dimension;

import javax.swing.JButton;

public class NumberPadButton extends JButton {
	
	// Integer attribute, stores number shown on specific pad from number pad
	int number;
	
	public NumberPadButton(int number, Sudoku game) {
		super();
		
		// Knows its own displayed value
		this.number = number;
		
		this.setPreferredSize(new Dimension(50, 50));
		this.addActionListener(new MouseClickHandler(game));
		this.setText(Integer.toString(number));
		this.setVisible(true);
	}
	
	public int getNumberSelected() {
		return number;
	}
}
