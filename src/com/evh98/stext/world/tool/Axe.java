package com.evh98.stext.world.tool;

public class Axe {

	// id of axe
	private final int id;
	// Name of the axe
	private final String name;
	// Strength of the axe
	private final int strength;
	// Durability of the axe
	private int durability;
	
	/**
	 * Constructor
	 * @param id - id of axe
	 * @param name - Name of the axe
	 * @param strength - Strength of the axe
	 * @param durability - Durability of the axe
	 */
	public Axe(int id, String name, int strength, int durability){
		this.id = id;
		this.name = name;
		this.strength = strength;
		this.setDurability(durability);
	}
	
	/*
	 * Axe objects
	 */
	public static final Axe none = new Axe(0, "none", 1, 0);
	public static final Axe woodAxe = new Axe(1, "wooden axe", 2, 60);
	public static final Axe stoneAxe = new Axe(2, "stone axe", 3, 132);
	public static final Axe ironAxe = new Axe(3, "iron axe", 4, 251);
	public static final Axe goldAxe = new Axe(4, "golden axe", 6, 33);
	public static final Axe diamondAxe = new Axe(5, "diamond axe", 5, 1562);
	
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
	 * Returns an axe based on the id passed through
	 * @param id - Axe ID
	 * @return Axe
	 */
	public static Axe getAxe(int id){
		Axe a;
		switch(id){
		case 0:
			a = none;
			break;
		case 1:
			a = woodAxe;
			break;
		case 2:
			a = stoneAxe;
			break;
		case 3:
			a = ironAxe;
			break;
		case 4:
			a = goldAxe;
			break;
		case 5:
			a = diamondAxe;
			break;
		default:
			a = null;
		}
		return a;
	}
}