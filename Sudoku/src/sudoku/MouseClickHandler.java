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
			
			// Can only change displayed value if button wasn't filled in at game start
			if (!boardButton.getIsShown()) {
				
				// Empties text if stored value is 0 (game start default value) or -1 (value given when clearing shown button value)
				if (game.getValueStored() == 0 || game.getValueStored() == -1) {
					boardButton.setText(" ");
				}
				
				// If the stored value is any other integer, set button's displayed value to that stored value
				else {
					boardButton.setDisplayedValue(boardButton, game.getValueStored());
					
					// Checks if the puzzle is solved every time a new value is inputed
					if (game.isSolved()) {
						;
					}
				}
			}
		
		// Change stored value based on number clicked on in numberPad
		} else if (event.getSource() instanceof NumberPadButton) {
			NumberPadButton numPadButton = (NumberPadButton)event.getSource();
			game.setValueStored(numPadButton.getNumberSelected());
			
		// Clears any number that gets selected
		} else if (event.getSource() instanceof ClearValueButton) {
			ClearValueButton clearValButton = (ClearValueButton)event.getSource();
			clearValButton.setClearValue();
		}
	}
}	
