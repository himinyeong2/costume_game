import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	// 배경음악 MainFrame에서 반복 재생
			private Clip clip;
			private File clap;
			
			public Sound(File Sound) {
				clap = Sound;
				
				try {
					clip = AudioSystem.getClip	();
					clip.open(AudioSystem.getAudioInputStream(clap));					
				}
				catch(Exception e) {	
				}
			}
			
			public void play() {
				clip.setFramePosition(0);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			}
			public void stop() {
				clip.stop();
			}
}
