package com.gqoitic.console_game;

import com.gqoitic.console_game.game.Game;

public class Application {

	private static Game launcher = new Game();
	
	public static void main(String[] args) {
		launcher.gameProcess();
	}

}
