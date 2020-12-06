import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class StartPanel extends JPanel{

	private JPanel				under;
	private JLabel 				title,userName;
	private JTextField 			txtinput;
	private JRadioButton 		mode1, mode2;
	private JButton 			nxtbtn,soundOff;
	private String 				name;
	private ImageIcon 			icon,volume;
	private int					mode = -1;
	private SelectItemListener 	modeCheck;
	
	public StartPanel(MainFrame frame,UserData User)
	{
		setPreferredSize(new Dimension(1200, 900));
		setBackground(Color.WHITE);
		setLayout(null);
		
		modeCheck = new SelectItemListener();
		
		under = new JPanel();
		under.setBackground(Color.pink);
		under.setBounds(0, 650, 1200, 250);
		under.setLayout(null);
		add(under);
		
		// 타이틀 문구
		name = User.getName();
		JLabel userName = new JLabel(name+"의");
		userName.setFont(new Font("1훈하얀고양이 Regular",Font.BOLD,200));
		userName.setForeground(Color.BLACK);
		userName.setBounds(0, 100, 1200, 200);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		add(userName);
		
		icon = new ImageIcon("Images/introDesign.png");
		JLabel title
		= new JLabel("",icon,SwingConstants.CENTER);
		title.setBounds(0, 300, 1200, 300);
		add(title);

		if( User.getVolume() == 1 )
			volume = new ImageIcon("Images/volume_on.png");
		else
			volume = new ImageIcon("Images/volume_off.png");
		
		soundOff = new JButton(volume);
		soundOff.setBounds(1100,50,50,50);
		soundOff.setBorderPainted(false);
		soundOff.setContentAreaFilled(false);
		soundOff.setFocusPainted(false);
		soundOff.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent event) {}
			public void mouseClicked(MouseEvent e) {
				if( User.getVolume() == 1) {
					frame.mSound.stop();
					volume = new ImageIcon("Images/volume_off.png");
					User.setVolume(0);
				}
				else if( User.getVolume() == 0) {
					frame.mSound.play();
					volume = new ImageIcon("Images/volume_on.png");
					User.setVolume(1);
				}
				soundOff.setIcon(volume);
			}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(soundOff);
		
		// 라디오 버튼
		JRadioButton mode1 = new JRadioButton("일반모드");
		mode1.setFont(new Font("LG PC", Font.BOLD, 25));
		mode1.addItemListener(modeCheck);
		mode1.setSize(180, 40);
		mode1.setHorizontalAlignment(SwingConstants.CENTER);
		mode1.setFocusPainted(false);
		mode1.setBackground(null);
		
		JRadioButton mode2 = new JRadioButton("챌린지모드");
		mode2.setFont(new Font("LG PC", Font.BOLD, 25));
		mode2.addItemListener(modeCheck);
		mode2.setSize(180, 40);
		mode2.setHorizontalAlignment(SwingConstants.CENTER);
		mode2.setFocusPainted(false);
		mode2.setBackground(null);
		
		// 버튼 그룹 설정
		ButtonGroup buttonGrp = new ButtonGroup();
		buttonGrp.add(mode1);
		buttonGrp.add(mode2);

		// 라디오버튼 패널 설정 / 프레임에 등록
		JPanel radibtn = new JPanel();
		radibtn.add(mode1);
		radibtn.add(mode2);
		radibtn.setBounds(400, 0, 400, 100);
		radibtn.setBackground(null);
		radibtn.setLayout(new GridLayout(1,2));
		under.add(radibtn);


		// 다음화면 이동 버튼
		nxtbtn = new JButton("NEXT");
		nxtbtn.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 30));
		nxtbtn.setBounds(500, 100, 200, 100);
		nxtbtn.setHorizontalAlignment(SwingConstants.CENTER);
		nxtbtn.setBorderPainted(false);
		nxtbtn.setContentAreaFilled(false);
		nxtbtn.setFocusPainted(false);
		nxtbtn.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent sevent) {
				nxtbtn.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 40));
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {
				nxtbtn.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 30));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		nxtbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Object obj = event.getSource();
				
				if( obj == nxtbtn ) {
					if( mode == -1 )
						JOptionPane.showMessageDialog(title,"모드를 선택해주세요.");
					else{
						User.setMode(mode);
						radibtn.remove(mode1);
						radibtn.remove(mode2);
						under.remove(nxtbtn);
						frame.Change("Makeup");
					}
				}

			}
		});
		under.add(nxtbtn);
	}

	class SelectItemListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent e) {
			AbstractButton sel = (AbstractButton)e.getItemSelectable();
			
			if( e.getStateChange() == ItemEvent.SELECTED )
			{
				if( sel.getText().equals("일반모드"))
					mode = 1;
				else if( sel.getText().equals("챌린지모드"))
					mode = 2;
			}
		}
	}
}
