package com.gqoitic.console_game.characters;

public enum HeroClass {
	TANK("tank"),
	HEALER("healer"),
	KILLER("killer"),
	MAGE("mage");
	
	private String heroClass;
	
	HeroClass(String heroClass) {
		this.setHeroClass(heroClass);
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
	
}
