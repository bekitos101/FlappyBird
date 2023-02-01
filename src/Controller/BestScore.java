package Controller;

import java.io.Serializable;

public class BestScore implements Serializable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bestscore;
 	
	public BestScore( ){
	  	bestscore=0;
	}
	public int getBestScore() {
		return bestscore;
	}
	public void setScore(int score) {
		if(score>bestscore) {
			bestscore=score;
		}
	
	}
	
 	
}
