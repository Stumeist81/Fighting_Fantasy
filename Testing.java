import java.util.Scanner;

public class Testing {
	
	static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test Character Creation
		PlayerCharacter myNewPlayer = new PlayerCharacter();
		myNewPlayer.createCharacter();
		
		Character zombieDog = new Character("Zombie Dog", 9, 10);
		
		Battle theBattle = new Battle(myNewPlayer, zombieDog);
		
		boolean didIWin = theBattle.fightBattle();
		
		System.out.println("So did I win? " + didIWin);		
		
		
		//Prototype of method for splitting down a lot of text.
		String myPhrase = "41/ You are stood in a dark corrdior. You see the remains of sacrifices hanging from the ceiling. Using your torch you "
				+ "walk down the crypt until you see a large red door. You can open the door if you wish or go back the way youy came. There is a large skeleton that slowly walks"
				+ "towards you, before you do anything you need to defeat this foe"
				+ " until you see sunlight. /1. Open the door. /2. Go back the way you came. /E Skeleton.8.11";
		
		System.out.println(myPhrase);
		
		String delims = "[/]";
		
		String[] tokens = myPhrase.split(delims);
		
		for (int i = 0; i < tokens.length; i++)
		{
			System.out.println(tokens[i]);
		}
		
		
		
	}

}
