package com.evh98.stext.world.tool;

public class Sword {

	// id of sword
	private final int id;
	// Name of the sword
	private final String name;
	// Strength of the sword
	private final int strength;
	// Durability of the sword
	private int durability;
	
	/**
	 * Constructor
	 * @param id - id of sword
	 * @param name - Name of the sword
	 * @param strength - Strength of the sword
	 * @param durability - Durability of the sword
	 */
	public Sword(int id, String name, int strength, int durability){
		this.id = id;
		this.name = name;
		this.strength = strength;
		this.setDurability(durability);
	}
	
	/*
	 * Sword objects
	 */
	public static final Sword none = new Sword(0, "none", 0, 0);
	public static final Sword woodSword = new Sword(1, "wooden sword", 4, 60);
	public static final Sword stoneSword = new Sword(2, "stone sword", 6, 132);
	public static final Sword ironSword = new Sword(3, "iron sword", 8, 251);
	public static final Sword goldSword = new Sword(4, "golden sword", 5, 33);
	public static final Sword diamondSword = new Sword(5, "diamond sword", 12, 1562);
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getStrength() {
		return strength;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	/**
	 * Returns an sword based on the id passed through
	 * @param id - Sword ID
	 * @return Sword
	 */
	public static Sword getSword(int id){
		Sword s;
		switch(id){
		case 1:
			s = woodSword;
			break;
		case 2:
			s = stoneSword;
			break;
		case 3:
			s = ironSword;
			break;
		case 4:
			s = goldSword;
			break;
		case 5:
			s = diamondSword;
			break;
		default:
			s = null;
		}
		return s;
	}
}