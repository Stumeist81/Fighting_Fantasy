import java.util.Scanner;

/**
 *
 * System for working out battle rounds. Class takes player and opponent, then performs battle steps.
 * Luck and escaping to be added once basic system works.
 * @author Stumeist
 *
 */

public class Battle {
	
	@SuppressWarnings("unused")
	private PlayerCharacter player;
	@SuppressWarnings("unused")
	private Character enemy;
	
	/**
	 * Constructor for Battle class that takes no arguments.
	 */
	public Battle()
	{
		this.player = new PlayerCharacter();
		this.enemy = new Character();		
	}
	
	/**
	 * Constructor which takes a Character and PlayerChracter as arguments
	 */
	public Battle(PlayerCharacter aPlayerCharacter, Character aCharacter)
	{
		this.player = aPlayerCharacter;
		this.enemy = aCharacter;
	}
	
	/**
	 * Class which performs a round of combat between player and enemy.
	 * Round mechanics are as follows
	 * Player calls attack function
	 * Enemy calls attack function
	 * winner is player or character with highest score
	 * loser takes damage
	 * if scores are equal, no damage dealt
	 */
	private void battleRound()
	{
		boolean luckyPlayer = false;
		boolean useLuck = false;
		int playerScore = this.player.attack();
		int enemyScore = this.enemy.attack();
		
		System.out.println("You roll: " + playerScore);
		System.out.println(this.enemy.getCharacterName() + " rolls a " + enemyScore);
		
		if ((player.haveLuck() == true) && (playerScore != enemyScore))
		{
		useLuck = this.luckCheck();
		}
		
		if (useLuck == true)
		{
			luckyPlayer = this.player.luckCheck();
		}
		
		//NEED TO ADD CODE TO CHECK IF PLAYER WANTS TO USE LKUCK AND WHAT THE RESULT IS TO DETERMINE BATTLE RESULT.
		
		if (playerScore == enemyScore)
		{	
			System.out.println("You parry the attack from " + this.enemy.getCharacterName());
		}
		else if (playerScore > enemyScore)
		{	
			if ((useLuck == true) && (luckyPlayer == true))
			{
			System.out.println("You successfully hit and wound " + this.enemy.getCharacterName());
			this.enemy.takeHit();
			System.out.println("Your good luck gives you another hit on " + this.enemy.getCharacterName());
			this.enemy.takeHit();
			}
			else if ((useLuck == true) && (luckyPlayer == false))
			{
			System.out.println("You are unlucky and totally miss " + this.enemy.getCharacterName());
			}
			else
			{
			System.out.println("You successfully hit and wound " + this.enemy.getCharacterName());
			this.enemy.takeHit();
			}
		}
		else if (playerScore < enemyScore)
		{
			
			if ((useLuck == true) && (luckyPlayer == true))
			{
				System.out.println("You successfully dodge the attack from " + this.enemy.getCharacterName());
			}
			else if ((useLuck == true) && (luckyPlayer == false))
			{
				System.out.println("You are unlucky and " + this.enemy.getCharacterName() + " nmanages to hit you twice");
				this.player.takeHit();
				this.player.takeHit();
			}
			else
			{
				System.out.println("You are struck and wounded by " + this.enemy.getCharacterName());
				this.player.takeHit();
			}

		}
	}
	
	/**
	 * Runs a series of battle rounds until either the player or the enemy is dead
	 * Returns a boolean indicating the status of the character
	 * @return
	 */
	public boolean fightBattle()
	{
		System.out.println("You start fighting with " + this.enemy.getCharacterName());
		
		while ((this.player.checkAlive() != false) && (this.enemy.checkAlive() != false))
		{
			this.battleRound();
		}
		
		if (this.player.checkAlive() == true)
		{
			System.out.println("You successfully slay the " + this.enemy.getCharacterName());
			return true;
		}
		else
		{
			System.out.println("You have been butchered by the " + this.enemy.getCharacterName());
			return false;
		}
		
	}
	
	/**
	 * Checks if user wants to use luck for attack or defense.
	 */
	public boolean luckCheck()
	{
		
		boolean validChoice = false;
				
		Scanner fc = new Scanner(System.in);
		System.out.println("Do you wish to try your luck:");
		System.out.println("1: Y");
		System.out.println("2: N");
		int myChoice = fc.nextInt();
		
		while(validChoice == false)
		{
			switch(myChoice)
			{
			case 1:
				validChoice = true;
				break;				
							
			case 2:
				validChoice = true;
				break;				
			default:
				System.out.println("Please try again as that choice does not exist!");
				System.out.println("Please enter your choice: ");
				myChoice = fc.nextInt();				
				break;
			}
		}
		
		if (myChoice == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	

}
