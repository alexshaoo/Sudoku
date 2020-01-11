package sudoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseClickHandler implements ActionListener {
	Sudoku game;
	
	// Needs to know the game that clicks are tracked on
	public MouseClickHandler(Sudoku game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// If the object clicked on is a button from the game board
		if (event.getSource() instanceof GameBoardButton) {
			
			// Get that button by casting the source of the click to the GameBoardButton type
			GameBoardButton boardButton = (GameBoardButton)event.getSource();
			
			// Can only change displayed value if button wasn't filled in at game start, those values are known to be correct
			if (!boardButton.getIsShown()) {
				
				// Clears text shown on button if stored value is 0 (game start default value) or -1 (value set for clearing text)
				if (game.getValueStored() == 0 || game.getValueStored() == -1) {
					boardButton.setText(" ");
				}
				
				// If the stored value is any other integer, set button's displayed value to that stored value
				else {
					boardButton.setDisplayedValue(boardButton, game.getValueStored());
					
					// Checks if the puzzle is solved every time a new value is entered
					if (game.isSolved()) {
						
						// Changes background colour of all buttons if sudoku is solved
						for (GameBoardButton[] buttonRow: game.getGameBoardButtons()) {
							for (GameBoardButton button: buttonRow) {
								button.changeBG(game);
							}
						}
					}
				}
			}
		
		// If the object clicked on is a button from the number pad, change the stored value based on the button
		} else if (event.getSource() instanceof NumberPadButton) {
			NumberPadButton numPadButton = (NumberPadButton)event.getSource();
			game.setValueStored(numPadButton.getNumberSelected());
			
		// If the object clicked on is a button from the 'clear value' button, set the value stored to the default 'clear value', -1
		} else if (event.getSource() instanceof ClearValueButton) {
			ClearValueButton clearValButton = (ClearValueButton)event.getSource();
			clearValButton.setClearValue();
		}
	}
}	
