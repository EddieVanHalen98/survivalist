package com.evh98.stext.world;

public class Item {

	// Item ID
	private final int id;
	// Name of the item
	private final String name;
	// Amount of item in stack
	private int stack;
	
	/**
	 * Constructor 
	 * @param id - Item ID
	 * @param name - Item name
	 * @param stack - Amount of item in stack
	 */
	public Item(int id, String name, int stack){
		this.id = id;
		this.name = name;
		this.setStack(stack);
	}
	
	/* 
	 * Item objects
	 */
	public static final Item coal = new Item(1, "coal", 0);
	public static final Item diamond = new Item(2, "diamonds", 0);
	public static final Item iron = new Item(3, "iron", 0);
	public static final Item gold = new Item(4, "gold", 0);
	public static final Item stick = new Item(5, "sticks", 0);
	public static final Item bowl = new Item(6, "bowls", 0);
	public static final Item string = new Item(7, "string", 0);
	public static final Item feather = new Item(8, "feathers", 0);
	public static final Item sulphur = new Item(9, "sulphur", 0);
	public static final Item clay = new Item(10, "clay", 0);
	public static final Item cane = new Item(11, "sugar canes", 0);
	public static final Item seed = new Item(12, "seeds", 0);
	public static final Item paper = new Item(13, "paper", 0);
	public static final Item book = new Item(14, "books", 0);
	public static final Item compass = new Item(15, "compasses", 0);
	public static final Item bed = new Item(16, "beds", 0);
	public static final Item wool = new Item(17, "wool", 0);
	public static final Item bone = new Item(18, "bones", 0);
	public static final Item map = new Item(19, "maps", 0);
	public static final Item disc = new Item(20, "music discs", 0);
	public static final Item leather = new Item(21, "leather", 0);
	public static final Item torch = new Item(22, "torches", 0);
	public static final Item cocoa = new Item(23, "cocoa beans", 0);
	public static final Item emerald = new Item(24, "emerald", 0);

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