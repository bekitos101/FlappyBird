package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import Controller.GameKeys;
import GameObjects.Bird;
import GameObjects.Pipe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class GameWindow {
	
	/**
	 * 
	 */
	public static final int Best_WIDTH=300;
	public static final int Best_HEIGHT =425;
    public static JFrame frame;
    public static GamePlace game;
    
	
	
	
	public static void main(String[] args) {
		
	
		
		 
		 frame = new JFrame();
		 frame.setTitle("Flappy Bird ");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setSize(new Dimension(Best_WIDTH, Best_HEIGHT));
	     frame.setLocationRelativeTo(null);
	     frame.setResizable(false);
	     frame.setAlwaysOnTop(true);
	    
	
	
		//Start Game JButton
		JButton startGame = new JButton("Start Playing!");
        frame.add(startGame); 	
        startGame.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		 game=new GamePlace();
        		 frame.getContentPane().removeAll();
        	     frame.add(game);
        	     frame.getContentPane().validate();
        	    
        	}
        });
        frame.setFocusable(true);
	     frame.addKeyListener(new GameKeys());

	    frame.setVisible(true);

	}






}

	