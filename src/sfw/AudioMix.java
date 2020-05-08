package sfw;

import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioInputStream;

public class AudioMix extends Sound
{
	public AudioMix()
	{
		super();
	}
	
	public void mix(Sound s1, Sound s2) {
		
		byte[] bufferA = s1.convertToByteArray();
		byte[] bufferB = s2.convertToByteArray();
	    byte[] array = new byte[Math.max(bufferA.length, bufferB.length)];

	    for (int i=0; i< array.length / 2; i+=2) 
	    {
	    	try
	    	{
	    		short buf1A = bufferA[i+1];
			    short buf2A = bufferA[i];
		        buf1A = (short) ((buf1A & 0xff) << 8);
		        buf2A = (short) (buf2A & 0xff);

		        short buf1B = bufferB[i+1];
		        short buf2B = bufferB[i];
		        buf1B = (short) ((buf1B & 0xff) << 8);
		        buf2B = (short) (buf2B & 0xff);

		        short buf1C = (short) (buf1A + buf1B);
		        short buf2C = (short) (buf2A + buf2B);

		        short res = (short) (buf1C + buf2C);

		        array[i] = (byte) res;
		        array[i+1] = (byte) (res >> 8);
	    	}catch(Exception ex) { }
	    }
	    
	    AudioInputStream stream = new AudioInputStream(
	            new ByteArrayInputStream(array),
	            s1.getFormat(),
	            array.length
	    		);
	    
	    super.setSound(stream);
	}
}
