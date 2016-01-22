package com.evh98.stext.manager;

import com.evh98.stext.main.Sys;
import com.evh98.stext.world.Block;
import com.evh98.stext.world.Food;
import com.evh98.stext.world.Item;
import com.evh98.stext.world.Player;

public class Smelt {

	/**
	 * The player attempts to smelt raw pork
	 * @param p - Player object
	 */
	public static void smeltPork(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasFood(Food.porkRaw, 1)){
					p.removeFood(Food.porkRaw, 1);
					p.addFood(Food.porkCooked, checkFuel(p));
				}else{
					cannotSmelt(Food.porkRaw.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt raw beef
	 * @param p - Player object
	 */
	public static void smeltBeef(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasFood(Food.beefRaw, 1)){
					p.removeFood(Food.beefRaw, 1);
					p.addFood(Food.beefCooked, checkFuel(p));
				}else{
					cannotSmelt(Food.beefRaw.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt raw chicken
	 * @param p - Player object
	 */
	public static void smeltChicken(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasFood(Food.chickenRaw, 1)){
					p.removeFood(Food.chickenRaw, 1);
					p.addFood(Food.chickenCooked, checkFuel(p));
				}else{
					cannotSmelt(Food.chickenRaw.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt raw fish
	 * @param p - Player object
	 */
	public static void smeltFish(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasFood(Food.fishRaw, 1)){
					p.removeFood(Food.fishRaw, 1);
					p.addFood(Food.fishCooked, checkFuel(p));
				}else{
					cannotSmelt(Food.fishRaw.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt a potato
	 * @param p - Player object
	 */
	public static void smeltPotato(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasFood(Food.potato, 1)){
					p.removeFood(Food.potato, 1);
					p.addFood(Food.potatoBaked, checkFuel(p));
				}else{
					cannotSmelt(Food.potato.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt iron ore
	 * @param p - Player object
	 */
	public static void smeltIronOre(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasBlock(Block.ironOre, 1)){
					p.removeBlock(Block.ironOre, 1);
					p.addItem(Item.iron, checkFuel(p));
				}else{
					cannotSmelt(Block.ironOre.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt gold ore
	 * @param p - Player object
	 */
	public static void smeltGoldOre(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasBlock(Block.goldOre, 1)){
					p.removeBlock(Block.goldOre, 1);
					p.addItem(Item.gold, checkFuel(p));
				}else{
					cannotSmelt(Block.goldOre.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt sand
	 * @param p - Player object
	 */
	public static void smeltSand(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasBlock(Block.sand, 1)){
					p.removeBlock(Block.sand, 1);
					p.addBlock(Block.glass, checkFuel(p));
				}else{
					cannotSmelt(Block.sand.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt clay
	 * @param p - Player object
	 */
	public static void smeltClay(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasItem(Item.clay, 4)){
					p.removeItem(Item.clay, 4);
					p.addBlock(Block.brick, checkFuel(p));
				}else{
					cannotSmelt(Item.clay.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * The player attempts to smelt clay
	 * @param p - Player object
	 */
	public static void smeltWood(Player p){
		if(checkFuel(p)!=0){
			if(p.hasBlock(Block.furnace, 1)){
				if(p.hasBlock(Block.wood, 1)){
					p.removeBlock(Block.wood, 1);
					p.addItem(Item.coal, checkFuel(p));
				}else{
					cannotSmelt(Block.wood.getName());
				}
			}else{
				cannotSmelt();
			}
		}else{
			noFuel();
		}
	}
	
	/**
	 * Checks the kind of fuel the player has
	 */
	public static int checkFuel(Player p){
		if(p.hasItem(Item.coal, 1)){
			return 2;
		}else if(p.hasBlock(Block.plank, 1)){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Checks the kind of fuel the player has
	 */
	public static void takeFuel(Player p){
		switch(checkFuel(p)){
		case 1:
			p.removeBlock(Block.plank, 1);
			break;
		case 2:
			p.removeItem(Item.coal, 1);
		}
	}
	
	/**
	 * Default method to be ran when the player cannot smelt a specific block/item
	 */
	public static void cannotSmelt(){
		Sys.print("You need a furnace to smelt something!");
	}
	
	/**
	 * Default method to be ran when the player cannot smelt a specific block/item
	 */
	public static void cannotSmelt(String block){
		Sys.print("You don't have any " + block + " to smelt!");
	}
	
	/**
	 * Notifies the player that he does not have any fuel
	 */
	public static void noFuel(){
		Sys.print("You have no fuel!");
	}
}
