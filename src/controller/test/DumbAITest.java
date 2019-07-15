package controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clui.BoardPrinter;
import controller.Controller;
import controller.DumbAI;
import model.Game;
import model.Player;

class DumbAITest {

	@Test
	void test() {
		Game g = new Game();
		
		// create the controllers for the two players
		Controller playerX = new DumbAI(Player.X);
		Controller playerO = new DumbAI(Player.O);

		// cause the board to be printed when it changes.
		g.addListener(new BoardPrinter());

		// cause the players to play when it is their turn
		g.addListener(playerX);
		g.addListener(playerO);
		
		assertEquals(g.getBoard().get(0,0), Player.X);
		assertEquals(g.getBoard().get(0,2), Player.X);
		assertEquals(g.getBoard().get(0,4), Player.X);
		assertEquals(g.getBoard().get(0,6), Player.X);
		assertEquals(g.getBoard().get(0,8), Player.X);
		
		assertEquals(g.getBoard().get(1,1), Player.X);
		assertEquals(g.getBoard().get(1,3), Player.X);
		assertEquals(g.getBoard().get(1,5), Player.X);
		assertEquals(g.getBoard().get(1,7), Player.X);
		
		assertEquals(g.getBoard().get(2,0), Player.X);
		assertEquals(g.getBoard().get(2,2), Player.X);
		assertEquals(g.getBoard().get(2,4), Player.X);
		assertEquals(g.getBoard().get(2,6), Player.X);
		assertEquals(g.getBoard().get(2,8), Player.X);
		
		assertEquals(g.getBoard().get(3,1), Player.X);
		assertEquals(g.getBoard().get(3,3), Player.X);
		assertEquals(g.getBoard().get(3,5), Player.X);
		assertEquals(g.getBoard().get(3,7), Player.X);
		
		assertEquals(g.getBoard().get(4,0), Player.X);
		
		assertEquals(g.getBoard().get(0,1), Player.O);
		assertEquals(g.getBoard().get(0,3), Player.O);
		assertEquals(g.getBoard().get(0,5), Player.O);
		assertEquals(g.getBoard().get(0,7), Player.O);
		
		assertEquals(g.getBoard().get(1,0), Player.O);
		assertEquals(g.getBoard().get(1,2), Player.O);
		assertEquals(g.getBoard().get(1,4), Player.O);
		assertEquals(g.getBoard().get(1,6), Player.O);
		assertEquals(g.getBoard().get(1,8), Player.O);
		
		assertEquals(g.getBoard().get(2,1), Player.O);
		assertEquals(g.getBoard().get(2,3), Player.O);
		assertEquals(g.getBoard().get(2,5), Player.O);
		assertEquals(g.getBoard().get(2,7), Player.O);
		
		assertEquals(g.getBoard().get(3,0), Player.O);
		assertEquals(g.getBoard().get(3,2), Player.O);
		assertEquals(g.getBoard().get(3,4), Player.O);
		assertEquals(g.getBoard().get(3,6), Player.O);
		assertEquals(g.getBoard().get(3,8), Player.O);
		
	}

}
