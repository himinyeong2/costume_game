import java.awt.*;
import javax.swing.JFrame;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MainFrame extends JFrame {
	
	private IntroPanel 	mIntroPanel;
	private StartPanel	mStartPanel,reStartPanel;
	private MakeupPanel mMakeupPanel;
	private Closet	 	mClosetPanel;
	private EndPanel 	mEndPanel;
	private UserData 	userdata = new UserData();
	public static Sound		mSound;
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	public MainFrame() {
		setTitle("EXAMPLE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false); 
		mIntroPanel = new IntroPanel(this,userdata); 
		getContentPane().add(mIntroPanel);
		

		File clap = new File("Bgm.wav");
		mSound = new Sound(clap);
		mSound.play();
		pack();
		setVisible(true);
	}
	
	public void Change(String PanelName) {
		if( PanelName == "Start") {
			this.remove(mIntroPanel);
			mStartPanel = new StartPanel(this,userdata);
			getContentPane().add(mStartPanel);
			pack();
			setVisible(true);
		}
		else if( PanelName == "Makeup") {
			this.remove(mStartPanel);
			mMakeupPanel = new MakeupPanel(this,userdata);
			getContentPane().add(mMakeupPanel);
			pack();
			setVisible(true);
		}
		else if( PanelName == "Closet") {
			this.remove(mMakeupPanel);
			mClosetPanel = new Closet(this,userdata);
			getContentPane().add(mClosetPanel);
			pack();
			setVisible(true);
		}
		else if( PanelName == "Finish") {
			this.remove(mClosetPanel);
			mEndPanel = new EndPanel(this,userdata);
			getContentPane().add(mEndPanel);
			pack();
			setVisible(true);
		}
		else if( PanelName == "reStart") {
			this.remove(mEndPanel);
			userdata.reset();
			reStartPanel = new StartPanel(this,userdata);
			getContentPane().add(reStartPanel);
			pack();
			setVisible(true);
		}
	}
}
