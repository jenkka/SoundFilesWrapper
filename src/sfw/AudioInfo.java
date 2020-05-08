package sfw;

public interface AudioInfo 
{	
	public static final float MAX_SOUND = 100.0f;
	public static final float MIN_SOUND = 20.0f;
	
	public int getSoundTag();
	public void setSoundName(String s);
	public String getSoundName();
}
