package com.evh98.stext.main;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.evh98.stext.world.Block;
import com.evh98.stext.world.Food;
import com.evh98.stext.world.Item;
import com.evh98.stext.world.Player;
import com.evh98.stext.world.Tile;
import com.evh98.stext.world.World;
import com.evh98.stext.world.tool.Axe;
import com.evh98.stext.world.tool.Hoe;
import com.evh98.stext.world.tool.Pickaxe;
import com.evh98.stext.world.tool.Shovel;
import com.evh98.stext.world.tool.Sword;

public class Data {
	
	public static void createWorldFolder(World w){
		File x = new File(System.getProperty("user.dir") + "/saves/" + w.name);
		x.mkdir();
	}

	/**
	 * Loads the main data to a file
	 * @param world - The name of the world to load
	 * @param w - The World object
	 * @param p - The Player object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void loadData(String world, World w, Player p) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException{
		File x = new File(System.getProperty("user.dir") + "/saves/" + world + "/data.dat");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(x);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("data");
			for(int s = 0; s < nodeLst.getLength(); s++){
				Element element = (Element) nodeLst.item(s);
				w.day = Boolean.parseBoolean(element.getElementsByTagName("world-day").item(0).getChildNodes().item(0).getNodeValue());
				w.tickCount = Integer.parseInt(element.getElementsByTagName("world-tick").item(0).getChildNodes().item(0).getNodeValue());
				
				p.maxHealth = Integer.parseInt(element.getElementsByTagName("player-maxhealth").item(0).getChildNodes().item(0).getNodeValue());
				p.health = Integer.parseInt(element.getElementsByTagName("player-health").item(0).getChildNodes().item(0).getNodeValue());
				p.xPos = Integer.parseInt(element.getElementsByTagName("player-x").item(0).getChildNodes().item(0).getNodeValue());
				p.yPos = Integer.parseInt(element.getElementsByTagName("player-y").item(0).getChildNodes().item(0).getNodeValue());
				p.xp = Integer.parseInt(element.getElementsByTagName("player-xp").item(0).getChildNodes().item(0).getNodeValue());
				p.axe = new Axe(Integer.parseInt(element.getElementsByTagName("player-axe-id").item(0).getChildNodes().item(0).getNodeValue()), 
						String.valueOf(element.getElementsByTagName("player-axe-name").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-axe-strength").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-axe-durability").item(0).getChildNodes().item(0).getNodeValue()));
				p.hoe = new Hoe(Integer.parseInt(element.getElementsByTagName("player-hoe-id").item(0).getChildNodes().item(0).getNodeValue()), 
						String.valueOf(element.getElementsByTagName("player-hoe-name").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-hoe-durability").item(0).getChildNodes().item(0).getNodeValue()));
				p.pickaxe = new Pickaxe(Integer.parseInt(element.getElementsByTagName("player-pickaxe-id").item(0).getChildNodes().item(0).getNodeValue()), 
						String.valueOf(element.getElementsByTagName("player-pickaxe-name").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-pickaxe-harvest").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-pickaxe-strength").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-pickaxe-durability").item(0).getChildNodes().item(0).getNodeValue()));
				p.shovel = new Shovel(Integer.parseInt(element.getElementsByTagName("player-shovel-id").item(0).getChildNodes().item(0).getNodeValue()), 
						String.valueOf(element.getElementsByTagName("player-shovel-name").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-shovel-strength").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-shovel-durability").item(0).getChildNodes().item(0).getNodeValue()));
				p.sword = new Sword(Integer.parseInt(element.getElementsByTagName("player-sword-id").item(0).getChildNodes().item(0).getNodeValue()), 
						String.valueOf(element.getElementsByTagName("player-sword-name").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-sword-strength").item(0).getChildNodes().item(0).getNodeValue()),
						Integer.parseInt(element.getElementsByTagName("player-sword-durability").item(0).getChildNodes().item(0).getNodeValue()));
			}
			p.updatePosition(w);
	}
	
	/**
	 * Saves the main data to a file
	 * @param w - The World object
	 * @param p - The Player object
	 * @throws IOException
	 */
	public static void saveData(World w, Player p) throws IOException{
		FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/saves/" + w.name + "/data.dat");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<data>\n");
		bw.write("\t<world-day>" + w.day + "</world-day>\n");
		bw.write("\t<world-tick>" + w.tickCount + "</world-tick>\n");
		bw.write("\n");
		bw.write("\n");
		bw.write("\t<player-maxhealth>" + p.maxHealth + "</player-maxhealth>\n");
		bw.write("\t<player-health>" + p.health + "</player-health>\n");
		bw.write("\t<player-x>" + p.xPos + "</player-x>\n");
		bw.write("\t<player-y>" + p.yPos + "</player-y>\n");
		bw.write("\t<player-xp>" + p.xp + "</player-xp>\n");
		bw.write("\t<player-xp>" + p.xp + "</player-xp>\n");
		bw.write("\n");
		bw.write("\t<player-axe-id>" + p.axe.getId() + "</player-axe-id>\n");
		bw.write("\t<player-axe-name>" + p.axe.getName() + "</player-axe-name>\n");
		bw.write("\t<player-axe-strength>" + p.axe.getStrength() + "</player-axe-strength>\n");
		bw.write("\t<player-axe-durability>" + p.axe.getDurability() + "</player-axe-durability>\n");
		bw.write("\n");
		bw.write("\t<player-hoe-id>" + p.hoe.getId() + "</player-hoe-id>\n");
		bw.write("\t<player-hoe-name>" + p.hoe.getName() + "</player-hoe-name>\n");
		bw.write("\t<player-hoe-durability>" + p.hoe.getDurability() + "</player-hoe-durability>\n");
		bw.write("\n");
		bw.write("\t<player-pickaxe-id>" + p.pickaxe.getId() + "</player-pickaxe-id>\n");
		bw.write("\t<player-pickaxe-name>" + p.pickaxe.getName() + "</player-pickaxe-name>\n");
		bw.write("\t<player-pickaxe-harvest>" + p.pickaxe.getHarvestLevel() + "</player-pickaxe-harvest>\n");
		bw.write("\t<player-pickaxe-strength>" + p.pickaxe.getStrength() + "</player-pickaxe-strength>\n");
		bw.write("\t<player-pickaxe-durability>" + p.pickaxe.getDurability() + "</player-pickaxe-durability>\n");
		bw.write("\n");
		bw.write("\t<player-shovel-id>" + p.shovel.getId() + "</player-shovel-id>\n");
		bw.write("\t<player-shovel-name>" + p.shovel.getName() + "</player-shovel-name>\n");
		bw.write("\t<player-shovel-strength>" + p.shovel.getStrength() + "</player-shovel-strength>\n");
		bw.write("\t<player-shovel-durability>" + p.shovel.getDurability() + "</player-shovel-durability>\n");
		bw.write("\n");
		bw.write("\t<player-sword-id>" + p.sword.getId() + "</player-sword-id>\n");
		bw.write("\t<player-sword-name>" + p.sword.getName() + "</player-sword-name>\n");
		bw.write("\t<player-sword-strength>" + p.sword.getStrength() + "</player-sword-strength>\n");
		bw.write("\t<player-sword-durability>" + p.sword.getDurability() + "</player-sword-durability>\n");
		bw.write("</data>");
		bw.close();
	}
	
	/**
	 * Loads the world data to a file
	 * @param world - The name of the world to load
	 * @param w - The World object
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void loadWorld(String world, World w) throws ClassNotFoundException, IOException{
		InputStream file = new FileInputStream(System.getProperty("user.dir") + "/saves/" + world + "/world.dat");
		InputStream buffer = new BufferedInputStream(file);
		ObjectInput input = new ObjectInputStream(buffer);
		try{
			w.tiles = (Tile[][]) input.readObject();
		}finally{
			input.close();
		}
	}
	
	/**
	 * Saves the world data to a file
	 * @param w - The World object
	 * @throws IOException
	 */
	public static void saveWorld(World w) throws IOException{
		OutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/saves/" + w.name + "/world.dat");
		ObjectOutputStream oos = new ObjectOutputStream(file);
		try{
			oos.writeObject(w.tiles);
		}finally{
			oos.close();
		}
	}
	
	/**
	 * Loads the inventory data to a file
	 * @param world - The name of the world to load
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void loadInv(String world) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException{
		File x = new File(System.getProperty("user.dir") + "/saves/" + world + "/inv.dat");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(x);
		doc.getDocumentElement().normalize();
		NodeList nodeLst = doc.getElementsByTagName("inv");
		for(int s = 0; s < nodeLst.getLength(); s++){
			Element element = (Element) nodeLst.item(s);
			Block.grass.setStack(Integer.parseInt(element.getElementsByTagName("block-grass").item(0).getChildNodes().item(0).getNodeValue()));
			Block.dirt.setStack(Integer.parseInt(element.getElementsByTagName("block-dirt").item(0).getChildNodes().item(0).getNodeValue()));
			Block.stone.setStack(Integer.parseInt(element.getElementsByTagName("block-stone").item(0).getChildNodes().item(0).getNodeValue()));
			Block.wood.setStack(Integer.parseInt(element.getElementsByTagName("block-wood").item(0).getChildNodes().item(0).getNodeValue()));
			Block.plank.setStack(Integer.parseInt(element.getElementsByTagName("block-plank").item(0).getChildNodes().item(0).getNodeValue()));
			Block.sand.setStack(Integer.parseInt(element.getElementsByTagName("block-sand").item(0).getChildNodes().item(0).getNodeValue()));
			Block.craft.setStack(Integer.parseInt(element.getElementsByTagName("block-craft").item(0).getChildNodes().item(0).getNodeValue()));
			Block.furnace.setStack(Integer.parseInt(element.getElementsByTagName("block-furnace").item(0).getChildNodes().item(0).getNodeValue()));
			Block.tnt.setStack(Integer.parseInt(element.getElementsByTagName("block-tnt").item(0).getChildNodes().item(0).getNodeValue()));
			Block.glass.setStack(Integer.parseInt(element.getElementsByTagName("block-glass").item(0).getChildNodes().item(0).getNodeValue()));
			Block.obsidian.setStack(Integer.parseInt(element.getElementsByTagName("block-obsidian").item(0).getChildNodes().item(0).getNodeValue()));
			Block.enchant.setStack(Integer.parseInt(element.getElementsByTagName("block-enchant").item(0).getChildNodes().item(0).getNodeValue()));
			Block.shelf.setStack(Integer.parseInt(element.getElementsByTagName("block-shelf").item(0).getChildNodes().item(0).getNodeValue()));
			Block.brick.setStack(Integer.parseInt(element.getElementsByTagName("block-brick").item(0).getChildNodes().item(0).getNodeValue()));
			Block.note.setStack(Integer.parseInt(element.getElementsByTagName("block-note").item(0).getChildNodes().item(0).getNodeValue()));
			Block.glow.setStack(Integer.parseInt(element.getElementsByTagName("block-glow").item(0).getChildNodes().item(0).getNodeValue()));
			Block.jukebox.setStack(Integer.parseInt(element.getElementsByTagName("block-jukebox").item(0).getChildNodes().item(0).getNodeValue()));
			Block.coalOre.setStack(Integer.parseInt(element.getElementsByTagName("block-coalore").item(0).getChildNodes().item(0).getNodeValue()));
			Block.ironOre.setStack(Integer.parseInt(element.getElementsByTagName("block-ironore").item(0).getChildNodes().item(0).getNodeValue()));
			Block.goldOre.setStack(Integer.parseInt(element.getElementsByTagName("block-goldore").item(0).getChildNodes().item(0).getNodeValue()));
			Block.diamondOre.setStack(Integer.parseInt(element.getElementsByTagName("block-diamondore").item(0).getChildNodes().item(0).getNodeValue()));
			Block.emeraldOre.setStack(Integer.parseInt(element.getElementsByTagName("block-emeraldore").item(0).getChildNodes().item(0).getNodeValue()));
			
			Item.coal.setStack(Integer.parseInt(element.getElementsByTagName("item-coal").item(0).getChildNodes().item(0).getNodeValue()));
			Item.diamond.setStack(Integer.parseInt(element.getElementsByTagName("item-diamond").item(0).getChildNodes().item(0).getNodeValue()));
			Item.iron.setStack(Integer.parseInt(element.getElementsByTagName("item-iron").item(0).getChildNodes().item(0).getNodeValue()));
			Item.gold.setStack(Integer.parseInt(element.getElementsByTagName("item-gold").item(0).getChildNodes().item(0).getNodeValue()));
			Item.stick.setStack(Integer.parseInt(element.getElementsByTagName("item-stick").item(0).getChildNodes().item(0).getNodeValue()));
			Item.bowl.setStack(Integer.parseInt(element.getElementsByTagName("item-bowl").item(0).getChildNodes().item(0).getNodeValue()));
			Item.string.setStack(Integer.parseInt(element.getElementsByTagName("item-string").item(0).getChildNodes().item(0).getNodeValue()));
			Item.feather.setStack(Integer.parseInt(element.getElementsByTagName("item-feather").item(0).getChildNodes().item(0).getNodeValue()));
			Item.sulphur.setStack(Integer.parseInt(element.getElementsByTagName("item-sulphur").item(0).getChildNodes().item(0).getNodeValue()));
			Item.clay.setStack(Integer.parseInt(element.getElementsByTagName("item-clay").item(0).getChildNodes().item(0).getNodeValue()));
			Item.cane.setStack(Integer.parseInt(element.getElementsByTagName("item-cane").item(0).getChildNodes().item(0).getNodeValue()));
			Item.seed.setStack(Integer.parseInt(element.getElementsByTagName("item-seed").item(0).getChildNodes().item(0).getNodeValue()));
			Item.paper.setStack(Integer.parseInt(element.getElementsByTagName("item-paper").item(0).getChildNodes().item(0).getNodeValue()));
			Item.book.setStack(Integer.parseInt(element.getElementsByTagName("item-book").item(0).getChildNodes().item(0).getNodeValue()));
			Item.compass.setStack(Integer.parseInt(element.getElementsByTagName("item-compass").item(0).getChildNodes().item(0).getNodeValue()));
			Item.bed.setStack(Integer.parseInt(element.getElementsByTagName("item-bed").item(0).getChildNodes().item(0).getNodeValue()));
			Item.wool.setStack(Integer.parseInt(element.getElementsByTagName("item-wool").item(0).getChildNodes().item(0).getNodeValue()));
			Item.bone.setStack(Integer.parseInt(element.getElementsByTagName("item-bone").item(0).getChildNodes().item(0).getNodeValue()));
			Item.map.setStack(Integer.parseInt(element.getElementsByTagName("item-map").item(0).getChildNodes().item(0).getNodeValue()));
			Item.disc.setStack(Integer.parseInt(element.getElementsByTagName("item-disc").item(0).getChildNodes().item(0).getNodeValue()));
			Item.leather.setStack(Integer.parseInt(element.getElementsByTagName("item-leather").item(0).getChildNodes().item(0).getNodeValue()));
			Item.torch.setStack(Integer.parseInt(element.getElementsByTagName("item-torch").item(0).getChildNodes().item(0).getNodeValue()));
			Item.cocoa.setStack(Integer.parseInt(element.getElementsByTagName("item-cocoa").item(0).getChildNodes().item(0).getNodeValue()));
			Item.emerald.setStack(Integer.parseInt(element.getElementsByTagName("item-emerald").item(0).getChildNodes().item(0).getNodeValue()));
			
			Food.apple.setStack(Integer.parseInt(element.getElementsByTagName("food-apple").item(0).getChildNodes().item(0).getNodeValue()));
			Food.bread.setStack(Integer.parseInt(element.getElementsByTagName("food-bread").item(0).getChildNodes().item(0).getNodeValue()));
			Food.cake.setStack(Integer.parseInt(element.getElementsByTagName("food-cake").item(0).getChildNodes().item(0).getNodeValue()));
			Food.carrot.setStack(Integer.parseInt(element.getElementsByTagName("food-carrot").item(0).getChildNodes().item(0).getNodeValue()));
			Food.potato.setStack(Integer.parseInt(element.getElementsByTagName("food-potato").item(0).getChildNodes().item(0).getNodeValue()));
			Food.potatoBaked.setStack(Integer.parseInt(element.getElementsByTagName("food-potatobaked").item(0).getChildNodes().item(0).getNodeValue()));
			Food.chickenRaw.setStack(Integer.parseInt(element.getElementsByTagName("food-chickenraw").item(0).getChildNodes().item(0).getNodeValue()));
			Food.chickenCooked.setStack(Integer.parseInt(element.getElementsByTagName("food-chickencooked").item(0).getChildNodes().item(0).getNodeValue()));
			Food.porkRaw.setStack(Integer.parseInt(element.getElementsByTagName("food-porkraw").item(0).getChildNodes().item(0).getNodeValue()));
			Food.porkCooked.setStack(Integer.parseInt(element.getElementsByTagName("food-porkcooked").item(0).getChildNodes().item(0).getNodeValue()));
			Food.stew.setStack(Integer.parseInt(element.getElementsByTagName("food-stew").item(0).getChildNodes().item(0).getNodeValue()));
			Food.beefRaw.setStack(Integer.parseInt(element.getElementsByTagName("food-beefraw").item(0).getChildNodes().item(0).getNodeValue()));
			Food.beefCooked.setStack(Integer.parseInt(element.getElementsByTagName("food-beefcooked").item(0).getChildNodes().item(0).getNodeValue()));
			Food.fishRaw.setStack(Integer.parseInt(element.getElementsByTagName("food-fishraw").item(0).getChildNodes().item(0).getNodeValue()));
			Food.fishCooked.setStack(Integer.parseInt(element.getElementsByTagName("food-fishcooked").item(0).getChildNodes().item(0).getNodeValue()));
			Food.flesh.setStack(Integer.parseInt(element.getElementsByTagName("food-flesh").item(0).getChildNodes().item(0).getNodeValue()));
		}
	}
	
	/**
	 * Saves the inventory data to a file
	 * @param w - The World object
	 * @throws IOException
	 */
	public static void saveInv(World w) throws IOException{
		FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/saves/" + w.name + "/inv.dat");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<inv>\n");
		bw.write("\t<block-grass>" + Block.grass.getStack() + "</block-grass>\n");
		bw.write("\t<block-dirt>" + Block.dirt.getStack() + "</block-dirt>\n");
		bw.write("\t<block-stone>" + Block.stone.getStack() + "</block-stone>\n");
		bw.write("\t<block-wood>" + Block.wood.getStack() + "</block-wood>\n");
		bw.write("\t<block-plank>" + Block.plank.getStack() + "</block-plank>\n");
		bw.write("\t<block-sand>" + Block.sand.getStack() + "</block-sand>\n");
		bw.write("\t<block-craft>" + Block.craft.getStack() + "</block-craft>\n");
		bw.write("\t<block-furnace>" + Block.furnace.getStack() + "</block-furnace>\n");
		bw.write("\t<block-tnt>" + Block.tnt.getStack() + "</block-tnt>\n");
		bw.write("\t<block-glass>" + Block.glass.getStack() + "</block-glass>\n");
		bw.write("\t<block-obsidian>" + Block.obsidian.getStack() + "</block-obsidian>\n");
		bw.write("\t<block-enchant>" + Block.enchant.getStack() + "</block-enchant>\n");
		bw.write("\t<block-shelf>" + Block.shelf.getStack() + "</block-shelf>\n");
		bw.write("\t<block-brick>" + Block.brick.getStack() + "</block-brick>\n");
		bw.write("\t<block-note>" + Block.note.getStack() + "</block-note>\n");
		bw.write("\t<block-glow>" + Block.glow.getStack() + "</block-glow>\n");
		bw.write("\t<block-glow>" + Block.glow.getStack() + "</block-glow>\n");
		bw.write("\t<block-jukebox>" + Block.jukebox.getStack() + "</block-jukebox>\n");
		bw.write("\t<block-coalore>" + Block.coalOre.getStack() + "</block-coalore>\n");
		bw.write("\t<block-ironore>" + Block.ironOre.getStack() + "</block-ironore>\n");
		bw.write("\t<block-goldore>" + Block.goldOre.getStack() + "</block-goldore>\n");
		bw.write("\t<block-diamondore>" + Block.diamondOre.getStack() + "</block-diamondore>\n");
		bw.write("\t<block-emeraldore>" + Block.emeraldOre.getStack() + "</block-emeraldore>\n");
		bw.write("\n");
		bw.write("\t<item-coal>" + Item.coal.getStack() + "</item-coal>\n");
		bw.write("\t<item-diamond>" + Item.diamond.getStack() + "</item-diamond>\n");
		bw.write("\t<item-iron>" + Item.iron.getStack() + "</item-iron>\n");
		bw.write("\t<item-gold>" + Item.gold.getStack() + "</item-gold>\n");
		bw.write("\t<item-stick>" + Item.stick.getStack() + "</item-stick>\n");
		bw.write("\t<item-bowl>" + Item.bowl.getStack() + "</item-bowl>\n");
		bw.write("\t<item-string>" + Item.string.getStack() + "</item-string>\n");
		bw.write("\t<item-feather>" + Item.feather.getStack() + "</item-feather>\n");
		bw.write("\t<item-sulphur>" + Item.sulphur.getStack() + "</item-sulphur>\n");
		bw.write("\t<item-clay>" + Item.clay.getStack() + "</item-clay>\n");
		bw.write("\t<item-cane>" + Item.cane.getStack() + "</item-cane>\n");
		bw.write("\t<item-seed>" + Item.seed.getStack() + "</item-seed>\n");
		bw.write("\t<item-paper>" + Item.paper.getStack() + "</item-paper>\n");
		bw.write("\t<item-book>" + Item.book.getStack() + "</item-book>\n");
		bw.write("\t<item-compass>" + Item.compass.getStack() + "</item-compass>\n");
		bw.write("\t<item-bed>" + Item.bed.getStack() + "</item-bed>\n");
		bw.write("\t<item-wool>" + Item.wool.getStack() + "</item-wool>\n");
		bw.write("\t<item-bone>" + Item.bone.getStack() + "</item-bone>\n");
		bw.write("\t<item-map>" + Item.map.getStack() + "</item-map>\n");
		bw.write("\t<item-disc>" + Item.disc.getStack() + "</item-disc>\n");
		bw.write("\t<item-leather>" + Item.leather.getStack() + "</item-leather>\n");
		bw.write("\t<item-torch>" + Item.torch.getStack() + "</item-torch>\n");
		bw.write("\t<item-cocoa>" + Item.cocoa.getStack() + "</item-cocoa>\n");
		bw.write("\t<item-emerald>" + Item.emerald.getStack() + "</item-emerald>\n");
		bw.write("\n");
		bw.write("\t<food-apple>" + Food.apple.getStack() + "</food-apple>\n");
		bw.write("\t<food-bread>" + Food.bread.getStack() + "</food-bread>\n");
		bw.write("\t<food-cake>" + Food.cake.getStack() + "</food-cake>\n");
		bw.write("\t<food-carrot>" + Food.carrot.getStack() + "</food-carrot>\n");
		bw.write("\t<food-potato>" + Food.potato.getStack() + "</food-potato>\n");
		bw.write("\t<food-potatobaked>" + Food.potatoBaked.getStack() + "</food-potatobaked>\n");
		bw.write("\t<food-chickenraw>" + Food.chickenRaw.getStack() + "</food-chickenraw>\n");
		bw.write("\t<food-chickencooked>" + Food.chickenCooked.getStack() + "</food-chickencooked>\n");
		bw.write("\t<food-porkraw>" + Food.porkRaw.getStack() + "</food-porkraw>\n");
		bw.write("\t<food-porkcooked>" + Food.porkCooked.getStack() + "</food-porkcooked>\n");
		bw.write("\t<food-stew>" + Food.stew.getStack() + "</food-stew>\n");
		bw.write("\t<food-beefraw>" + Food.beefRaw.getStack() + "</food-beefraw>\n");
		bw.write("\t<food-beefcooked>" + Food.beefCooked.getStack() + "</food-beefcooked>\n");
		bw.write("\t<food-fishraw>" + Food.fishRaw.getStack() + "</food-fishraw>\n");
		bw.write("\t<food-fishcooked>" + Food.fishCooked.getStack() + "</food-fishcooked>\n");
		bw.write("\t<food-flesh>" + Food.flesh.getStack() + "</food-flesh>\n");
		bw.write("</inv>");
		bw.close();
	}
}