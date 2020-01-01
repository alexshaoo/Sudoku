package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseClickHandler implements ActionListener {
	Sudoku game;
	
	// Only needs to take in the game as a parameter
	public MouseClickHandler(Sudoku game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// Set numbers shown on the board using stored value, if the object clicked on is a button from the game board
		if (event.getSource() instanceof GameBoardButton) {
			GameBoardButton boardButton = (GameBoardButton)event.getSource();
			
			// Can only change the displayed value if button wasn't filled in at game start
			if (!boardButton.isShown) {
				boardButton.setDisplayedValue(boardButton, game.getValueStored());
			}
			
			// Checks if the puzzle is solved everytime
			if (game.isSolved()) {
				System.out.println("Will look into more visual ways later...");
			}
			
		// Change stored value based on number clicked on in numberPad
		} else if (event.getSource() instanceof NumberPadButton) {
			NumberPadButton numPadButton = (NumberPadButton)event.getSource();
			game.setValueStored(numPadButton.getNumberSelected());
			
		// OPTIONAL: I DID THIS FOR CONVENIENCE
		// Clears any number that gets selected
		} else if (event.getSource() instanceof ClearValueButton) {
			ClearValueButton clearValButton = (ClearValueButton)event.getSource();
			clearValButton.clearValue();
		}
		
		
		
	}
}	
