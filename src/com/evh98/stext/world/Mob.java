package com.evh98.stext.world;

import java.io.Serializable;
import java.util.Random;

public class Mob implements Serializable{

	// Random object
	private static Random rand = new Random();
	
	// Mob ID
	private final int id;
	// Name of the mob
	private final String name;
	// Whether the mob is passive or not
	private final boolean passive;
	// The health of the mob
	private final int health;
	// The damage the mob deals
	private final int damage;
	
	/**
	 * Constructor
	 * @param id - Mob ID
	 * @param name - Name of the mob
	 * @param passive - Whether the mob is passive or not
	 * @param health - The health of the mob
	 * @param damage - The damage the mob deals
	 */
	public Mob(int id, String name, boolean passive, int health, int damage){
		this.id = id;
		this.name = name;
		this.passive = passive;
		this.health = health;
		this.damage = damage;
	}

	public static final Mob chicken = new Mob(1, "chickens", true, 4, 0);
	public static final Mob cow = new Mob(2, "cows", true, 10, 0);
	public static final Mob pig = new Mob(3, "pigs", true, 10, 0);
	public static final Mob sheep = new Mob(4, "sheep", true, 8, 0);
	public static final Mob creeper = new Mob(5, "creeper", false, 20, 20);
	public static final Mob skeleton = new Mob(6, "skeleton", false, 20, 4);
	public static final Mob spider = new Mob(7, "spider", false, 16, 2);
	public static final Mob zombie = new Mob(8, "zombie", false, 20, 3);
	public static final Mob blackSteve = new Mob(9, "BLACK STEVE MUTHAFUCKA", false, 100, 20);
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isPassive() {
		return passive;
	}

	public int getHealth() {
		return health;
	}

	public int getDamage() {
		return damage;
	}
	
	public static void returnDrops(Player p, Mob m){
		if(m==chicken){
			returnChickenDrops(p);
		}else if(m==cow){
			returnCowDrops(p);
		}else if(m==pig){
			returnPigDrops(p);
		}else if(m==sheep){
			returnSheepDrops(p);
		}else if(m==creeper){
			returnCreeperDrops(p);
		}else if(m==skeleton){
			returnSkeletonDrops(p);
		}else if(m==spider){
			returnCowDrops(p);
		}else if(m==zombie){
			returnCowDrops(p);
		}else if(m==blackSteve){
			returnBlackSteveDrops(p);
		}
	}
	
	public static void returnChickenDrops(Player p){
		int a = rand.nextInt(3);
		p.addItem(Item.feather, a);
		p.addFood(Food.chickenRaw, 1);
	}
	
	public static void returnCowDrops(Player p){
		int a = rand.nextInt(3);
		int b = rand.nextInt(3) + 1;
		p.addItem(Item.leather, a);
		p.addFood(Food.beefRaw, b);
	}
	
	public static void returnPigDrops(Player p){
		int a = rand.nextInt(3) + 1;
		p.addFood(Food.porkRaw, a);
	}
	
	public static void returnSheepDrops(Player p){
		int a = rand.nextInt(3) + 1;
		p.addItem(Item.wool, a);
	}
	
	public static void returnCreeperDrops(Player p){
		int a = rand.nextInt(3);
		p.addItem(Item.sulphur, a);
		
		int x = rand.nextInt(100) + 1;
		if(x==100){
			p.addItem(Item.disc, 1);
		}
	}
	
	public static void returnSkeletonDrops(Player p){
		int a = rand.nextInt(3);
		p.addItem(Item.bone, a);
	}
	
	public static void returnSpiderDrops(Player p){
		int a = rand.nextInt(3);
		p.addItem(Item.string, a);
	}
	
	public static void returnZombieDrops(Player p){
		
	}
	
	public static void returnBlackSteveDrops(Player p){
		p.addItem(Item.diamond, 10);
	}
	
	public boolean isDead(){
		if(health<=0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Returns a mob based on the id passed through
	 * @param id - Mob ID
	 * @return Mob
	 */
	public static Mob getMob(int id){
		Mob m;
		switch(id){
		case 1:
			m = chicken;
			break;
		case 2:
			m = cow;
			break;
		case 3:
			m = pig;
			break;
		case 4:
			m = sheep;
			break;
		case 5:
			m = creeper;
			break;
		case 6:
			m = skeleton;
			break;
		case 7:
			m = spider;
			break;
		case 8:
			m = zombie;
			break;
		default:
			m = null;
		}
		return m;
	}
}