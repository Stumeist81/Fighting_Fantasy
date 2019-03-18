import java.util.Random;

/**
 * Objects of the Dice class are used to simulate dice.
 * Once created, there is only one method accessible called
 * roll(int). This allows the simulation of rolling a dice. 
 * A single number is returned which represents the value 
 * shown when a dice is rolled. 
 * 
 * @author Stumeist
 * @version 1.0
 */

public class Dice {

	/**
	 * Constructor for objects of class Dice. There are 
	 * no variables to initialise.
	 */
	public Dice()
	{
		
	}
	
	/**
	 * Simulates rolling a dice. The number of sides for
	 * the dice is passed via argument. A single int is returned
	 * which will have a randomly generated number between 1 and 
	 * the value passed via argument. 
	 */
	public int roll(int numSides)
	{	
		Random rand = new Random();
		return rand.nextInt(numSides) + 1;
	}

}
