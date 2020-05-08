package sfw;

public enum SoundType 
{
	GENERAL("General Sound"), BACKGROUND("Background Sound"), MUSIC("Music Sound"), AMBIANCE("Ambiance Sound"), DIALOGUE("Dialogue Sound"),
	MAIN("Main Sound");
	
	private String type;
	
	private SoundType(String name)
	{
		this.type = name;
	}
	
	public String toString()
	{
		return this.type;
	}
}
