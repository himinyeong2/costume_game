import java.awt.*;
import javax.swing.*;

public class UserData {
	
	private String 	name;
	private int 	mode;
	private Shoes 	UserShoes;
	private Top 	UserTop;
	private Bottom	UserBottom;
	private int		eyebrow,shadow,chick,lips;
	private int		totalScore;
	private int		volumeFlag=1;
	
	public UserData() {
		UserShoes = null;
		UserTop = null;
		UserBottom = null;
		totalScore = 0;
		mode = 0;
	}
	
	public void setName( String n ) { name = n; }
	public void setMode( int m ) { mode = m; }
	public void setUserShoes( Shoes userShoes ) { 
		UserShoes = new Shoes(userShoes.getScore(), userShoes.getName(), userShoes.getImage());
		totalScore += userShoes.getScore();
	}
	public void setUserTop( Top userTop ) { 
		UserTop = new Top(userTop.getScore(), userTop.getName(), userTop.getImage());
		totalScore += userTop.getScore();
	}
	public void setUserBottom( Bottom userBottom ) { 
		UserBottom = new Bottom(userBottom.getScore(), userBottom.getName(), userBottom.getImage());
		totalScore += userBottom.getScore();
	}
	public void setMakeup(int b,int s,int c,int l) {
		eyebrow = b;
		shadow = s;
		chick = c;
		lips = l;
	}
	public void setVolume( int v ) { volumeFlag = v; }
	
	
	public String getName() 	{ return name; }
	public int getMode() 		{ return mode; }
	public Shoes getShoe() 		{ return UserShoes; }
	public Top getTop() 		{ return UserTop; }
	public Bottom getBtm()	 	{ return UserBottom; }
	public int getEyebrow()		{ return eyebrow; }
	public int getShadow()		{ return shadow; }
	public int getChick()		{ return chick; }
	public int getLips()		{ return lips; }
	public int getTotalScore()	{ return totalScore; }
	public int getVolume()		{ return volumeFlag; }
	
	public void reset() {
	      UserShoes = null;
	      UserTop = null;
	      UserBottom = null;
	      totalScore = 0;
	      mode = 0;
	}
}
