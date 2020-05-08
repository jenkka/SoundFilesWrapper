package sfw;

import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;

public class AudioSequence extends Sound
{
	private List<Sound> seq = new ArrayList<>();
	
	public AudioSequence() { super(); }
	
	public void addSound(Sound s) 
	{ 
		seq.add(s);
		convertToSequence(seq);
	}
	
	private void convertToSequence(List<Sound> ls)
	{
		AudioInputStream clip1 = ls.get(0).getAudio();
    	long seqLength = 0;
    	for(int i = 0; i < seq.size(); i++) { seqLength += ls.get(i).getAudio().getFrameLength(); }
     	for(int i = 1; i < ls.size(); i++)
    	{
        	AudioInputStream clip2 = ls.get(i).getAudio();
            clip1 = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), seqLength);
    	}
     	super.setSound(clip1);
	}
}
