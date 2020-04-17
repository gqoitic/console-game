package com.gqoitic.console_game.characters;

public class Character extends Hero {

	private static int health;
	private static int mana;
	private static int damage;
	
	private Team team;
	private HeroClass heroClass;
	
	public Character(Team team, String name, int health, int mana, int damage, boolean player) {
		super(name, health, mana, damage, player);
		this.setTeam(team);
	}
	
	public static Character create(Team team, String name, HeroClass heroClass, boolean player) {
		
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
		
		Character ch = new Character(team, name, health, mana, damage, player);
		Hero.listOfHeroes.add(ch);
		
		return ch;
	}
	
	void ability() {
		// TODO
		// checking hero class
		// ...
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
