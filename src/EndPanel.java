import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class EndPanel extends JPanel {
	
	private int			nRandom;
	private int 		totalScore;
	private String[] 	evalGood = {"우와 멋지다~","우와 정말 예쁘다~","우와 진짜 핵간지~","혹시 남자친구 있으세요?","언니 옷 너무 이쁘게 입었다~","PERFECT STYLE"};
	private String[] 	evalBad = {"윽 진짜 못생겼다!","으 안구테러~","윽 눈갱당해버렸어~","너 옷 다시 입고 와라..","안본 눈 사요~","언니 스타일이 영 아니다~"};
	private ImageIcon 	mIcon,volume;
	private ImageIcon 	mAvatar;
	private JLabel 		mTop,mBottom,mShoes;
	private JLabel		mBrow,mShadow,mChick,mLips;
	private JLabel 		aLabel,imgLabel,evalLabel;
	private JButton 	btnRst,btnFsh,soundOff;
	
	private JPanel 		leftPanel, rightPanel;
	
	public EndPanel(MainFrame frame, UserData User) {
		
		setPreferredSize(new Dimension(1200,900));
		setBackground(Color.WHITE);
		setLayout(null);
		
		// soundControl
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
		
		// leftPanel
		leftPanel = new JPanel();
		leftPanel.setBounds(0,0,400,900);
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setLayout(null);
		add(leftPanel);
	
		// rightPanel
		rightPanel = new JPanel();
		rightPanel.setBounds(400, 0, 800, 900);
		rightPanel.setBackground(Color.WHITE);
		rightPanel.setLayout(null);
		add(rightPanel);
		
		// 옷
		mBottom = new JLabel(User.getBtm().getImage());
		mBottom.setBounds(50, 50, 400, 800);
		leftPanel.add(mBottom);
		
		mTop = new JLabel(User.getTop().getImage());
		mTop.setBounds(50, 50, 400, 800);
		leftPanel.add(mTop);
		
		mShoes = new JLabel(User.getShoe().getImage());
		mShoes.setBounds(50, 50, 400, 850);
		leftPanel.add(mShoes);
		
		// 얼굴 
		mBrow = new JLabel(new ImageIcon("Images/endMU/eyebrow" + User.getEyebrow() + ".png"));
		mBrow.setBounds(50, 50, 400, 130);
		leftPanel.add(mBrow);
		
		mShadow = new JLabel(new ImageIcon("Images/endMU/shadow" + User.getShadow() + ".png"));
		mShadow.setBounds(50, 50, 400, 130);
		leftPanel.add(mShadow);
		
		mChick = new JLabel(new ImageIcon("Images/endMU/chick" + User.getChick() + ".png"));
		mChick.setBounds(50, 50, 400, 130);
		leftPanel.add(mChick);
		
		mLips = new JLabel(new ImageIcon("Images/endMU/lip" + User.getLips() + ".png"));
		mLips.setBounds(50, 50, 400, 130);
		leftPanel.add(mLips);
		
		// 아바타
		mAvatar = new ImageIcon("images/Avatar.png");
		aLabel = new JLabel(mAvatar);
		aLabel.setBounds(50, 50, 400, 800);
		leftPanel.add(aLabel);

		// 말풍선
		mIcon = new ImageIcon("images/eval2.png");
		imgLabel = new JLabel(mIcon);
		imgLabel.setBounds(150, 50, 500, 400);
		rightPanel.add(imgLabel);
		
		nRandom = (int)(Math.random()*6);
		setTotalScore(User);
		evalLabel.setBounds(0,0,500,400);
		evalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		evalLabel.setVerticalAlignment(SwingConstants.CENTER);
		evalLabel.setFont(new Font("1훈하얀고양이 Regular",Font.BOLD,30));
		imgLabel.add(evalLabel);
		
		// replay button
		btnRst = new JButton("REPLAY");
		btnRst.setFont(new Font("1훈하얀고양이 Regular",Font.BOLD,25));
		btnRst.setBounds(300,600,200,50);
		btnRst.setForeground(Color.WHITE);
		btnRst.setBorderPainted(false);
		btnRst.setFocusPainted(false);
		btnRst.setBackground(Color.pink);
		btnRst.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent event) {
				btnRst.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 30));
			}
			public void mouseClicked(MouseEvent e) {
				frame.Change("reStart");
			}
			public void mouseExited(MouseEvent e) {
				btnRst.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 25));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		rightPanel.add(btnRst);
		
		// exit button
		btnFsh = new JButton("EXIT");
		btnFsh.setFont(new Font("1훈하얀고양이 Regular",Font.BOLD,25));
		btnFsh.setBounds(300,700,200,50);
		btnFsh.setForeground(Color.WHITE);
		btnFsh.setBorderPainted(false);
		btnFsh.setFocusPainted(false);
		btnFsh.setBackground(Color.pink);
		btnFsh.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent event) {
				btnFsh.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 30));
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseExited(MouseEvent e) {
				btnFsh.setFont(new Font("1훈하얀고양이 Regular", Font.BOLD, 25));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		rightPanel.add(btnFsh);	
	}
	
	public void setTotalScore(UserData User) {
		totalScore = User.getTotalScore();
		if( totalScore  == 30 || User.getMode() == 1 )
			evalLabel = new JLabel(evalGood[nRandom]);
		else
			evalLabel = new JLabel(evalBad[nRandom]);
		
	}
}
