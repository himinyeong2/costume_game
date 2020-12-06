import java.awt.*;
import javax.swing.*;

public class Bottom extends Cloth {

	private int score;

	public Bottom( int s , String n, ImageIcon img ) { 
		super(n,img); score = s;
		}
	
	void setScore(int s) { score = s; }
	int getScore() { return score; }
}
