import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class IntroPanel extends JPanel{

	private JLabel Enter;
	private JButton strbtn,soundOff;
	private JTextField nameInput;
	private String name;
	private ImageIcon icon,volume;
	
	public IntroPanel(MainFrame frame, UserData userdata)
	{
		setPreferredSize(new Dimension(1200,900));
		setBackground(Color.WHITE);
		setLayout(null);
		
		icon = new ImageIcon("Images/introDesign.png");
		JLabel title
		= new JLabel("",icon,SwingConstants.CENTER);
		title.setBounds(0, 200, 1200, 300);
		add(title);

		volume = new ImageIcon("Images/volume_on.png");
		
		soundOff = new JButton(volume);
		soundOff.setBounds(1100,50,50,50);
		soundOff.setBorderPainted(false);
		soundOff.setContentAreaFilled(false);
		soundOff.setFocusPainted(false);
		soundOff.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent event) {}
			public void mouseClicked(MouseEvent e) {
				if( userdata.getVolume() == 1) {
					frame.mSound.stop();
					volume = new ImageIcon("Images/volume_off.png");
					userdata.setVolume(0);
				}
				else if( userdata.getVolume() == 0) {
					frame.mSound.play();
					volume = new ImageIcon("Images/volume_on.png");
					userdata.setVolume(1);
				}
				soundOff.setIcon(volume);
			}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(soundOff);
		
		Enter = new JLabel("사용자 이름을 입력하시오 ( 최대 7글자 )");
		Enter.setBounds(0, 550, 1200, 30);
		Enter.setHorizontalAlignment(SwingConstants.CENTER);
		Enter.setFont(new Font("1훈하얀고양이 Regular",Font.PLAIN,30));
		Enter.setForeground(Color.BLACK);
		add(Enter);
		
		nameInput = new JTextField();
		nameInput.setDocument((new JTextFieldLimit(7)));
		nameInput.setHorizontalAlignment(JTextField.CENTER);
		nameInput.setFont(new Font("1훈하얀고양이 Regular",Font.BOLD,30));
		nameInput.setForeground(Color.WHITE);
		nameInput.setBounds(400, 600, 400, 50);
		nameInput.setEnabled(true);
		nameInput.setBackground(Color.PINK);
		nameInput.setBorder(new LineBorder(Color.WHITE, 2));	
		add(nameInput);

		// 게임시작버튼
		strbtn = new JButton("START");
		strbtn.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 30));
		strbtn.setBounds(500, 700, 200, 50);
		strbtn.setBorderPainted(false);
		strbtn.setContentAreaFilled(false);
		strbtn.setFocusPainted(false);
		strbtn.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent event) {
				strbtn.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 40));
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {
				strbtn.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 30));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		strbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Object obj = event.getSource();
				
				if( obj == strbtn ) {
					name = nameInput.getText();
					
					if( name.length() == 0 ){
						JOptionPane.showMessageDialog(title,"이름을 입력하시요.");
					}
					else{
						userdata.setName(name);
						frame.Change("Start");
					}
				}

			}
		});
		add(strbtn);

	}
	
	class JTextFieldLimit extends PlainDocument {
		   private int limit;
		   private boolean toUppercase = false;
		    JTextFieldLimit( int limit) {
		      super();
		      this.limit = limit;
		   }
		    JTextFieldLimit(int limit, boolean upper) {
		      super();
		      this.limit = limit;
		      this.toUppercase = upper;
		   }
		 
		   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		      if (str == null) {
		         return;
		      }
		      if ( (getLength() + str.length()) <= limit) {
		         if (toUppercase) {
		            str = str.toUpperCase();
		         }
		         super.insertString(offset, str, attr);
		      }
		   }
		}
}
