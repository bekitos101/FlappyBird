package Tests;
import org.junit.Test;

import GameObjects.Bird;
import GameObjects.Pipe;
import View.GamePlace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCase1 {
	   GamePlace gb;
	   Pipe p;
	   Bird flappy;
	   
		

		void tearDown() {
			gb = null;
		
		}
       
		
	   //collision with an UP pipe 
	 
		@Test
	   public void detectcollideWhenCollideTestUp() {
		   gb = new GamePlace();
			gb.flappy.setX(100);
			gb.flappy.setY(149);
			assertFalse(gb.collideWith(gb.pipes.get(1), gb.flappy));

		}


		@Test
		public void NotCollideTestUp() {
			gb = new GamePlace();
			gb.flappy.setX(150);
			gb.flappy.setY(150);
			assertFalse(gb.collideWith(gb.pipes.get(0), gb.flappy));

		}
		
		
      
	 //Collision with a DOWN pipe
		@Test
		   public void detectcollideTestDown() {
			    gb = new GamePlace();
				gb.flappy.setX(-150);
				gb.flappy.setY(-200);
				assertFalse(gb.collideWith(gb.pipes.get(0), gb.flappy));

			}


			@Test
			public void detectNotcollideTestDown() {
				gb = new GamePlace();
				gb.flappy.setX(-120);
				gb.flappy.setY(-89);
				assertFalse(gb.collideWith(gb.pipes.get(0), gb.flappy));

			}
			
			
		

			@Test   
		 public void TestWhenPointScoreAdded() {
			gb = new GamePlace();
			gb.flappy.setX(50);
			gb.pipes.get(1).setX(0);
			gb.score();
			assertEquals(1,gb.Gamescore); }
			

			@Test   
			public void TestWhenPointScoreNotAdded() {
			gb = new GamePlace();
			gb.flappy.setX(-20);
			gb.pipes.get(1).setX(0);
			gb.score();
			assertEquals(0,gb.Gamescore);
					                 
						  
						   
						
						
				
		}
}



