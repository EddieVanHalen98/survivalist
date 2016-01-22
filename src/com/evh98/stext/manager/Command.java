package com.evh98.stext.manager;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.evh98.stext.main.Data;
import com.evh98.stext.main.SurvivalistText;
import com.evh98.stext.main.Sys;
import com.evh98.stext.main.Window;
import com.evh98.stext.world.Battle;
import com.evh98.stext.world.Food;
import com.evh98.stext.world.Player;
import com.evh98.stext.world.World;

public class Command {

	/**
	 * Returns whether or not the specified command was entered
	 * @param input - User's input
	 * @param command - Command to check
	 * @param aliases - Aliases for the command to check
	 * @return boolean
	 */
	public static boolean isEntered(String input, String command, String alias, String alias2){
		String[] parts = null;
		if(input.contains(" ")){
			parts = input.split(" ", 2);
			SurvivalistText.cp = parts[1];
			input = parts[0];
		}else{
			parts = input.split(" ");
			parts[0] = input;
		}
		if(parts[0].equalsIgnoreCase(command)||parts[0].equalsIgnoreCase(alias)||
				parts[0].equalsIgnoreCase(alias2)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Runs the play command
	 * @param w - The World object
	 * @param - The Player object
	 * @param worldName - Name of the world
	 */
	public static void play(World w, Player p, String worldName){
		if(worldName!=null){
			w.name = worldName;
			w.generate();
			p.updatePosition(w);
			Data.createWorldFolder(w);
			Sys.print("World '" + w.name + "' has been successfully generated!");
			Command.surroundings(w, p);
			Window.input.removeActionListener(Window.pa);
			Window.input.addActionListener(Window.a);
		}else{
			Sys.print("You must specify a world name!");
			SurvivalistText.init();
		}
	}
	
	/**
	 * Moves the player in specified direction
	 * @param p - Player object
	 * @param direction - Direction parameter
	 */
	public static void move(World w, Player p, String direction){
		switch(direction){
		case "north":
			p.moveNorth(w);
			break;
		case "south":
			p.moveSouth(w);
			break;
		case "east":
			p.moveEast(w);
			break;
		case "west":
			p.moveWest(w);
			break;
		default:
			Sys.print("Please specifiy a valid direction to move in!");
		}
	}
	
	/**
	 * The player collects the specified block
	 * @param p - Player object
	 * @param toCollect - Block to collect parameter
	 */
	public static void collect(Player p, String toCollect){
		switch(toCollect){
		case "dirt":
			Collect.collectDirt(p);
			break;
		case "stone":
			Collect.collectStone(p);
			break;
		case "wood":
			Collect.collectWood(p);
			break;
		case "sand":
			Collect.collectSand(p);
			break;
		case "clay":
			Collect.collectClay(p);
			break;
		case "canes":
			Collect.collectSugarCanes(p);
			break;
		case "sugar canes":
			Collect.collectSugarCanes(p);
			break;
		case "cocoa":
			Collect.collectCocoaBeans(p);
			break;
		case "cocoa beans":
			Collect.collectCocoaBeans(p);
		default:
			Sys.print("Error! You can't collect that block/item!");
		}
	}
	
	public static void eat(Player p, String toEat){
		switch(toEat){
		case "apple":
			p.eat(Food.apple);
			break;
		case "bread":
			p.eat(Food.bread);
			break;
		case "cake":
			p.eat(Food.cake);
			break;
		case "carrot":
			p.eat(Food.carrot);
			break;
		case "potato":
			p.eat(Food.potato);
			break;
		case "baked potato":
			p.eat(Food.potatoBaked);
			break;
		case "raw chicken":
			p.eat(Food.chickenRaw);
			break;
		case "chicken":
			p.eat(Food.chickenCooked);
			break;
		case "cooked chicken":
			p.eat(Food.chickenCooked);
			break;
		case "raw pork":
			p.eat(Food.porkRaw);
			break;
		case "cooked pork":
			p.eat(Food.porkCooked);
			break;
		case "stew":
			p.eat(Food.stew);
			break;
		case "mushroom stew":
			p.eat(Food.stew);
			break;
		case "raw beef":
			p.eat(Food.beefRaw);
			break;
		case "cooked beef":
			p.eat(Food.beefCooked);
			break;
		case "steak":
			p.eat(Food.beefCooked);
			break;
		case "fish":
			p.eat(Food.fishCooked);
			break;
		case "cooked fish":
			p.eat(Food.fishCooked);
			break;
		case "flesh":
			p.eat(Food.flesh);
			break;
		case "rotten flesh":
			p.eat(Food.flesh);
			break;
		default:
			Sys.print("You can't eat that!");
		}
	}
	
	/**
	 * Attacks the closest mob in the area
	 * @param p - Player object
	 */
	public static void attack(Player p){
		Battle.attackPassive(p);
	}
	
	public static void surroundings(World w, Player p){
		p.updatePosition(w);
		Sys.print("There is " + p.tPos.getBiome().getFeatures() + " around");
		if(!(p.tPos.getMob()==null)){
			Sys.print("There are also " + p.tPos.getMob().getName() + " here");
		}
	}
	
	/**
	 * Crafts the specified block/item
	 * @param p - Player object
	 * @param toCraft - Specified block/item
	 */
	public static void craft(Player p, String toCraft){
		switch(toCraft){
		case "wooden planks":
			Craft.craftPlanks(p);
			break;
		case "planks":
			Craft.craftPlanks(p);
			break;
		case "sticks":
			Craft.craftSticks(p);
			break;
		case "crafting table":
			Craft.craftTable(p);
			break;
		case "table":
			Craft.craftTable(p);
			break;
		case "furnace":
			Craft.craftFurnace(p);
			break;
		case "torches":
			Craft.craftTorch(p);
			break;
		case "torch":
			Craft.craftTorch(p);
			break;
		case "wool":
			Craft.craftWool(p);
			break;
		case "tnt":
			Craft.craftTnt(p);
			break;
		case "bookshelf":
			Craft.craftShelf(p);
			break;
		case "wooden axe":
			Craft.craftWoodenAxe(p);
			break;
		case "wooden hoe":
			Craft.craftWoodenHoe(p);
			break;
		case "wooden pick":
			Craft.craftWoodenPick(p);
			break;
		case "wooden pickaxe":
			Craft.craftWoodenPick(p);
			break;
		case "wooden spade":
			Craft.craftWoodenShovel(p);
			break;
		case "wooden shovel":
			Craft.craftWoodenShovel(p);
			break;
		case "wooden sword":
			Craft.craftWoodenSword(p);
			break;
		case "stone axe":
			Craft.craftStoneAxe(p);
			break;
		case "stone hoe":
			Craft.craftStoneHoe(p);
			break;
		case "stone pick":
			Craft.craftStonePick(p);
			break;
		case "stone pickaxe":
			Craft.craftStonePick(p);
			break;
		case "stone spade":
			Craft.craftStoneShovel(p);
			break;
		case "stone shovel":
			Craft.craftStoneShovel(p);
			break;
		case "stone sword":
			Craft.craftStoneSword(p);
			break;
		case "iron axe":
			Craft.craftIronAxe(p);
			break;
		case "iron hoe":
			Craft.craftIronHoe(p);
			break;
		case "iron pick":
			Craft.craftIronPick(p);
			break;
		case "iron pickaxe":
			Craft.craftIronPick(p);
			break;
		case "iron spade":
			Craft.craftIronShovel(p);
			break;
		case "iron shovel":
			Craft.craftIronShovel(p);
			break;
		case "iron sword":
			Craft.craftIronSword(p);
			break;
		case "gold axe":
			Craft.craftGoldAxe(p);
			break;
		case "gold hoe":
			Craft.craftGoldHoe(p);
			break;
		case "gold pick":
			Craft.craftGoldPick(p);
			break;
		case "gold pickaxe":
			Craft.craftGoldPick(p);
			break;
		case "gold spade":
			Craft.craftGoldShovel(p);
			break;
		case "gold shovel":
			Craft.craftGoldShovel(p);
			break;
		case "gold sword":
			Craft.craftGoldSword(p);
			break;
		case "diamond axe":
			Craft.craftDiamondAxe(p);
			break;
		case "diamond hoe":
			Craft.craftDiamondHoe(p);
			break;
		case "diamond pick":
			Craft.craftDiamondPick(p);
			break;
		case "diamond pickaxe":
			Craft.craftDiamondPick(p);
			break;
		case "diamond spade":
			Craft.craftDiamondShovel(p);
			break;
		case "diamond shovel":
			Craft.craftDiamondShovel(p);
			break;
		case "diamond sword":
			Craft.craftDiamondSword(p);
			break;
		case "paper":
			Craft.craftPaper(p);
			break;
		case "book":
			Craft.craftBook(p);
			break;
		case "bed":
			Craft.craftBed(p);
			break;
		default:
			Sys.print("You cannot craft that block/item!");
		}
	}
	
	/**
	 * Smelts the specified block/item
	 * @param p - Player object
	 * @param toCraft - Specified block/item
	 */
	public static void smelt(Player p, String toSmelt){
		switch(toSmelt){
		case "raw pork":
			Smelt.smeltPork(p);
			break;
		case "pork":
			Smelt.smeltPork(p);
			break;
		case "raw beef":
			Smelt.smeltBeef(p);
			break;
		case "beef":
			Smelt.smeltBeef(p);
			break;
		case "raw chicken":
			Smelt.smeltChicken(p);
			break;
		case "chicken":
			Smelt.smeltChicken(p);
			break;
		case "raw fish":
			Smelt.smeltFish(p);
			break;
		case "fish":
			Smelt.smeltFish(p);
			break;
		case "potato":
			Smelt.smeltPotato(p);
			break;
		case "iron ore":
			Smelt.smeltIronOre(p);
			break;
		case "iron":
			Smelt.smeltIronOre(p);
			break;
		case "gold ore":
			Smelt.smeltGoldOre(p);
			break;
		case "gold":
			Smelt.smeltGoldOre(p);
			break;
		case "sand":
			Smelt.smeltSand(p);
			break;
		case "clay":
			Smelt.smeltClay(p);
			break;
		case "wood":
			Smelt.smeltWood(p);
			break;
		default:
			Sys.print("You can't smelt that block/item!");
		}
	}
	
	/**
	 * Makes the player sleep
	 */
	public static void sleep(World w, Player p){
		p.sleep(w);
	}
	
	public static void save(World w, Player p){
		Sys.print("Saving world...");
		try {
			Data.saveData(w, p);
			Data.saveWorld(w);
			Data.saveInv(w);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			Sys.print("Successfully saved!");
		}
	}
	
	public static void load(String world, World w, Player p){
		Sys.print("Loading world...");
		try {
			Data.loadData(world, w, p);
			Data.loadWorld(world, w);
			Data.loadInv(world);
		} catch (ClassNotFoundException | IOException
				| ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} finally{
			Sys.print("Successfully loaded!");
			Window.input.removeActionListener(Window.pa);
			Window.input.addActionListener(Window.a);
		}
	}
	
	/**
	 * Default method returned for an invalid command
	 */
	public static void invalid(){
		Sys.print("Invalid command!");
	}
}