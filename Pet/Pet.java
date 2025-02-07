public class Pet
{
	private String name;

	public Pet(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void makeNoise()
	{
		System.out.println("Noise");
	}

	public String toString()
	{
		return name + " is a " + getClass().getName();
	}
}