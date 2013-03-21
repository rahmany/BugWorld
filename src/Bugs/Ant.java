package Bugs;

public class Ant extends Organism
{
			
	public Ant(World world, int x, int y)
	{
		super(world, x, y, 3);
	}
	
	//returns a string representation of the Road Runner
	public String toString()
	{
		return "ant";
	}
	
	//The Road Runner always moves - all the time
	public boolean checkEmptySpotMovememnt()
	{
		return true;
	}
	
	//creates new Road Runners based newX/newY values from organism			
	public void makeChild(int newX, int newY ) 
	{
		
		
			world.setAt(newX, newY, new Ant(world,newX, newY));
		
		
	}
	
	
}
