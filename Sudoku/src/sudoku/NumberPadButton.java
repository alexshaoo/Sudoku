package sudoku;

import java.awt.Dimension;

import javax.swing.JButton;

public class NumberPadButton extends JButton {
	
	// Integer attribute, stores number shown
	// TODO: this variable name also sucks
	int numberOnNumberPad;
	
	public NumberPadButton(int number, Sudoku game) {
		super();
		this.numberOnNumberPad = number;
		this.setPreferredSize(new Dimension(50, 50));
		this.addActionListener(new MouseClickHandler(game));
		this.setText(Integer.toString(number));
		this.setVisible(true);
	}
	
	public int getNumberSelected() {
		return numberOnNumberPad;
	}
}
