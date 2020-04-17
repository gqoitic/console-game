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
	
	void gameProcess() {
		boolean process = true;
		
		// need to fill heroesInGame list here
		
		while(process) {
			for(Hero movingHero : Hero.listOfHeroes) {
				if(Hero.listOfHeroes.indexOf(movingHero) == 0) increaseTurn();
				
				// ... (checking if player or bot etc...)
			}
		}
	}
	
	void beginningOfTheGame() {
		// intro
		
		name      = choosingName();
		team      = choosingTeam();
		heroClass = choosingHeroClass();
		
		Character player = Character.create(team, name, heroClass, true);
		
		
		// creating other 9 heroes (method)
		// ...
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
		System.out.print("Choose your team:%n"
				+ "[1]Red%n"
				+ "[2]Blue%n"
				+ "[3]Random%n%n>>");
		
		choice = scanner.nextInt();
		
		if(choice == 3) {
			randomChoice = random.nextInt(10);
			
			choice = randomChoice > 5 ? 1 : 2;
		}
		
		switch(choice) {
		case 1:
			team = Team.RED;
			break;
		case 2:
			team = Team.BLUE;
			break;
		}
		
		return team;
	}
	
	private HeroClass choosingHeroClass() {
		System.out.print("Choose your hero:%n"
				+ "[1]Tank%n"
				+ "[2]Healer%n"
				+ "[3]Killer%n"
				+ "[4]Mage%n%n>>");
		
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

}
