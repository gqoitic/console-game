package com.gqoitic.console_game.game;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import com.gqoitic.console_game.characters.Hero;
import com.gqoitic.console_game.characters.HeroClass;
import com.gqoitic.console_game.characters.Team;
import com.gqoitic.console_game.characters.Character;

public class Game {
	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();
	
	private static int turn = 0;
	
	static void increaseTurn() { turn++; }
	
	private String name;
	private Team team;
	private int randomChoice;
	private int choice;
	private HeroClass heroClass;
	
	private static int blueTracker = 5;
	private static int redTracker = 5;
	
	private static int id = 1;
	
	Character player;
	
	public void gameProcess() {
		beginningOfTheGame();
		
		boolean process = true;
		
		while(process) {
			for(Character movingHero : Hero.listOfHeroes) {
				if(Hero.listOfHeroes.indexOf(movingHero) == 0) {
					
					if(!player.isAlive()) {
						System.out.printf("%n==TURN: [%d]==%n", turn);
					}
					
					increaseTurn();
				}
				
				if(!movingHero.isAlive()) continue;
				
				if(movingHero.isPlayer()) {
					attackById(movingHero);
				} else {
					
					try{
						Thread.sleep(1000);
					} catch(Exception ex) {
						ex.getMessage();
					}
					
					attackRandom(movingHero);
				}
				
				if(isEnd()) {
					process = false;
					showTurnsAtTheEnd();
					break;
				}
				
			}
		}
	}
	
	void beginningOfTheGame() {
		// intro

		name      = choosingName();
		team      = choosingTeam();
		heroClass = choosingHeroClass();
		
		player = Character.create(id++, team, name, heroClass, true);
		
		// adds [team] to the beginning of name
		changePlayerName();

		printPlayer();
		
		// creating other 9 players (bots)
		createBots();
	}
	
	private void changePlayerName() {
		if(player.getTeam() == Team.RED) {
			player.setName("[RED]" + player.getName());
		} else if(player.getTeam() == Team.BLUE) {
			player.setName("[BLUE]" + player.getName());
		}
	}
	
	private String choosingName() {
		System.out.print("\nEnter your name: ");
		name = scanner.nextLine();
		
		if(Objects.isNull(name) || name.isEmpty()) {
			name = "Player";
		}
		return name;
	}
	
	private Team choosingTeam() {
		System.out.print("Choose your team:\n"
				+ "[1]Red\n"
				+ "[2]Blue\n"
				+ "[3]Random\n\n>>");
		
		choice = scanner.nextInt();
		
		if(choice == 3) {
			randomChoice = random.nextInt(10);
			
			choice = randomChoice > 4 ? 1 : 2;
		}
		
		switch(choice) {
		case 1:
			team = Team.RED;
			break;
		case 2:
			team = Team.BLUE;
			break;
		}
		
		if (team == Team.BLUE) blueTracker--;
		else if (team == Team.RED) redTracker--;
		
		return team;
	}
	
	private HeroClass choosingHeroClass() {
		System.out.print("Choose your hero:\n"
				+ "[1]Tank\n"
				+ "[2]Healer\n"
				+ "[3]Killer\n"
				+ "[4]Mage\n\n>>");
		
		choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			heroClass = HeroClass.TANK;
			break;
		case 2:
			heroClass = HeroClass.HEALER;
			break;
		case 3:
			heroClass = HeroClass.KILLER;
			break;
		case 4:
			heroClass = HeroClass.MAGE;
			break;
		}
		
