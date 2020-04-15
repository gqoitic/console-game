package com.gqoitic.console_game.characters;

public enum HeroStatus {
	
	NORMAL("normal"),
	SILENCED("silenced"),
	STUNNED("stunned");
	// healing
	// double damage
	
	private String status;
	
	HeroStatus(String status) {
		this.status = status;
	}
}
