package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.GameWindow;

public class GameKeys implements KeyListener {

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && GameWindow.game.endOfGame == false) {
			GameWindow.game.flappy.Up();
		} 
		else if (e.getKeyCode() == KeyEvent.VK_ENTER && GameWindow.game.endOfGame == true){
			GameWindow.main(null);
		} 
		else if (e.getKeyCode() == KeyEvent.VK_ESCAPE && GameWindow.game.endOfGame == true){
			System.exit(0);
		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
