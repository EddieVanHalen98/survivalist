package com.evh98.stext.world;

import java.util.Random;

import com.evh98.stext.main.Sys;

public class Battle {

	// Random object
	private static Random r = new Random();
	
	// The enemy the player is facing
	public static Mob enemy = null;
	// The health of the enemy the player is facing
	public static int enemyHealth = -1;
	// The name of the enemy the player is facing
	public static String enemyName = null;
	
	// My typing is really off right now isn't it?
	
	/**
	 * Method to attack the passive mob
	 * @param p - Player object
	 */
	public static void attackPassive(Player p){
		enemy = p.tPos.getMob();
		enemyName = p.tPos.getMob().getName();
		Sys.print("You killed one of the " + enemyName + "!");
		Mob.returnDrops(p, enemy);
	}
	
	/**
	 * Main hostile battle action selector method
	 * @param p - Player object
	 */
	public static void mainHostile(Player p, Mob m){
		enemy = m;
		enemyHealth = m.getHealth();
		enemyName = m.getName();
		
		if(enemyHealth<=0){
			Sys.print("You killed the " + enemyName + "!");
			Mob.returnDrops(p, enemy);
		}else{
			int x = r.nextInt(100) + 1;
			
			if(x>=1 && x<=5){
				runHostile(p);
			}else if(x>=6 && x<=40){
				beAttackedHostile(p);
			}else if(x>=41 && x<=100){
				attackHostile(p);
			}
		}
	}
	
	/**
	 * Method to run from the hostile mob
	 * @param p - Player object
	 */
	public static void runHostile(Player p){
		Sys.print("You managed to escape the wrath of the " + enemyName);
	}
	
	/**
	 * Method to be attacked by the hostile mob
	 * @param p - Player object
	 */
	public static void beAttackedHostile(Player p){
		if(enemy==Mob.creeper){
			int x = r.nextInt(4) + 1;
			if(x==1){
				Sys.print("The creeper blew up!");
				p.decreaseHealth(enemy.getDamage());
				Sys.print("You have " + p.health + " health points remaining!");
			}
		}else{
			Sys.print("The " + enemyName + " attacked you!");
			p.decreaseHealth(enemy.getDamage());
			Sys.print("You have " + p.health + " health points remaining!");
		}
		
		if(p.health==0){
			p.death();
		}else{
			mainHostile(p,enemy);
		}
	}
	
	/**
	 * Method to attack the hostile mob
	 * @param p - Player object
	 */
	public static void attackHostile(Player p){
		Sys.print("You attacked the " + enemyName + "!");
		if(p.hasSword()){
			enemyHealth -= p.sword.getStrength();
		}else{
			enemyHealth -= 2;
		}
		mainHostile(p,enemy);
	}
}