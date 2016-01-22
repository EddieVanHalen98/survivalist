package com.evh98.stext.manager;

import com.evh98.stext.main.Sys;
import com.evh98.stext.world.Block;
import com.evh98.stext.world.Item;
import com.evh98.stext.world.Player;
import com.evh98.stext.world.tool.Axe;
import com.evh98.stext.world.tool.Hoe;
import com.evh98.stext.world.tool.Pickaxe;
import com.evh98.stext.world.tool.Shovel;
import com.evh98.stext.world.tool.Sword;

public class Craft {
	
	/**
	 * The player attempts to craft planks
	 * @param p - Player object
	 */
	public static void craftPlanks(Player p){
		if(p.hasBlock(Block.wood, 1)){
			p.removeBlock(Block.wood, 1);
			p.addBlock(Block.plank, 4);
		}else{
			cannotCraft(Block.wood.getName());
		}
	}
	
	/**
	 * The player attempts to craft sticks
	 * @param p - Player object
	 */
	public static void craftSticks(Player p){
		if(p.hasBlock(Block.plank, 2)){
			p.removeBlock(Block.plank, 2);
			p.addItem(Item.stick, 4);
		}else{
			cannotCraft(Block.plank.getName());
		}
	}
	
	/**
	 * The player attempts to craft a crafting table
	 * @param p - Player object
	 */
	public static void craftTable(Player p){
		if(p.hasBlock(Block.plank, 4)){
			p.removeBlock(Block.plank, 4);
			p.addBlock(Block.craft, 1);
		}else{
			cannotCraft(Block.plank.getName());
		}
	}
	
	/**
	 * The player attempts to craft a furnace
	 * @param p - Player object
	 */
	public static void craftFurnace(Player p){
		if(p.hasBlock(Block.stone, 8)){
			p.removeBlock(Block.stone, 8);
			p.addBlock(Block.furnace, 1);
		}else{
			cannotCraft(Block.stone.getName());
		}
	}
	
	/**
	 * The player attempts to craft torches
	 * @param p - Player object
	 */
	public static void craftTorch(Player p){
		if(p.hasItem(Item.coal, 1) && p.hasItem(Item.stick, 1)){
			p.removeItem(Item.coal, 1);
			p.removeItem(Item.stick, 1);
			p.addItem(Item.torch, 4);
		}else{
			cannotCraft(Item.stick.getName(),Item.coal.getName());
		}
	}
	
	/**
	 * The player attempts to craft wool
	 * @param p - Player object
	 */
	public static void craftWool(Player p){
		if(p.hasItem(Item.string, 4)){
			p.removeItem(Item.string, 4);
			p.addItem(Item.wool, 1);
		}else{
			cannotCraft(Item.string.getName());
		}
	}
	
