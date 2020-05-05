package com.gqoitic.console_game.characters;

public enum HeroClass {
	TANK("tank", 1000, 200, 100),
	HEALER("healer", 500, 400, 50),
	KILLER("killer", 600, 200, 200),
	MAGE("mage", 400, 600, 100),
	ADMIN("admin", 10000, 10000, 10000);
	
	private String heroClass;
	
	private int health;
	private int mana;
	private int damage;
	
	HeroClass(String heroClass, int health, int mana, int damage) {
		this.setHeroClass(heroClass);
		this.setHealth(health);
		this.setMana(mana);
		this.setDamage(damage);
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
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
	
}
