package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseClickHandler implements ActionListener {
	Sudoku game;
	
	public MouseClickHandler(Sudoku game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// why can't i just use event.getSource(), cast it to obj type, and use that in comparisons instead?
		/*
		if (Object event.getSource() instanceof GameBoardButton) {
			do things
		}
		/**/
		Object buttonSelected = event.getSource();
		
		// Set numbers shown on the board using stored value, if the object clicked on is a button from the game board
		if (buttonSelected instanceof GameBoardButton) {
			GameBoardButton boardButton = (GameBoardButton)event.getSource();
			
			// Check if button already has 'default' values; ones that were originally filled in at game start
			if (!boardButton.isShown) {
				boardButton.setDisplayedValue(boardButton, game.getValueStored());
			}
			
			// Checks if the puzzle is solved
			if (game.isSolved()) {
				System.out.println("Will look into more visual ways later...");
			}
			
		// Change stored value based on number clicked on in numberPad
		} else if (buttonSelected instanceof NumberPadButton) {
			NumberPadButton numPadButton = (NumberPadButton)event.getSource();
			game.setValueStored(numPadButton.getNumberSelected());
			
		// OPTIONAL: I DID THIS FOR CONVENIENCE
		// Clears any number that gets selected
		} else if (buttonSelected instanceof ClearValueButton) {
			ClearValueButton clearValButton = (ClearValueButton)event.getSource();
			clearValButton.clearValue();
		}
		
		
		
	}
}	
