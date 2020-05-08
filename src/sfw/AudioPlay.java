package sfw;

import javax.sound.sampled.FloatControl;

public abstract class AudioPlay
{
	public static void play(Sound s) 
	{
		try
		{
			s.getClip().open(s.getAudio());
			FloatControl gainControl = (FloatControl) s.getClip().getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(s.getVolume());
			s.getClip().start();
			Thread.sleep(s.getClip().getMicrosecondLength());
		}
		catch(Exception ex)
		{
			System.out.println("No se puede reproducir el archivo.");
		}
	}	
	
	public static void play(Sound s, int length) 
	{
		try
		{
			s.getClip().open(s.getAudio());
			FloatControl gainControl = (FloatControl) s.getClip().getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(s.getVolume());
			s.getClip().start();
			Thread.sleep(length * 1000);
		}
		catch(Exception ex)
		{
			System.out.println("No se puede reproducir el archivo.");
		}
	}	
	
	public static void play(AudioSequence aS)
	{
		try
		{
			aS.getClip().open(aS.getAudio());
			FloatControl gainControl = (FloatControl) aS.getClip().getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(aS.getVolume());
			aS.getClip().start();
			Thread.sleep(aS.getClip().getMicrosecondLength());
		}
		catch(Exception ex)
		{
			System.out.println("No se puede reproducir el archivo.");
		}
	}
	
	public static void play(AudioSequence aS, int length) 
	{
		try
		{
			aS.getClip().open(aS.getAudio());
			FloatControl gainControl = (FloatControl) aS.getClip().getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(aS.getVolume());
			aS.getClip().start();
			Thread.sleep(length * 1000);
		}
		catch(Exception ex)
		{
			System.out.println("No se puede reproducir el archivo.");
		}
	}	
	
	public static void changeVolume(float f, Sound s) 
	{	
		if(f >= AudioInfo.MIN_SOUND && f <= AudioInfo.MAX_SOUND) 
		{ 
			if(f < 20) { s.setVolume(20); }
			else {s.setVolume(f - AudioInfo.MAX_SOUND); }
		} 
	}
}
