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
	
	// Sets stored value to -1, a value that notifies MouseClickHander to clear text shown on game board buttons
	public void setClearValue() {
		game.setValueStored(-1);
	}
}
