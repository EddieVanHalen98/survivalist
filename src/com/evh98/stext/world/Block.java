package com.evh98.stext.world;

public class Block {

	// Block ID
	private final int id;
	// Name of the block
	private final String name;
	// Amount of block in stack
	private int stack;
	
	/**
	 * Constructor 
	 * @param id - Block ID
	 * @param name - Block name
	 * @param stack - Amount of block in stack
	 */
	public Block(int id, String name, int stack){
		this.id = id;
		this.name = name;
		this.setStack(stack);
	}
	
	/*
	 * Block objects
	 */
	public static final Block grass = new Block(1, "grass", 0);
	public static final Block dirt = new Block(2, "dirt", 0);
	public static final Block stone = new Block(3, "stone", 0);
	public static final Block wood = new Block(4, "wood", 0);
	public static final Block plank = new Block(5, "planks", 0);
	public static final Block sand = new Block(6, "sand", 0);
	public static final Block craft = new Block(7, "crafting tables", 0);
	public static final Block furnace = new Block(8, "furances", 0);
	public static final Block tnt = new Block(9, "tnt", 0);
	public static final Block glass = new Block(10, "glass", 0);
	public static final Block obsidian = new Block(11, "obsidian", 0);
	public static final Block enchant = new Block(12, "enchanting tables", 0);
	public static final Block shelf = new Block(13, "bookshelves", 0);
	public static final Block brick = new Block(14, "bricks", 0);
	public static final Block note = new Block(15, "note blocks", 0);
	public static final Block glow = new Block(16, "glowstone", 0);
	public static final Block jukebox = new Block(17, "jukebox", 0);
	public static final Block coalOre = new Block(18, "coal ore", 0);
	public static final Block ironOre = new Block(19, "iron ore", 0);
	public static final Block goldOre = new Block(20, "gold ore", 0);
	public static final Block diamondOre = new Block(21, "diamond ore", 0);
	public static final Block emeraldOre = new Block(22, "emerald ore", 0);
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}
}