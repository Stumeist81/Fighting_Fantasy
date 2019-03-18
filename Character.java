/**
 * Base class for all characters, monsters and npc's. Basic attributes are name, skill and stamina.
 * Class will also provide setter, getter, increase and decrease methods.
 * 
 * @author Stumeist
 * @version 1.0
 */

public class Character {
	
	//Instance variables.
	
	private String characterName; 
	private int skill;
	private int stamina;
	private Dice playerDice; //Every character will have a dice. This will be used for setting initial stats if required, fighting, etc.
	
	
	/**
	 * Constructor for objects of class Character.
	 */
	public Character()
	{
		characterName = "New Character"; //Character name can be set by method setName.
		this.skill = 0;
		this.stamina = 0;
		this.playerDice = new Dice();
	}
	
	/**
	 * Constructor for objects of class character which takes arguments to set characterName, skill and stamina.
	 */
	public Character(String aName, int aSkill, int aStamina)
	{
		//Initialise instance variables to values passed by argument
		this.characterName = aName;
		this.skill = aSkill;
		this.stamina = aStamina;
		playerDice = new Dice();
	}
	
	/**
	 * Returns the characterName of the receiver.
	 */
	public String getCharacterName()
	{
		return characterName;
	}
	
	/**
	 * Returns the skill of the receiver.
	 */
	public int getSkill()
	{
		return skill;
	}
	
	/**
	 * Returns the stamina of the receiver.
	 */
	public int getStamina()
	{
		return stamina;
	}
	
	/**
	 * Sets the characterName of the receiver.
	 */
	public void setCharacterName(String aString)
	{
		this.characterName = aString;
	}
	
	/**
	 * Sets the skill of the receiver.
	 */
	public void setSkill(int aSkill)
	{
		this.skill = aSkill;
	}
	
	/**
	 * Sets the stamina of the receiver.
	 */
	public void setStamina(int aStamina)
	{
		this.stamina = aStamina;
	}	
	
	/**
	 * This is the method called when character takes a hit in combat.
	 * the character's stamina is reduced by 2. 
	 * NEED TO IMPLEMENT CHECK AS STAMINA CANNOT GO BELOW XERO
	 */
	public void takeHit()
	{
		this.setStamina(this.getStamina() - 2);
	}
	
	/**
	 * This is the method used to attack. Value returned is D6 + skill.
	 * D6 value is  obtained by use of playerDice.	  
	 */
	public int attack()
	{
		return playerDice.roll(6) + this.skill;
	}

	/**
	 * Displays all attributes of the receiver.
	 */
	public void showInfo()
	{
		System.out.println("Name: " + this.getCharacterName());
		System.out.println("Skill: " + this.getSkill());
		System.out.println("Stamina: "+ this.getStamina());
	}
	
	/**
	 *Calls a dice roll method and returns it as an int value. Used whenever a dice roll is needed.
	 */
	public int rollDice()
	{
		return playerDice.roll(6);
	}
	
	/**
	 * Returns a boolean which is true if character stamina is 1 or higher and false if 0 or lower.
	 */
	public boolean checkAlive()
	{
		if (this.getStamina() >= 1 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
