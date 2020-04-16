package com.gqoitic.console_game.game;

import java.util.ArrayList;
import java.util.List;

import com.gqoitic.console_game.characters.Hero;

public class Game {
	private static int turn = 0;
	
	static void increaseTurn() { turn++; }
	
	List<Hero> heroesInGame = new ArrayList<>();
	
	void gameProcess() {
		boolean process = true;
		
		// need to fill heroesInGame list here
		
		while(process) {
			for(Hero movingHero : heroesInGame) {
				if(heroesInGame.indexOf(movingHero) == 0) increaseTurn();
				
				// ... (checking if player or bot etc...)
			}
		}
	}
	
	void beginningOfTheGame() {
		// intro
		
		// class selection
		// team selection / or random
		// creating other 9 heroes
		// ...
	}

}
