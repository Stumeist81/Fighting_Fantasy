import java.util.*;

/** 
 * Class that holds a list of Item objects. Class methods allow the addition and removal of Items from the inventory. 
 * It is also possible to list all items or list them by Item type.  
 * 
 * @author Stumeist
 * @version 1.0
 */

public class CharacterInventory {

	List<Item> itemList;
	private int numItems;
	
	/**
	 * Constructor for CharacterInventory. No arguments included.
	 */
	public CharacterInventory()
	{
		itemList = new ArrayList<>();
	}

	/**
	 * @return the numItems
	 */
	public int getNumItems()
	{
		return numItems;
	}

	/**
	 * @param numItems the numItems to set
	 */
	public void setNumItems()
	{
		this.numItems = itemList.size();
	}
	
	/**
	 * Add an Item to the reciever. Item object is passed via argument.
	 */
	public void addItem(Item anItem)
	{
		itemList.add(anItem);
		this.setNumItems();
	}
	
	/**
	 * Removes an item from the reciever. Index of Item to remove is passed by argument.
	 */
	public void removeItem(int itemIndex)
	{
		itemList.remove(itemIndex);
		this.setNumItems();
	}
	
	/**
	 * Prints the contents of the list on the screen, index followed by Item name
	 */
	public void listAll()
	{
		for (int itemIndex = 0; itemIndex < this.numItems; itemIndex++ )
		{
			System.out.println(itemIndex + ": " + itemList.get(itemIndex).getItemName() + "      Type: " + itemList.get(itemIndex).getItemType());
		}
	}	
}