		return heroClass;
	}
	
	private HeroClass getRandomHeroClass() {
		HeroClass randomHeroClass = null;
		
		int randInt = random.nextInt(4);
		
		switch(randInt) {
		case 0:
			randomHeroClass = HeroClass.TANK;
			break;
		case 1:
			randomHeroClass = HeroClass.HEALER;
			break;
		case 2:
			randomHeroClass = HeroClass.KILLER;
			break;
		case 3:
			randomHeroClass = HeroClass.MAGE;
			break;
		}
		
		return randomHeroClass;
	}
	
	private void createBots() {
		
		for (; blueTracker > 0; blueTracker--) {
			Character.create(id++, Team.BLUE, "[BLUE]BOT#" + blueTracker, getRandomHeroClass(), false);
		}
		
		for (; redTracker > 0; redTracker--) {
			Character.create(id++, Team.RED, "[RED]BOT#" + redTracker, getRandomHeroClass(), false);
		}
	}
	
	private void printAllCharacters() {
		for(Character character : Hero.listOfHeroes) {
			if(character.getTeam().equals(Team.BLUE) && character.isAlive()) {
				System.out.printf("%d) (%dhp) %s [%s]%n", 
						character.getId(),
						character.getHealth(),
						character.getName(),
						character.getHeroClass());
			}
		}
		
		System.out.println();
		
		for(Character character : Hero.listOfHeroes) {
			if(character.getTeam().equals(Team.RED) && character.isAlive()) {
				System.out.printf("%d) (%dhp) %s [%s]%n", 
						character.getId(),
						character.getHealth(),
						character.getName(),
						character.getHeroClass());
			}
		}
	}
	
	/*******************************************************************************************************/
	
	private Character getRandomCharacter() {
		int randomNumber = random.nextInt(Hero.listOfHeroes.size());
		return Hero.listOfHeroes.get(randomNumber);
	}

	private void attack(Character attacker, Character attacked) {
		attacked.setHealth(attacked.getHealth() - attacked.getDamage());
		
		if (attacked.getHealth() <= 0) {
			attacked.setAlive(false);
			
			if(attacked.getTeam().equals(Team.BLUE)) {
				blueTracker++;
			} else if(attacked.getTeam().equals(Team.RED)) {
				redTracker++;
			}
			
			System.out.printf("%s killed %s!%n", attacker.getName(), attacked.getName());
		} else {
			System.out.printf("%s attacked %s! (-%d)%n", 
					attacker.getName(), 
					attacked.getName(),
					attacker.getDamage());
		}
		
	}
	
	private Character selectPlayer(int id) {
		return Hero.listOfHeroes.get(id);
	}
	
	private void attackById(Character attacker) {
		
		System.out.print("\n===============List of all players===============");
		System.out.printf(" [TURN: [%d]]%n%n", turn);
		
		printAllCharacters();
		
		System.out.println("\n=============================================================\n");
		
		System.out.print("\nEnter id of player you want to attack: ");
		int input = scanner.nextInt();
		System.out.println();
		
		Character selectedPlayer = selectPlayer(--input);
		selectedPlayer.setHealth(selectedPlayer.getHealth() - attacker.getDamage());
		
		if(selectedPlayer.getHealth() <= 0) selectedPlayer.setAlive(false);
		
		if(selectedPlayer.isAlive()) {
			System.out.printf("%nYou attacked: %s [%s], he is now %dhp(-%d)%n%n",
					selectedPlayer.getName(),
					selectedPlayer.getHeroClass(),
					selectedPlayer.getHealth(),
					attacker.getDamage());
		} else if(!selectedPlayer.isAlive()){
			
			if(selectedPlayer.getTeam().equals(Team.BLUE)) blueTracker++;
			else if(selectedPlayer.getTeam().equals(Team.RED)) redTracker++;
			
			System.out.printf("%nYou killed: %s [%s]!%n%n",
					selectedPlayer.getName(),
					selectedPlayer.getHeroClass());
		}
		
	}
	
	private void attackRandom(Character attacker) {
		
		Character randomCharacter = getRandomCharacter();
		
		while(attacker.getTeam().equals(randomCharacter.getTeam()) || !randomCharacter.isAlive()) {
			randomCharacter = getRandomCharacter();
		}
		
		attack(attacker, randomCharacter);
	}
	
	private void printPlayer() {
		for(Character checking : Hero.listOfHeroes) {
			
			if(checking.isPlayer()) {
		
				System.out.printf("%nYour hero: (%dhp) %s [%s]%n", 
						checking.getHealth(),
						checking.getName(),
						checking.getHeroClass());
			}
		}
	}
	
	private boolean isEnd() {
		if(blueTracker == 5) {
			
			System.out.println("\n**************");
			for(int a = 0; a <= 3; a++)
				System.out.println("RED TEAM WINS!");
			System.out.println("**************");
			
			return true;
		} else if(redTracker == 5) {
			
			System.out.println("\n***************");
			for(int a = 0; a <= 3; a++)
				System.out.println("BLUE TEAM WINS!");
			System.out.println("***************");
			
			return true;
		} else if(blueTracker == 5 && redTracker == 5) {
			
			System.out.println("\n*****");
			for(int a = 0; a <= 3; a++)
				System.out.println("DRAW!");
			System.out.println("*****");
			
			return true;
		} else {
			return false;
		}
	}
	
	private void showTurnsAtTheEnd() {
		System.out.printf("%nThe game ended in %d turns!%n", turn);
	}
}
