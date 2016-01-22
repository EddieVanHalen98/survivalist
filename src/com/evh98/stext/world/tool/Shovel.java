package com.evh98.stext.world.tool;

public class Shovel {

	// id of shovel
	private final int id;
	// Name of the shovel
	private final String name;
	// Strength of the shovel
	private final int strength;
	// Durability of the shovel
	private int durability;
	
	/**
	 * Constructor
	 * @param id - id of shovel
	 * @param name - Name of the shovel
	 * @param strength - Strength of the shovel
	 * @param durability - Durability of the shovel
	 */
	public Shovel(int id, String name, int strength, int durability){
		this.id = id;
		this.name = name;
		this.strength = strength;
		this.setDurability(durability);
	}
	
	/*
	 * Shovel objects
	 */
	public static final Shovel none = new Shovel(0, "none", 1, 0);
	public static final Shovel woodSpade = new Shovel(1, "wooden shovel", 2, 60);
	public static final Shovel stoneSpade = new Shovel(2, "stone shovel", 3, 132);
	public static final Shovel ironSpade = new Shovel(3, "iron shovel", 4, 251);
	public static final Shovel goldSpade = new Shovel(4, "golden shovel", 6, 33);
	public static final Shovel diamondSpade = new Shovel(5, "diamond shovel", 5, 1562);
	
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
	 * Returns an shovel based on the id passed through
	 * @param id - Shovel ID
	 * @return Shovel
	 */
	public static Shovel getShovel(int id){
		Shovel s;
		switch(id){
		case 0:
			s = none;
			break;
		case 1:
			s = woodSpade;
			break;
		case 2:
			s = stoneSpade;
			break;
		case 3:
			s = ironSpade;
			break;
		case 4:
			s = goldSpade;
			break;
		case 5:
			s = diamondSpade;
			break;
		default:
			s = null;
		}
		return s;
	}
}