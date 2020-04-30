package com.gqoitic.console_game.characters;

public class Character extends Hero {

	private int id;

	private Team team;
	private HeroClass heroClass;
	
	public Character(
			int id, 
			Team team, 
			String name, 
			HeroClass heroClass, 
			int health, 
			int mana, 
			int damage, 
			boolean player) 
	{
		super(name, health, mana, damage, player);
		this.setTeam(team);
		this.setHeroClass(heroClass);
		this.setId(id);
	}
	
	public static Character create(
			int id, 
			Team team, 
			String name, 
			HeroClass heroClass, 
			boolean player) 
	{
		Character ch = new Character(id, team, name, heroClass, 
				heroClass.getHealth(), 
				heroClass.getMana(), 
				heroClass.getDamage(), 
				player);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
