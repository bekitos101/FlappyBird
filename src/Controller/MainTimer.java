package Controller;

import java.awt.Image;
import java.util.ArrayList;



import View.GameWindow;

public class MainTimer implements Runnable {
   
	
	private final int PAUSE = 5;
	


	public void run() {
		while (GameWindow.game.endOfGame == false) {
			GameWindow.game.XBackground--;
			GameWindow.game.repaint();
			try {
				Thread.sleep(this.PAUSE);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
		
	}


