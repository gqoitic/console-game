package com.gqoitic.console_game.characters;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
	public static List<Character> listOfHeroes = new ArrayList<>();
	
	protected String name;
	private int health;
	private int mana;
	private int damage;
	
	private int health_regen;
	private int mana_regen;
	
	private boolean alive;
	private HeroStatus heroStatus;
	
	// true = player, false = bot
	private boolean player;
	
	public Hero(String name, int health, int mana, int damage, boolean player) {
		this.setName(name);
		this.setHealth(health);
		this.setMana(mana);
		this.setDamage(damage);
		this.setPlayer(player);
		
		setHealth_regen(0);
		setMana_regen(0);
		
		setAlive(true);
		setHeroStatus(HeroStatus.NORMAL);
	}
	
	
	abstract void ability();
	
	/****************************************************************
	 * 
	 * 	getters / setters
	 * 
	 ****************************************************************/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth_regen() {
		return health_regen;
	}

	public void setHealth_regen(int health_regen) {
		this.health_regen = health_regen;
	}

	public int getMana_regen() {
		return mana_regen;
	}

	public void setMana_regen(int mana_regen) {
		this.mana_regen = mana_regen;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public HeroStatus getHeroStatus() {
		return heroStatus;
	}

	public void setHeroStatus(HeroStatus heroStatus) {
		this.heroStatus = heroStatus;
	}

	public boolean isPlayer() {
		return player;
	}

	public void setPlayer(boolean player) {
		this.player = player;
	}
}
