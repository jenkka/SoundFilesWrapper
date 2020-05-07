package sfw;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class AudioPlay
{
	private static int playLength = 10_000;
	
	public static void play(AudioInputStream audioStream) 
	{
		try
		{
			Clip c = AudioSystem.getClip();
			c.open(audioStream);
			c.start();
			Thread.sleep(playLength);
		}
		catch(Exception ex)
		{
			System.out.println("No se puede reproducir el archivo.");
		}
	}	
	
	public static void play(AudioInputStream audioStream, int length) 
	{
		try
		{
			Clip c = AudioSystem.getClip();
			c.open(audioStream);
			c.start();
			Thread.sleep(length * 1000);
		}
		catch(Exception ex)
		{
			System.out.println("No se puede reproducir el archivo.");
		}
	}	
	
	public static void setPlayLenght(int l) { if(l > 0) { playLength = l * 1000; } }
}
