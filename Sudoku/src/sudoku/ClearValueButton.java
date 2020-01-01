package sudoku;

import java.awt.Dimension;

import javax.swing.JButton;

public class ClearValueButton extends JButton {
	
	Sudoku game;
	
	public ClearValueButton(Sudoku game) {
		super();
		this.game = game;
		this.setPreferredSize(new Dimension(150, 30));
		this.setText("Clear");
		this.addActionListener(new MouseClickHandler(game));
		this.setVisible(true);
	}
	
	// Turns value into -1; will clear value to empty string later
	public void clearValue() {
		game.valueStored = -1;
	}
}
