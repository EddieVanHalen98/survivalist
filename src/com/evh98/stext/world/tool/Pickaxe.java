package com.evh98.stext.world.tool;

public class Pickaxe {

	// id of pickaxe
	private final int id;
	// Name of the pickaxe
	private final String name;
	// Harvest level of the pickaxe
	private final int harvestLevel;
	// Strength of the pickaxe
	private final int strength;
	// Durability of the pickaxe
	private int durability;
	
	/**
	 * Constructor
	 * @param id - id of pickaxe
	 * @param name - Name of the pickaxe
	 * @param harvestLevel - Harvest level of the pickaxe
	 * @param strength - Strength of the pickaxe
	 * @param durability - Durability of the pickaxe
	 */
	public Pickaxe(int id, String name, int harvestLevel, int strength, int durability){
		this.id = id;
		this.name = name;
		this.harvestLevel = harvestLevel;
		this.strength = strength;
		this.setDurability(durability);
	}
	
	/*
	 * Pickaxe objects
	 */
	public static final Pickaxe none = new Pickaxe(0, "none", 0, 0, 0);
	public static final Pickaxe woodPick = new Pickaxe(1, "wooden pickaxe", 0, 1, 60);
	public static final Pickaxe stonePick = new Pickaxe(2, "stone pickaxe", 1, 2, 132);
	public static final Pickaxe ironPick = new Pickaxe(3, "iron pickaxe", 2, 3, 251);
	public static final Pickaxe goldPick = new Pickaxe(4, "golden pickaxe", 0, 5, 33);
	public static final Pickaxe diamondPick = new Pickaxe(5, "diamond pickaxe", 3, 4, 1562);
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHarvestLevel() {
		return harvestLevel;
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
	 * Returns an pickaxe based on the id passed through
	 * @param id - Pickaxe ID
	 * @return Pickaxe
	 */
	public static Pickaxe getPickaxe(int id){
		Pickaxe p;
		switch(id){
		case 0:
			p = none;
			break;
		case 1:
			p = woodPick;
			break;
		case 2:
			p = stonePick;
			break;
		case 3:
			p = ironPick;
			break;
		case 4:
			p = goldPick;
			break;
		case 5:
			p = diamondPick;
			break;
		default:
			p = null;
		}
		return p;
	}
}