package Bugs;

import acm.util.RandomGenerator;
 
public abstract class Organism
{
	protected World world;
	protected int x;
	protected int y;
	protected int breedIncrememnt;
	protected boolean simulated;
	// Orgbreed is the breed constant for the The Road Runner/Wile E. Coyote
	protected int Orgbreed;
	
	RandomGenerator rgen = RandomGenerator.getInstance();
	int randNum = rgen.nextInt(-1,1);
	 	
	public Organism(World world, int x, int y, int Orgbreed)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.Orgbreed = Orgbreed;
		simulated = true;
	}
	
	//returns the string representation of the organism
	public abstract String toString();
	
	public void simulate ()
	{
		
	//don't simulate twice in a round
				if(simulated) return;
				simulated = true;
				
				breedIncrememnt++;
	//if breedIncrememnt is equal to the organism's breed constant - create a new organism  					
		if(breedIncrememnt==Orgbreed)
			{
			checkEmptySpotBreed();
			breedIncrememnt=0;
			return;
			}
	// if it's not time to breed - then check whether you can move	
		else if (checkEmptySpotMovememnt())
			{
				move();
			}
	}
	// The boolean checks if an organism wants to move or do something more fun like starve or have children.
	public abstract boolean checkEmptySpotMovememnt(); 
	// This method checks left,right, up and down and then moves if it's empty 
	public void move()
	{
		int newX = x + randNum;
		int newY = y + randNum;
		
		if(world.pointInGrid(newX, newY)&&world.getAt(newX, newY)==null) 
		{
			world.setAt(newX, newY, this);
        	world.setAt(x, y, null);
        	this.x=newX;
        	this.y=newY;
        	
		}
      		
	}
	// The boolean checks to see if the space adjacent to an RoadRunner/Wile E Coyote is available and
	// then calls on makeChild method with the coordinates for reproduction
	public boolean checkEmptySpotBreed()
	 {
					
		 if(world.pointInGrid(x-1, y)&&world.getAt(x-1, y)==null)
		{
			 makeChild(x-1, y);
			 return true;
		}
			 
		 else if(world.pointInGrid(x+1, y)&&world.getAt(x+1, y)==null)
		 {
			 makeChild(x+1, y);
			 return true;
		 }
		 else if(world.pointInGrid(x, y-1)&&world.getAt(x, y-1)==null)
		 {
			 makeChild(x, y-1);
			 return true;
		 }
		 else if(world.pointInGrid(x, y+1)&&world.getAt(x, y+1)==null)
		 {
			 makeChild(x, y+1);
			 return true;
		 }
		 
		 else return false;
		
	 }
	// The method calls on to Ant/DoodleBug to reproduce
	public abstract void makeChild(int newX, int newY);	
	//indicate that the organism hasn't simulated this round
	public void resetSimulation()
	{
		simulated = false;
	}
		
}