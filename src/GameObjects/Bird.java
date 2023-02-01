package GameObjects;
 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import View.GamePlace;
public class Bird extends Object implements Runnable {
	private static final int SLEEPTIME=12;
	
	private String strImage;
	private ImageIcon icoBird;
	private Image imgBird;
	
	
	public Bird(int x, int y,String strImage){
		super(x, y);
        this.width=GamePlace.BIRD_WIDTH; 
        this.width=GamePlace.BIRD_HEIGHT; 
         try  {
   			
        	   this.icoBird = new ImageIcon(this.strImage);
       		   this.imgBird = this.icoBird.getImage();
           }
           catch(NullPointerException e ) {
        	   System.out.println("Bird icon not found");
        	   
           }
           
	   // create a new thread for the bird to run on independently from the shifting background 
           
           Thread fly = new Thread(this);
   		   fly.start();
           
	}
    

	public Image getImgBird() {
		System.out.println(imgBird);
		return imgBird;
	}
	public void Up() {
    	
    	this.dy=GamePlace.ASCEND_STEP;
		
	}
    
    
	public void Down(int dy) {
		this.dy--;
		//if the movement is greater than the step 
		//optimize these numbers later
		if (dy > 20) {
			this.icoBird = new ImageIcon("/Images/bird.png");
			this.imgBird = this.icoBird.getImage();
			this.y = this.y - 3; //Gravity effect 
		} else if (dy > 10) {
			this.y = this.y - 2;
		} else if (dy > 2) {
			this.y = this.y - 1;
		}
	
		
		
	}
	
   
	public void render(Graphics g) {
	   // g.drawImage(image, x, y);
   }
	    
 	public void run() {
 		while (true) {
			this.Down(dy);
			try {
				Thread.sleep(SLEEPTIME);
			} catch (InterruptedException e) {
			   e.printStackTrace();
			}
			
		}
 		
	}
    
    

}
