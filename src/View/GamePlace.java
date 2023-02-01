	package View;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	
	import javax.swing.ImageIcon;
	
	import Controller.BestScore;
	import Controller.GameKeys;
	import Controller.MainTimer;
	
	import javax.swing.*;
	import GameObjects.Bird;
	import GameObjects.Pipe;
	
	import java.awt.Image;
	import java.awt.LayoutManager;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.ArrayList;
	import java.util.Random;
	
	public class GamePlace extends JPanel {
		/**
		 * 
		 */
		 private static final long serialVersionUID = 1L;
		 private ImageIcon background;
		 public ArrayList <Pipe> pipes;
		 private Image backg;
		 public int Gamescore ;
		 private BestScore bs;
		 public Bird flappy;
	     public boolean endOfGame;
	     private Font font;
		
		//optimized pipe parameters 
		public static final int PIPE_WIDTH = 50;
		public static final int PIPE_HEIGHT = 300;
		
		//optimized bird parameters 
		public static final int BIRD_WIDTH = 34;
		public static final int BIRD_HEIGHT = 23;
		public static final int ASCEND_STEP=50;
		public static final int BIRDX = 100;
		public static final int BIRDY = 150;
		
		//Optimized Pipe attributes 
		public static final int BACKGROUND_WIDTH = 253;
		public static final int DISTANCE_BETWEEN_PIPES = 300;
		public static final int GAP_BETWEEN_UP_DOWN_PIPES = 75;
		
		
	    //Shifting Work 
		public int XBackground;//shift background thread 
		Random random; // pipe positioning 
		
	
	
	//Finish this later 
	
		 public GamePlace(){
	
			 Path path = Paths.get("bestscores.ser");
			 if(Files.exists(path)) {
				 try {
			         FileInputStream fileIn = new FileInputStream("bestscores.ser");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         bs = (BestScore) in.readObject();
			         in.close();
			         fileIn.close();
			      } catch (IOException i) {
			         bs = new BestScore();
			      }
				   catch (ClassNotFoundException c) {
			         System.out.println("BestScore class not found");
			         c.printStackTrace();
			         return;
			      }
		
			 
			 }
			 else {
				 bs = new BestScore();
			 }
			 
			this. background = new ImageIcon("Images/background.png");
			this.backg=this.background.getImage();
			 this.Gamescore= 0;
			 //FillPipesArray();
			 this.XBackground=0;
			 this.endOfGame=false;
			 random=new Random();
			  
			FillPipesArray();
				
			this.flappy = new Bird(BIRDX,BIRDY, "/Images/bird.gif");
			this.Gamescore = 0;
			this.font = new Font("TimesNewRoman", Font.PLAIN, 30);
		    Thread chrono = new Thread(new MainTimer());
		    chrono.start();
		
			       
			}	
		 
		 public void FillPipesArray() {
	     	ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	  	
	     	Pipe TubeUp1 = new Pipe(400, -150, "/images/TubeUp.png");
	 		Pipe TubeDown1 = new Pipe(400, 250, "/images/TubeDown.png");
	 		Pipe TubeUp2 = new Pipe(400 + DISTANCE_BETWEEN_PIPES, -100, "/images/TubeUp.png");
	 		Pipe TubeDown2 = new Pipe(400 + DISTANCE_BETWEEN_PIPES, 300, "/images/TubeDown.png");
	 		Pipe TubeUp3 = new Pipe(400 + DISTANCE_BETWEEN_PIPES * 2, -120, "/images/TubeUp.png");
	 		Pipe TubeDown3 = new Pipe(400 + DISTANCE_BETWEEN_PIPES * 2, 280, "/images/TubeDown.png");
	 		pipes.add(TubeUp1);
	 		pipes.add(TubeDown1);
	 		pipes.add(TubeUp2);
	 		pipes.add(TubeDown2);
	 		pipes.add(TubeUp3);
	 		pipes.add(TubeDown3);
	 		
	  		this.pipes=pipes;
	     	
	     }
			 
		
			private void tubeShifting(Graphics g) {
		
				this.pipes.get(0).setX(this.pipes.get(0).getX() - 1);
				this.pipes.get(1).setX(this.pipes.get(0).getX());
	
				if (this.pipes.get(0).getX() == -100) {
					this.pipes.get(0).setX(this.pipes.get(4).getX() +DISTANCE_BETWEEN_PIPES);
					this.pipes.get(0).setY(-220+random.nextInt(150));
					this.pipes.get(1).setY(pipes.get(0).getY()+GAP_BETWEEN_UP_DOWN_PIPES +PIPE_HEIGHT);
				}
				
				pipes.get(0).render(g);
				pipes.get(1).render(g);
				
				
				this.pipes.get(2).setX(this.pipes.get(2).getX() - 1);
				this.pipes.get(3).setX(this.pipes.get(2).getX());
	
				if (this.pipes.get(2).getX() == -100) {
					this.pipes.get(2).setX(this.pipes.get(0).getX() + DISTANCE_BETWEEN_PIPES);
					this.pipes.get(2).setY(-220+random.nextInt(150));
					this.pipes.get(3).setY(pipes.get(2).getY()+GAP_BETWEEN_UP_DOWN_PIPES +PIPE_HEIGHT);
				}
				pipes.get(2).render(g);
				pipes.get(3).render(g);
				
				
				this.pipes.get(4).setX(this.pipes.get(4).getX() - 1);
				this.pipes.get(5).setX(this.pipes.get(4).getX());
	
				if (this.pipes.get(4).getX() == -100) {
					this.pipes.get(4).setX(this.pipes.get(2).getX() + DISTANCE_BETWEEN_PIPES);
					this.pipes.get(4).setY(-220+random.nextInt(150));
					this.pipes.get(5).setY(pipes.get(4).getY()+GAP_BETWEEN_UP_DOWN_PIPES +PIPE_HEIGHT);
				}
				pipes.get(4).render(g);
				pipes.get(5).render(g);
				
		}
			
			public void paint(Graphics g) {
				super.paint(g);
				if (this.XBackground <= -BACKGROUND_WIDTH) {
					this.XBackground =0 ;
				}
				g.drawImage(this.backg, this.XBackground, 0, null);
				g.drawImage(this.backg, this.XBackground + BACKGROUND_WIDTH, 0, null);
				g.drawImage(this.backg, this.XBackground + BACKGROUND_WIDTH * 2, 0, null);
				this.tubeShifting(g);
	            
				//Don't forget to add exception here 
				this.score();
				
				g.setColor(new Color(0x000000));
				g.setFont(font);
				g.drawString("" + Gamescore, 120, 50);
				this.endOfGame = this.gameOver();
				this.flappy.setY(this.flappy.getY() + 1);
	
				g.setColor(new Color(0xFFE436));
				g.fillOval(this.flappy.getX(), this.flappy.getY(), 15, 15);
				
	
				//Don't forget to add exception here 
				if (this.endOfGame == true) {
					bs.setScore(Gamescore);
					g.setColor(new Color(0x000000));
					g.drawString("Game Over", 65, 200);
					g.drawString("Best Score : " + Integer.toString(loadBestScore()), 50, 370);
					try {
				         FileOutputStream fileOut =new FileOutputStream("bestscores.ser");
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(bs);
				         out.close();
				         fileOut.close();
				         //System.out.printf("Serialized data is saved in /src/bestscores.ser");
				      } catch (IOException i) {
				         i.printStackTrace();
				      }
				}
			}
	
	
			
			
		 
			public boolean collideWith(Pipe tube, Bird bird) {
		
				
				if(bird.getX()>=tube.getX() && bird.getX()<=tube.getX()+PIPE_WIDTH) {
					if(bird.getY()>=tube.getY()&& bird.getY()<=tube.getY()+PIPE_HEIGHT) {
						return true;
					}

				}
				return false;
			}
			private boolean gameOver() {
				boolean endOfGame = false;
				endOfGame = collideWith(this.pipes.get(0), this.flappy) || collideWith(this.pipes.get(1), this.flappy)
						|| collideWith(this.pipes.get(2), this.flappy) || collideWith(this.pipes.get(3), this.flappy)
						|| collideWith(this.pipes.get(4), this.flappy) || collideWith(this.pipes.get(5), this.flappy)
						|| this.flappy.getY() + this.flappy.getHeight() > 330;
				
						
						   System.out.println(flappy.getX());
				   		   System.out.println(flappy.getY());
						return endOfGame;
				
				
			}
	
	        
			
			public void score() {
				if (this.pipes.get(1).getX() + PIPE_WIDTH == flappy.getX()
						|| this.pipes.get(3).getX() + PIPE_WIDTH  == flappy.getX()
						|| this.pipes.get(5).getX() + PIPE_WIDTH  == flappy.getX()) {
					
					this.Gamescore++;
					
				}
			
		      }
	
	        
		
			
			private int loadBestScore() {
				return bs.getBestScore();
			}
	       
	}





























