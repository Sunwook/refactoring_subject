package srp15.move.embellishment.to.decorator.before;

public class WriterPolicy
{
	private boolean capitalized = false;

	public boolean isCapitalized()
	{
		return capitalized;
	}

	public void setCapitalized(boolean capitalized)
	{
		this.capitalized = capitalized;
	}	
}
