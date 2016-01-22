package com.evh98.stext.manager;

import com.evh98.stext.main.Sys;
import com.evh98.stext.world.Biome;
import com.evh98.stext.world.Block;
import com.evh98.stext.world.Item;
import com.evh98.stext.world.Player;

public class Collect {

	/**
	 * The player attempts to collect dirt
	 * @param p - Player object
	 */
	public static void collectDirt(Player p){
		if(!(p.getCurrentBiome()==Biome.desert) || !(p.getCurrentBiome()==Biome.ocean)){
			if(p.hasShovel()){
				p.addBlock(Block.dirt, p.shovel.getStrength());
			}else{
				p.addBlock(Block.dirt, 1);
			}
		}else{
			cannotCollect(Block.dirt.getName());
		}
	}
	
	/**
	 * The player attempts to collect stone
	 * @param p - Player object
	 */
	public static void collectStone(Player p){
		if(p.getCurrentBiome()==Biome.hills){
			if(p.hasPick()){
				p.addBlock(Block.stone, p.pickaxe.getStrength());
			}else{
				Sys.print("You need a pickaxe to collect stone!");
			}
		}else{
			cannotCollect(Block.stone.getName());
		}
	}
	
	/**
	 * The player attempts to collect wood
	 * @param p - Player object
	 */
	public static void collectWood(Player p){
		if(!(p.getCurrentBiome()==Biome.desert) || !(p.getCurrentBiome()==Biome.ocean) || 
				!(p.getCurrentBiome()==Biome.plains)){
			if(p.hasAxe()){
				p.addBlock(Block.wood, p.axe.getStrength());
			}else{
				p.addBlock(Block.wood, 1);
			}
		}else{
			cannotCollect(Block.wood.getName());
		}
	}
	
	/**
	 * The player attempts to collect sand
	 * @param p - Player object
	 */
	public static void collectSand(Player p){
		if((p.getCurrentBiome()==Biome.desert)){
			p.addBlock(Block.sand, p.shovel.getStrength());
		}else{
			cannotCollect(Block.sand.getName());
		}
	}
	
	/**
	 * The player attempts to collect clay
	 * @param p - Player object
	 */
	public static void collectClay(Player p){
		if((p.getCurrentBiome()==Biome.swamp)){
			p.addItem(Item.clay, p.shovel.getStrength());
		}else{
			cannotCollect(Item.clay.getName());
		}
	}
	
	/**
	 * The player attempts to collect sugar canes
	 * @param p - Player object
	 */
	public static void collectSugarCanes(Player p){
		if((p.getCurrentBiome()==Biome.desert)){
			p.addItem(Item.cane, 1);
		}else{
			cannotCollect(Item.cane.getName());
		}
	}
	
	/**
	 * The player attempts to collect cocoa beans
	 * @param p - Player object
	 */
	public static void collectCocoaBeans(Player p){
		if((p.getCurrentBiome()==Biome.jungle)){
			p.addItem(Item.cocoa, 1);
		}else{
			cannotCollect(Item.cocoa.getName());
		}
	}
	
	/**
	 * Default method to notify the user that they cannot collect the specified block
	 */
	public static void cannotCollect(String block){
		Sys.print("There is no " + block + " around!");
	}
}