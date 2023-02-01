package GameObjects;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
public abstract class Object {
	        // x and y are for the position of the object in the game 
    	    protected int x;
		    protected int y;
		    protected int dx;
		    protected int dy;
		    protected int width;
		    protected int height;
	        //upload image  
	        protected Image image;
	       
		    public Object (int x, int y) {
		        this.x = x;
		        this.y = y;
		    }

		    public int getX() {
		        return this.x;
		    }

		    public int getY() {
		        return this.y;
		    }

		    public int getDx() {
		        return this.dx;
		    }

		    public int getDy() {
		        return this.dy;
		    }

		    public int getWidth() {
		        return this.width;
		    }

		    public int getHeight() {
		        return this.height;
		    }

		  
		    public void setX(int x) {
		        this.x = x;
		    }

		    public void setY(int y) {
		        this.y = y;
		    }

		    public void setDx(int dx) {
		        this.dx = dx;
		    }

		    public void setDy(int dy) {
		        this.dy = dy;
		    }

		    public void setWidth(int width) {
		        this.width = width;
		    }

		    public void setHeight(int height) {
		        this.height = height;
		    }
            
		    public abstract void render(Graphics g);
		   
              
	};

