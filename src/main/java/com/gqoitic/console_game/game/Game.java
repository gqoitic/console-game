package com.gqoitic.console_game.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import com.gqoitic.console_game.characters.Hero;
import com.gqoitic.console_game.characters.HeroClass;
import com.gqoitic.console_game.characters.Team;
import com.gqoitic.console_game.characters.Character;
import com.sun.prism.paint.Color;

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
	
	void gameProcess() {
		boolean process = true;
		
		while(process) {
			for(Hero movingHero : Hero.listOfHeroes) {
				if(Hero.listOfHeroes.indexOf(movingHero) == 0) increaseTurn();
				
				// ... (checking if player or bot etc...)
			}
		}
	}
	
	public void beginningOfTheGame() {
		// intro

		name      = choosingName();
		team      = choosingTeam();
		heroClass = choosingHeroClass();
		
		player = Character.create(id++, team, name, heroClass, true);
		
		// adds [team] to the beginning of name
		changePlayerName();

		// creating other 9 players (bots)
		createBots();
		
		printAllCharacters();
	}
	
	private void changePlayerName() {
		if(player.getTeam() == Team.RED) {
			player.setName("[RED]" + player.getName());
		} else if(player.getTeam() == Team.BLUE) {
			player.setName("[BLUE]" + player.getName());
		}
	}
	
	private String choosingName() {
		System.out.print("Enter your name: ");
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
		HeroClass heroClass;
		
		for (; blueTracker > 0; blueTracker--) {
			Character.create(id++, Team.BLUE, "[BLUE]BOT#" + blueTracker, getRandomHeroClass(), false);
		}
		
		for (; redTracker > 0; redTracker--) {
			Character.create(id++, Team.RED, "[RED]BOT#" + redTracker, getRandomHeroClass(), false);
		}
	}
	
	private void printAllCharacters() {
		for(Character character : Hero.listOfHeroes) {
			System.out.printf("%d) (%dhp) %s [%s]%n", character.getId(),
											  character.getHealth(),
											  character.getName(),
											  character.getHeroClass());
		}
	}
	
	/*******************************************************************************************************/
	
	private Character getRandomCharacter() {
		int randomNumber = random.nextInt(Hero.listOfHeroes.size());
		return Hero.listOfHeroes.get(randomNumber);
	}

	private void atack(Character attacker, Character attacked) {
		attacked.setHealth(attacked.getHealth() - attacked.getDamage());
		
		if (attacked.getHealth() <= 0) {
			attacked.setAlive(false);
		}
	}
	
}
