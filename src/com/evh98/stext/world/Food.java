package com.evh98.stext.world;

public class Food {

	// Food ID
	private final int id;
	// Name of the food
	private final String name;
	// Amount of food in stack
	private int stack;
	// Health regen amount
	private final int healthRegen;
	
	/**
	 * Constructor 
	 * @param id - Food ID
	 * @param name - Food name
	 * @param stack - Amount of food in stack
	 * @param healthRegen - Health regen amount
	 */
	public Food(int id, String name, int stack, int healthRegen){
		this.id = id;
		this.name = name;
		this.setStack(stack);
		this.healthRegen = healthRegen;
	}
	
	/*
	 * Food objects
	 */
	public static final Food apple = new Food(1,"apples",0,4);
	public static final Food bread = new Food(2,"bread",0,5);
	public static final Food cake = new Food(3,"cake",0,12);
	public static final Food carrot = new Food(4,"carrots",0,4);
	public static final Food potato = new Food(5,"potatoes",0,1);
	public static final Food potatoBaked = new Food(6,"baked potatoes",0,6);
	public static final Food chickenRaw = new Food(7,"raw chickens",0,2);
	public static final Food chickenCooked = new Food(8,"chickens",0,6);
	public static final Food porkRaw = new Food(9,"raw pork",0,3);
	public static final Food porkCooked = new Food(10,"pork",0,8);
	public static final Food stew = new Food(11,"mushroom stew",0,6);
	public static final Food beefRaw = new Food(12,"raw beef",0,3);
	public static final Food beefCooked = new Food(13,"beef",0,8);
	public static final Food fishRaw = new Food(14,"raw fish",0,2);
	public static final Food fishCooked = new Food(15,"cooked fish",0,5);
	public static final Food flesh = new Food(16,"rotten flesh",0,1);
	
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

	public int getHealthRegenAmount() {
		return healthRegen;
	}
}