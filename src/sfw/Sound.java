package sfw;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound implements AudioInfo
{
	private File file = null;
	private AudioInputStream audio = null;
	private AudioFormat format = null;
	private DataLine.Info info = null;
	private SourceDataLine line = null;
	private String soundName = "";
	private int soundTag;
	private SoundType type = SoundType.GENERAL;
	private Clip c = null;
	private float volume = 0.0f;
	private static int worldTag = 0;
	
	// Constructors //////////////////////////////////////////////////////////////////////////
	
	public Sound(File f)
	{
		soundTag = worldTag++;
		setupFile(f);
	}
	protected Sound() { soundTag = worldTag++; }
	public void finalize() { worldTag--; }
	
	// Setters ///////////////////////////////////////////////////////////////////////////////
	
	protected void setSound(AudioInputStream stream) 
	{
		file = null;
		audio = stream;
		format = audio.getFormat();
		info = new DataLine.Info(SourceDataLine.class, format);
		
		try 
		{
			line = (SourceDataLine)AudioSystem.getLine(info);
			c = AudioSystem.getClip();
		} catch (LineUnavailableException e) { System.out.println("Error de buffer."); }
	}
	
	void setFile(File f) 
	{
		try { audio = AudioSystem.getAudioInputStream(f); } 
		catch (UnsupportedAudioFileException e) { 
			System.out.println("Tipo de audio no soportado.");
		} catch (IOException e) { System.out.println("Error al reproducir."); }
		
		format = audio.getFormat();
		info = new DataLine.Info(SourceDataLine.class, format);
		
		try 
		{
			line = (SourceDataLine)AudioSystem.getLine(info);
			c = AudioSystem.getClip();
		} catch (LineUnavailableException e) { System.out.println("Error de buffer."); }
	}
	

	public void setSoundType(SoundType st) { this.type = st; }
	public void setSoundName(String s) { soundName = s; }
	protected void setVolume(float f) { volume = f; }
	protected void setFormat(AudioFormat aF) { format = aF; }
	protected void setInfo(DataLine.Info i) { info = i; } 
	protected void setLine(SourceDataLine l) { line = l; }
	protected void setClip(Clip clip) { c = clip; }

	// Getters /////////////////////////////////////////////////////////////////////////////
	public AudioInputStream getAudio() { return audio; }
	public File getFile() { return file; }
	public AudioFormat getFormat() { return format; }
	public DataLine.Info getInfo() { return info; }
	public SourceDataLine getLine() { return line; }
	public SoundType getSoundType() { return type; }
	public Clip getClip() { return c; }
	public float getVolume() { return volume; }
	public int getSoundTag() { return soundTag; }
	public String getSoundName() { return soundName; }

	// Methods //////////////////////////////////////////////////////////////////////////
	
	public void exportSound(String name, String path)
	{
        try 
        {
			AudioSystem.write(this.getAudio(), 
			AudioFileFormat.Type.WAVE, 
			file = new File(path + name + ".wav"));
			setupFile(file);
		} catch (IOException e) { System.out.println("Error exportando el archivo."); }
	}
	
	protected byte[] convertToByteArray()
	{
		AudioInputStream input = audio;
	    try 
	    {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    int read;
		    byte[] buffer = new byte[1024];
		    while ((read = input.read(buffer)) != -1) { baos.write(buffer, 0, read); }
			baos.flush();
			
		    return baos.toByteArray();
		} catch (IOException e) { System.out.println("Error convirtiendo a byte array."); }
		return null;
	}
	
	public void setupFile(File fIn)
	{
		file = fIn;
		try { audio = AudioSystem.getAudioInputStream(fIn); } 
		catch (UnsupportedAudioFileException e) { 
			System.out.println("Tipo de audio no soportado.");
		} catch (IOException e) { System.out.println("Error al reproducir."); }
		
		format = audio.getFormat();
		info = new DataLine.Info(SourceDataLine.class, format);
		
		try 
		{
			line = (SourceDataLine)AudioSystem.getLine(info);
			c = AudioSystem.getClip();
		} catch (LineUnavailableException e) { System.out.println("Error de buffer."); }
	}
	
	public String toString()
	{	
		return  "Name: " + this.getSoundName() +
				"\nTag: " + this.getSoundTag() +
				"\nType: " + this.getSoundType() +
				"\nVolume: " + (this.getVolume() + 100.0f) +
				"\nFile: " + this.getFile() +
				"\nAudio Input Stream: " + this.getAudio() +
				"\nAudio Format: " + this.getFormat() +
				"\nData Line Info: " + this.getInfo() +
				"\nSource Data Line: " + this.getLine() +
				"\nClip: " + this.getClip() + "\n";
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Sound)) return false;
			
		Sound compare = (Sound) o;
		if(this.getSoundName() == compare.getSoundName())
		if(this.getSoundType() == compare.getSoundType())
		if(this.getVolume() == compare.getVolume())
		if(this.getAudio() == compare.getAudio())
		if(this.getFormat() == compare.getFormat())
		if(this.getInfo() == compare.getInfo())
		if(this.getLine() == compare.getLine())
		if(this.getClip() == compare.getClip())
		{ return true; }
	
		return false;
	}
	
	public Sound clone()
	{
		Sound sClone = new Sound();
		sClone.setSoundName(this.getSoundName());
		sClone.setSoundType(this.getSoundType());
		sClone.setVolume(this.getVolume());
		sClone.setSound(this.getAudio());
		sClone.setFormat(this.getFormat());
		sClone.setInfo(this.getInfo());
		sClone.setLine(this.getLine());
		sClone.setClip(this.getClip());
		return sClone;
	}
}