	/**
	 * The player attempts to craft tnt
	 * @param p - Player object
	 */
	public static void craftTnt(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.sulphur, 5) && p.hasBlock(Block.sand, 4)){
				p.removeItem(Item.sulphur, 5);
				p.removeBlock(Block.sand, 4);
				p.addBlock(Block.tnt, 1);
			}else{
				cannotCraft(Item.sulphur.getName(), Block.sand.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a bookshelf
	 * @param p - Player object
	 */
	public static void craftShelf(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.book, 3) && p.hasBlock(Block.plank, 6)){
				p.removeItem(Item.book, 3);
				p.removeBlock(Block.plank, 6);
				p.addBlock(Block.shelf, 1);
			}else{
				cannotCraft(Item.book.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a wooden axe
	 * @param p - Player object
	 */
	public static void craftWoodenAxe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.plank, 3)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.plank, 3);
				p.addAxe(Axe.woodAxe);
			}else{
				cannotCraft(Item.stick.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a wooden hoe
	 * @param p - Player object
	 */
	public static void craftWoodenHoe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.plank, 2)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.plank, 2);
				p.addHoe(Hoe.woodHoe);
			}else{
				cannotCraft(Item.stick.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a wooden pickaxe
	 * @param p - Player object
	 */
	public static void craftWoodenPick(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.plank, 3)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.plank, 3);
				p.addPick(Pickaxe.woodPick);
			}else{
				cannotCraft(Item.stick.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a wooden shovel
	 * @param p - Player object
	 */
	public static void craftWoodenShovel(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.plank, 1)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.plank, 1);
				p.addShovel(Shovel.woodSpade);
			}else{
				cannotCraft(Item.stick.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a wooden sword
	 * @param p - Player object
	 */
	public static void craftWoodenSword(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 1) && p.hasBlock(Block.plank, 2)){
				p.removeItem(Item.stick, 1);
				p.removeBlock(Block.plank, 2);
				p.addSword(Sword.woodSword);
			}else{
				cannotCraft(Item.stick.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a stone axe
	 * @param p - Player object
	 */
	public static void craftStoneAxe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.stone, 3)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.stone, 3);
				p.addAxe(Axe.stoneAxe);
			}else{
				cannotCraft(Item.stick.getName(), Block.stone.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a stone hoe
	 * @param p - Player object
	 */
	public static void craftStoneHoe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.stone, 2)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.stone, 2);
				p.addHoe(Hoe.stoneHoe);
			}else{
				cannotCraft(Item.stick.getName(), Block.stone.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a stone pickaxe
	 * @param p - Player object
	 */
	public static void craftStonePick(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.stone, 3)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.stone, 3);
				p.addPick(Pickaxe.stonePick);
			}else{
				cannotCraft(Item.stick.getName(), Block.stone.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a stone shovel
	 * @param p - Player object
	 */
	public static void craftStoneShovel(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasBlock(Block.stone, 1)){
				p.removeItem(Item.stick, 2);
				p.removeBlock(Block.stone, 1);
				p.addShovel(Shovel.stoneSpade);
			}else{
				cannotCraft(Item.stick.getName(), Block.stone.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a stone sword
	 * @param p - Player object
	 */
	public static void craftStoneSword(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 1) && p.hasBlock(Block.stone, 2)){
				p.removeItem(Item.stick, 1);
				p.removeBlock(Block.stone, 2);
				p.addSword(Sword.stoneSword);
			}else{
				cannotCraft(Item.stick.getName(), Block.stone.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a iron axe
	 * @param p - Player object
	 */
	public static void craftIronAxe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.iron, 3)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.iron, 3);
				p.addAxe(Axe.stoneAxe);
			}else{
				cannotCraft(Item.stick.getName(), Item.iron.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a iron hoe
	 * @param p - Player object
	 */
	public static void craftIronHoe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.iron, 2)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.iron, 2);
				p.addHoe(Hoe.stoneHoe);
			}else{
				cannotCraft(Item.stick.getName(), Item.iron.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a iron pickaxe
	 * @param p - Player object
	 */
	public static void craftIronPick(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.iron, 3)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.iron, 3);
				p.addPick(Pickaxe.stonePick);
			}else{
				cannotCraft(Item.stick.getName(), Item.iron.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a iron shovel
	 * @param p - Player object
	 */
	public static void craftIronShovel(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.iron, 1)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.iron, 1);
				p.addShovel(Shovel.stoneSpade);
			}else{
				cannotCraft(Item.stick.getName(), Item.iron.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a iron sword
	 * @param p - Player object
	 */
	public static void craftIronSword(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 1) && p.hasItem(Item.iron, 2)){
				p.removeItem(Item.stick, 1);
				p.removeItem(Item.iron, 2);
				p.addSword(Sword.stoneSword);
			}else{
				cannotCraft(Item.stick.getName(), Item.iron.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a gold axe
	 * @param p - Player object
	 */
	public static void craftGoldAxe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.gold, 3)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.gold, 3);
				p.addAxe(Axe.stoneAxe);
			}else{
				cannotCraft(Item.stick.getName(), Item.gold.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a gold hoe
	 * @param p - Player object
	 */
	public static void craftGoldHoe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.gold, 2)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.gold, 2);
				p.addHoe(Hoe.stoneHoe);
			}else{
				cannotCraft(Item.stick.getName(), Item.gold.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a gold pickaxe
	 * @param p - Player object
	 */
	public static void craftGoldPick(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.gold, 3)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.gold, 3);
				p.addPick(Pickaxe.stonePick);
			}else{
				cannotCraft(Item.stick.getName(), Item.gold.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a gold shovel
	 * @param p - Player object
	 */
	public static void craftGoldShovel(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.gold, 1)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.gold, 1);
				p.addShovel(Shovel.stoneSpade);
			}else{
				cannotCraft(Item.stick.getName(), Item.gold.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a gold sword
	 * @param p - Player object
	 */
	public static void craftGoldSword(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 1) && p.hasItem(Item.gold, 2)){
				p.removeItem(Item.stick, 1);
				p.removeItem(Item.gold, 2);
				p.addSword(Sword.stoneSword);
			}else{
				cannotCraft(Item.stick.getName(), Item.gold.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a diamond axe
	 * @param p - Player object
	 */
	public static void craftDiamondAxe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.diamond, 3)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.diamond, 3);
				p.addAxe(Axe.stoneAxe);
			}else{
				cannotCraft(Item.stick.getName(), Item.diamond.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a diamond hoe
	 * @param p - Player object
	 */
	public static void craftDiamondHoe(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.diamond, 2)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.diamond, 2);
				p.addHoe(Hoe.stoneHoe);
			}else{
				cannotCraft(Item.stick.getName(), Item.diamond.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a diamond pickaxe
	 * @param p - Player object
	 */
	public static void craftDiamondPick(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.diamond, 3)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.diamond, 3);
				p.addPick(Pickaxe.stonePick);
			}else{
				cannotCraft(Item.stick.getName(), Item.diamond.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a diamond shovel
	 * @param p - Player object
	 */
	public static void craftDiamondShovel(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 2) && p.hasItem(Item.diamond, 1)){
				p.removeItem(Item.stick, 2);
				p.removeItem(Item.diamond, 1);
				p.addShovel(Shovel.stoneSpade);
			}else{
				cannotCraft(Item.stick.getName(), Item.diamond.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a diamond sword
	 * @param p - Player object
	 */
	public static void craftDiamondSword(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.stick, 1) && p.hasItem(Item.diamond, 2)){
				p.removeItem(Item.stick, 1);
				p.removeItem(Item.diamond, 2);
				p.addSword(Sword.stoneSword);
			}else{
				cannotCraft(Item.stick.getName(), Item.diamond.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft paper
	 * @param p - Player object
	 */
	public static void craftPaper(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.cane, 3)){
				p.removeItem(Item.stick, 3);
				p.addItem(Item.paper, 3);
			}else{
				cannotCraft(Item.cane.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft books
	 * @param p - Player object
	 */
	public static void craftBook(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.paper, 3)){
				p.removeItem(Item.paper, 3);
				p.addItem(Item.book, 1);
			}else{
				cannotCraft(Item.paper.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * The player attempts to craft a bed
	 * @param p - Player object
	 */
	public static void craftBed(Player p){
		if(p.hasBlock(Block.craft, 1)){
			if(p.hasItem(Item.wool, 3) && p.hasBlock(Block.plank, 3)){
				p.removeItem(Item.wool, 3);
				p.removeBlock(Block.plank, 3);
				p.addItem(Item.bed, 1);
			}else{
				cannotCraft(Item.wool.getName(), Block.plank.getName());
			}
		}else{
			cannotCraft();
		}
	}
	
	/**
	 * Default method to notify the user that they cannot craft the specified block/item
	 */
	public static void cannotCraft(){
		Sys.print("You need a crafting table to be able to craft this!");
	}
	
	/**
	 * Second method to notify the user that they cannot craft the specified block/item
	 */
	public static void cannotCraft(String block){
		Sys.print("You do not have enough " + block + " to craft this!");
	}
	
	/**
	 * Third method to notify the user that they cannot craft the specified block/item
	 */
	public static void cannotCraft(String block, String block2){
		Sys.print("You do not have enough " + block + " or " + block2 + " to craft this!");
	}
	
	/**
	 * Fourth method to notify the user that they cannot craft the specified block/item
	 */
	public static void cannotCraft(String block, String block2, String block3){
		Sys.print("You do not have enough " + block + " or " + block2 + " or " + block3 + " to craft this!");
	}
	
	/**
	 * Fifth method to notify the user that they cannot craft the specified block/item
	 */
	public static void cannotCraft(String block, String block2, String block3, String block4){
		Sys.print("You do not have enough " + block + " or " + block2 + " or " + block3 + " or " + block4 + " to craft this!");
	}
}