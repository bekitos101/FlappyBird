package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import View.GamePlace;

public class Pipe extends Object{
	private String strImage;
	private ImageIcon icoPipe;
	private Image imgPipe;
	
	public Pipe(int x,int y,String strImage) {
		super(x,y);
        this.width=GamePlace.PIPE_WIDTH; 
        this.width=GamePlace.PIPE_HEIGHT; 
      
           try  {
   			
        	   this.icoPipe = new ImageIcon(this.strImage);
       		   this.imgPipe = this.icoPipe.getImage();
           }
           catch(NullPointerException e ) {
        	   System.out.println("Pipe icon not found");
        	   
           }
            
	}
	
	public Image getImgPipe() {return imgPipe;}
    
	public void render(Graphics g) {
		
		g.setColor(new Color(0x318CE7));
		g.fillRect(x, y,GamePlace.PIPE_WIDTH,GamePlace.PIPE_HEIGHT);

	}
    
    


}