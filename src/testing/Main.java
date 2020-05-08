package testing;

import java.io.File;

import sfw.AudioMix;
import sfw.AudioPlay;
import sfw.AudioSequence;
import sfw.Sound;
import sfw.SoundType;

public class Main
{
	public static void main(String[] args)
	{
			// Creating Base Class Objects
			Sound s1 = new Sound(new File("ghost.wav"));
			Sound s2 = new Sound(new File("harp.wav"));
			Sound s3 = new Sound(new File("misty.wav"));
			Sound s4 = new Sound(new File("synth.wav"));
		
			// Testing Sound
//			AudioPlay.changeVolume(80, s1); 	// s1 at 80% volume
//			AudioPlay.play(s1, 2);				// Playing s1 for 2 seconds
//			AudioPlay.play(s2);
			
			// Testing AudioMix
//			AudioMix am1 = new AudioMix();
//			am1.mix(s1, s2);
//			AudioPlay.changeVolume(90, am1);
//			AudioPlay.play(am1, 4);
			
			// Testing AudioSequence
//			AudioSequence aS1 = new AudioSequence(); // Make sure the audio format is the same for all files
//			aS1.addSound(s4);
//			aS1.addSound(s1);
//			AudioPlay.play(aS1);

			// Testing Standard Methods
//			Sound s5 = s2.clone();					// clone method
//			System.out.println(s5.equals(s2));		// equals method
//			System.out.println(s5.equals(s1));		// print method
			
			// General methods
//			AudioMix am2 = new AudioMix();
//			am2.mix(s1, s2);
//			am2.exportSound("Export_Sound", "C:\\Users\\The Jenkka\\eclipse-workspace\\SoundFilesWrapper\\"); // Export sound to PC
//			System.out.println(am2);
//			
//			s1.setSoundName("New Sound");
//			s1.setSoundType(SoundType.MAIN);
//			AudioPlay.changeVolume(80, s1);
//			System.out.println(s1);
	}
}
