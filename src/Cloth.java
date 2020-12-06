import java.awt.*;
import javax.swing.*;

public class Cloth {
	
	private String name;
	private ImageIcon image;
	
	public Cloth( String n , ImageIcon img ){
		name = n;
		image = img;
	} // default constructor

	void setName( String n ) {	name = n;  }
	void setImage( ImageIcon img ) { image = img; }

	String getName() { return name; }
	ImageIcon getImage() { return image; }
}
