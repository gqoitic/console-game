package com.gqoitic.console_game.characters;

public class PlayableCharacter extends Hero {

	private int health;
	private int mana;
	private int damage;
	
	private Team team;
	private HeroClass heroClass;
	
	public PlayableCharacter(Team team, String name, int health, int mana, int damage, boolean player) {
		super(name, health, mana, damage, player);
		this.setTeam(team);
	}
	
	public PlayableCharacter create(Team team, String name, HeroClass heroClass, boolean player) {
		
		if(heroClass.equals(HeroClass.TANK)) {
			health = 1000;
			mana = 200;
			damage = 100;
		}
		else if(heroClass.equals(HeroClass.HEALER)) {
			health = 500;
			mana = 400;
			damage = 50;
		}
		else if(heroClass.equals(HeroClass.KILLER)) {
			health = 600;
			mana = 200;
			damage = 200;
		}
		else if(heroClass.equals(HeroClass.MAGE)) {
			health = 400;
			mana = 600;
			damage = 100;
		}
		
		return new PlayableCharacter(team, name, health, mana, damage, player);
	}

	public HeroClass getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(HeroClass heroClass) {
		this.heroClass = heroClass;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
