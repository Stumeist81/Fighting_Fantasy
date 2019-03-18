import java.util.Scanner;

/**
 * Class for player character. Extends the Character class, adds luck attribute, adds an inventory (of class CharacterInventory), jewels,
 * rations and gold attributes. Includes all relevant getter and setter methods.
 * 
 * @author Stumeist
 *
 */


public class PlayerCharacter extends Character {
	
	//Adding additional instance variables that are not in class Character.
	private int luck;
	private int gold;
	private int provisions;
	
	//Adding a CharacterInventory instance.
	private CharacterInventory playerInventory;
	
	/**
	 * Constructor for objects of class playerCharacter.
	 */
	public PlayerCharacter()
	{
		//Initialise super class and all additional instance variables.
		super();
		this.setLuck(0);
		this.setGold(0);
		this.setProvisions(0);
		
		//Initialise the CharacterInventory instance;
		this.playerInventory = new CharacterInventory();
	}
	
	
	public PlayerCharacter(String aName, int aSkill, int aStamina, int aLuck, int aGold, int aProvisions)
	{
		//Initialise instance variables to values passed by argument
		super(aName, aSkill, aStamina);
		this.setLuck(aLuck);
		this.setGold(aGold);
		this.setProvisions(aProvisions);
		
		//Initialise the CharacterInventory instance;
		this.playerInventory = new CharacterInventory();
	}


	/**
	 * @return the luck
	 */
	public int getLuck() {
		return luck;
	}


	/**
	 * @param luck the luck to set
	 */
	public void setLuck(int luck) {
		this.luck = luck;
	}


	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}


	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}


	/**
	 * @return the provisions
	 */
	public int getProvisions() {
		return provisions;
	}


	/**
	 * @param provisions the provisions to set
	 */
	public void setProvisions(int provisions) {
		this.provisions = provisions;
	}
	
	/**
	 * Guides the player through the character creation process and sets all instance variables accordingly.
	 * Default items, gold and provisions are added.
	 */
	public void createCharacter()
	{
		// Create a Scanner object to read user input
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//Prompt the user to enter a new for their character
		System.out.println("Welcome to Character Creation");
		System.out.println("This will guide you through the process of creating a new character for your adventure!");
		System.out.print("Please enter a name for your character: ");
		
		String myName = sc.nextLine();
		this.setCharacterName(myName);
				
		this.setSkill(this.rollDice() + 6);
		this.setStamina(this.rollDice() + this.rollDice() + 12 );
		this.setLuck(this.rollDice() + 6);
		this.setProvisions(10);
				
		//Give player the choice of taking a bottle of skill, strength or fortune and add item player inventory.
		boolean myStarterPotion = false;
		System.out.println(this.getCharacterName() + ", you may take one of the following with you on your adventure. Please choose wisely.");
		System.out.println("1) A Potion of Skill");
		System.out.println("2) A Potion of Strength");
		System.out.println("3) A Potion of Luck");
		System.out.println("Please enter your choice: ");
				
		int choice = sc.nextInt();
				
		while(myStarterPotion == false)
		{
			switch(choice)
			{
			case 1:
				Item mySkillPotion = new Item("Potion of Skill", false, true, "Potion", 0, 0);
				this.takeItem(mySkillPotion);
				myStarterPotion = true;
				break;			
			case 2:
				Item myStrengthPotion = new Item("Potion of Strength", false, true, "Potion", 0, 0);
				this.takeItem(myStrengthPotion);
				myStarterPotion = true;
				break;
			case 3:
				Item myLuckPotion = new Item("Potion of Skill", false, true, "Potion", 0, 0);
				this.takeItem(myLuckPotion);
				myStarterPotion = true;
				break;		
			default:
				System.out.println("Please try again as that choice does not exist!");
				System.out.println("Please enter your choice: ");
				choice = sc.nextInt();				
				break;
			}
		}
		
		
		System.out.println("You have managed to find an Iron sword and some leather armour, these will be added to your inventory");
		Item myIronSword = new Item("Iron Sword", true, false, "Weapon", 0, 0);
		this.takeItem(myIronSword);
		Item myLeatherArmour = new Item("Leather Armour", true, false, "Armour", 0, 0);
		this.takeItem(myLeatherArmour);
		
		
		System.out.println ("Greetings " + this.getCharacterName() + ", Please see your character stats below:");
		System.out.println("Skill: " + this.getSkill());
		System.out.println("Stamina: " + this.getStamina());
		System.out.println("Luck: " + this.getLuck());
		System.out.println("Provisions: " + this.getProvisions());
		System.out.println("Gold: " + this.getGold());
		
		
		System.out.println();
		
		System.out.println(this.getCharacterName() + "Your inventory is as follows: ");
		this.playerInventory.listAll();	
		
	}
	
	/**
	 * 
	 * Adds an item to the players inventory.
	 * 
	 */
	public void takeItem(Item anItem)
	{
		this.playerInventory.addItem(anItem);
	}
	
	/**
	 * Returns a boolean value indicating if the player luck score is higher than zero.
	 */
	public boolean haveLuck()
	{
		if (this.getLuck() >= 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Performs a luck check and returns a boolean indicating the result.
	 * Luck attribute is reduced by 1.
	 */
	public boolean luckCheck()
	{
		if ((this.rollDice() + this.rollDice()) <= this.getLuck())
		{
			this.setLuck(this.getLuck() - 1);
			return true;
		}
		else
		{
			this.setLuck(this.getLuck() - 1);
			return false;
		}
	}
	
	
	
	

}
