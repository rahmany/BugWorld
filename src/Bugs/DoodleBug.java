package Bugs;

public class DoodleBug extends Organism

{	
	// starve counter for Wile
	private int starvCounter;
	
	public DoodleBug(World world, int x, int y)
	{
		super(world, x, y, 8);
	}
	
	//string representation of Wile Coyote
	public String toString()
	{
		return "doodlebug";
	}
	// this boolean check whether Wile E. Coyote employs absurdly complex move to catch the Road Runner or
	// starves to death
	public  boolean checkEmptySpotMovememnt()
	{
		if (!eat() && !die())
		{
			starvCounter++;
			return true;
		}
		else
		{
			return false;
		}

	}
	// this boolean checks to see if famished wile coyote needs to die
	private boolean die() 
	{
		
		if (starvCounter==3)
		{
			world.setAt(x,y,null);
			return true;
			
		}
		return false;
	}
	//this boolean creates a new Wile E.
	
	// this boolean checks all direction to see if there is a Road Runner to catch
	public boolean eat() 
	 {
		 
		if (eatAnt(x-1,y))return true;
        else if (eatAnt(x+1,y))return true;
        else if (eatAnt(x,y-1)) return true;
        else if (eatAnt(x,y+1))return true;
		
		 return false;

	}
	//this boolean check if there is an Ant near by
	private boolean eatAnt(int newX, int newY) 
	{
		
		 if(world.pointInGrid(newX, newY)&& world.getAt(newX, newY)!=null && world.getAt(newX, newY).toString()!="doodlebug")
		        	{
			 
			 			world.setAt(newX,newY,this);
			 			world.setAt(x,y,null);
			 			this.x=newX;
			 			this.y=newY;
			 			starvCounter=0;
			 			return true;
	
		        	}
		       
		  	return false;  
		  	  	
	}
	public void makeChild(int newX, int newY) 
	{
		world.setAt(newX, newY, new DoodleBug(world,newX, newY));
	
	}	

}