package com.evh98.stext.world.tool;

public class Hoe {

	// id of axe
	private final int id;
	// Name of the axe
	private final String name;
	// Durability of the axe
	private int durability;
	
	/**
	 * Constructor
	 * @param id - id of hoe
	 * @param name - Name of the hoe
	 * @param durability - Durability of the hoe
	 */
	public Hoe(int id, String name, int durability){
		this.id = id;
		this.name = name;
		this.setDurability(durability);
	}
	
	/*
	 * Hoe objects
	 */
	public static final Hoe none = new Hoe(0, "none", 0);
	public static final Hoe woodHoe = new Hoe(1, "wooden hoe", 60);
	public static final Hoe stoneHoe = new Hoe(2, "stone hoe", 132);
	public static final Hoe ironHoe = new Hoe(3, "iron hoe", 251);
	public static final Hoe goldHoe = new Hoe(4, "golden hoe", 33);
	public static final Hoe diamondHoe = new Hoe(5, "diamond hoe", 1562);
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	/**
	 * Returns an hoe based on the id passed through
	 * @param id - Hoe ID
	 * @return Hoe
	 */
	public static Hoe getHoe(int id){
		Hoe h;
		switch(id){
		case 0:
			h = none;
			break;
		case 1:
			h = woodHoe;
			break;
		case 2:
			h = stoneHoe;
			break;
		case 3:
			h = ironHoe;
			break;
		case 4:
			h = goldHoe;
			break;
		case 5:
			h = diamondHoe;
			break;
		default:
			h = null;
		}
		return h;
	}
}