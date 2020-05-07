package sfw;
import sfw.Sound;

import javax.sound.sampled.Clip;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			Sound s1 = new Sound(new File("ghost.wav"));
//			AudioPlay.setPlayLenght(1);
			AudioPlay.play(s1.getAudio(), 3);
//			s1.setSoundName("Ghostly");
//			System.out.println(s1.getSoundName());
//			System.out.println(s1.getSoundTag());
			
			
//			Sound s2 = new Sound(new File("harp.wav"));
//			AudioPlay.setPlayLenght(2);
//			AudioPlay.play(s2.getAudio());
//			System.out.println(s2.getSoundTag());
			
		}
		catch(Exception ex)
		{
			
		}
	}
}
