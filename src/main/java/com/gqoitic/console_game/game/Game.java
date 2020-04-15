package com.gqoitic.console_game.game;

import java.util.ArrayList;
import java.util.List;

import com.gqoitic.console_game.characters.Hero;

public class Game {
	private static int turn = 0; // change to 1 ?
	
	static void increaseTurn() { turn++; }
	
	List<Hero> heroesInGame = new ArrayList<>();
	
	void gameProcess() {
		boolean process = true;
		
		while(process) {
			for(Hero movingHero : heroesInGame) {
				if(heroesInGame.indexOf(movingHero) == 0) increaseTurn();
				
				// ... (checking if player or bot etc...)
			}
		}
	}

}
