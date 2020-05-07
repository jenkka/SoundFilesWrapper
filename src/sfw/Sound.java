package sfw;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Control;
import javax.sound.sampled.Control.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements AudioInfo
{
	private File file;
	private AudioInputStream audio;
	private AudioFormat format;
	private DataLine.Info info;
	private SourceDataLine line;
	private String soundName = "";
	private int soundTag;
	
	private static int worldTag = 0;
	
	public Sound(File f)
	{
		try 
		{
			soundTag = worldTag++;
			file = f;
			audio = AudioSystem.getAudioInputStream(file);
			format = audio.getFormat();
			info = new DataLine.Info(SourceDataLine.class, format);
			line = (SourceDataLine)AudioSystem.getLine(info);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public File getFile() { return file; }
	public AudioInputStream getAudio() { return audio; }
	public AudioFormat getFormat() { return format; }
	public DataLine.Info getInfo() { return info; }
	public SourceDataLine getLine() { return line; }

	@Override
	public int getSoundTag() { return soundTag; }

	@Override
	public String getSoundName() { return soundName; }
	
	@Override
	public void setSoundName(String s) { soundName = s; }

}
