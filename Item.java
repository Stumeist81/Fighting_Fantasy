/** 
 * Item class is used to create objects which can be found in the game and possibly added to player inventory. 
 * Class will provide setter and getter methods.
 *
 * @author Stumeist
 * @version 1.0
 *
 */
public class Item {
	
	private String itemName;
	private boolean equippable;
	private boolean usable;
	private String itemType; 
	private int skillMod; // Used for storing the value an item may increase (or decrease) the players skill attribute
	private int staminaMod; // Used for storing the value an item may increase (or decrease) the players stamina attribute
	
	/**
	 * Constructor for items of class Item
	 */
	public Item()
	{
		
	}
	
	/**
	 * Constructor for objects of class Item which takes arguments to set itemName, equippable, usable, itemType, skillMod and
	 * staminaMod.
	 */
	public Item(String itemName, boolean equippable, boolean usable, String itemType, int skillMod, int staminaMod)
	{
		this.itemName = itemName;
		this.equippable = equippable;
		this.usable = usable;
		this.itemType = itemType;
		this.skillMod = skillMod;
		this.staminaMod = staminaMod;
	}
	
	
	
	/**
	 * @return the itemName
	 */
	public String getItemName() 
	{
		return itemName;
	}
	
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	/**
	 * @return the equippable
	 */
	public boolean isEquippable() 
	{
		return equippable;
	}

	/**
	 * @param equippable the equippable to set
	 */
	public void setEquippable(boolean equippable) 
	{
		this.equippable = equippable;
	}

	/**
	 * @return the usable
	 */
	public boolean isUsable()
	{
		return usable;
	}

	/**
	 * @param usable the usable to set
	 */
	public void setUsable(boolean usable)
	{
		this.usable = usable;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType()
	{
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType)
	{
		this.itemType = itemType;
	}

	/**
	 * @return the skillMod
	 */
	public int getSkillMod()
	{
		return skillMod;
	}

	/**
	 * @param skillMod the skillMod to set
	 */
	public void setSkillMod(int skillMod)
	{
		this.skillMod = skillMod;
	}

	/**
	 * @return the staminaMod
	 */
	public int getStaminaMod()
	{
		return staminaMod;
	}

	/**
	 * @param staminaMod the staminaMod to set
	 */
	public void setStaminaMod(int staminaMod)
	{
		this.staminaMod = staminaMod;
	}
	
	/**
	 * Displays all attributes of the receiver.
	 */
	public void showInfo()
	{
		System.out.println("Name: " + this.getItemName());
		System.out.println("Equippable: " + this.isEquippable());
		System.out.println("Usable: "+ this.isUsable());
		System.out.println("Item Type: "+ this.getItemType());
		System.out.println("Skill Modifier: "+ this.getStaminaMod());
		System.out.println("Stamina Modifier: "+ this.getSkillMod());
	}

}
