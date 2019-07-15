package controller;

import javax.swing.border.Border;

import model.Board;
import model.Game;
import model.Location;
import model.NotImplementedException;
import model.Player;

/**
 * A DumbAI is a Controller that always chooses the blank space with the
 * smallest column number from the row with the smallest row number.
 */
public class DumbAI extends Controller {

	public DumbAI(Player me) {
		super(me);
		
	}

	protected @Override Location nextMove(Game g) {
		super.delay();
		for(int i=0; i<Board.NUM_ROWS;i++) {
			for(int j=0; j<Board.NUM_ROWS;j++) {
				Location location = new Location(i,j);
				if(g.getBoard().get(i, j)==null) {
					return location;
			}
		}
	}
		super.delay();
		return null;
	}
}
