import java.awt.*;
import javax.swing.*;

public class Shoes extends Cloth {
	
	private int score;
	
	public Shoes( int s , String n, ImageIcon img ) { 
		super(n,img); score = s;
		}

	void setScore(int s) { score = s; }
	int getScore() { return score; }
}
