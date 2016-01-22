package com.evh98.stext.world;

import com.evh98.stext.main.SurvivalistText;
import com.evh98.stext.main.Sys;
import com.evh98.stext.world.tool.*;

public class Player {

	// The player's max health
	public int maxHealth;
	// The player's health
	public int health;
	// The player's X position
	public int xPos;
	// The player's Y position
	public int yPos;
	// The player's positional tile
	public Tile tPos;
	// Player's xp count
	public int xp;
	// The axe owned by the player
	public Axe axe;
	// The hoe owned by the player
	public Hoe hoe;
	// The pickaxe owned by the player
	public Pickaxe pickaxe;
	// The shovel owned by the player
	public Shovel shovel;
	// The sword owned by the player
	public Sword sword;
	
	/**
	 * Constructor
	 */
	public Player(){
		maxHealth = 20;
		health = 20;
		xPos = 3;
		yPos = 3;
		xp = 0;
		axe = Axe.none;
		hoe = Hoe.none;
		pickaxe = Pickaxe.none;
		shovel = Shovel.none;
		sword = Sword.none;
	}

	/**
	 * Moves the player north by decreasing the y position by 1
	 */
	public void moveNorth(World w){
		if(yPos==0){
			Sys.print("You are at the edge of the map, you cannot move further north!");
		}else{
			yPos--;
			updatePosition(w);
			Sys.print("You have moved north");
			Sys.print("There is " + tPos.getBiome().getFeatures() + " around");
			if(!(tPos.getMob()==null)){
				Sys.print("There are also " + tPos.getMob().getName() + " here");
			}
		}
	}
	
	/**
	 * Moves the player south by decreasing the y position by 1
	 */
	public void moveSouth(World w){
		if(yPos==7){
			Sys.print("You are at the edge of the map, you cannot move further south!");
		}else{
			yPos++;
			updatePosition(w);
			Sys.print("You have moved south");
			Sys.print("There is " + tPos.getBiome().getFeatures() + " around");
			if(!(tPos.getMob()==null)){
				Sys.print("There are also " + tPos.getMob().getName() + " here");
			}
		}
	}
	
	/**
	 * Moves the player east by increasing the y position by 1
	 */
	public void moveEast(World w){
		if(xPos==7){
			Sys.print("You are at the edge of the map, you cannot move further east!");
		}else{
			xPos++;
			updatePosition(w);
			Sys.print("You have moved east");
			Sys.print("There is " + tPos.getBiome().getFeatures() + " around");
			if(!(tPos.getMob()==null)){
				Sys.print("There are also " + tPos.getMob().getName() + " here");
			}
		}
	}
	
	/**
	 * Moves the player west by increasing the y position by 1
	 */
	public void moveWest(World w){
		if(xPos==0){
			Sys.print("You are at the edge of the map, you cannot move further west!");
		}else{
			xPos--;
			updatePosition(w);
			Sys.print("You have moved west");
			Sys.print("There is " + tPos.getBiome().getFeatures() + " around");
			if(!(tPos.getMob()==null)){
				Sys.print("There are also " + tPos.getMob().getName() + " here");
			}
		}
	}
	
	/**
	 * Updates the player's current positional tile
	 */
	public void updatePosition(World w){
		tPos = w.tiles[xPos][yPos];
	}
	
	/**
	 * Increases the player's health by the specified amount
	 * @param amount - Amount to increase by
	 */
	public void increaseHealth(int amount){
		int i = health + amount;
		if(i>=20){
			health = maxHealth;
		}else{
			health = i;
		}
		Sys.print("You have " + health + " health points remaining");
	}
	
	/**
	 * Decreases the player's health by the specified amount
	 * @param amount - Amount to decrease by
	 */
	public void decreaseHealth(int amount){
		int i = health - amount;
		if(i<=0){
			health = 0;
		}else{
			health = i;
		}
		Sys.print("You have " + health + " health points remaining");
	}
	
	/**
	 * Adds the amount of blocks to its stack
	 * @param block - Block to control
	 * @param amount - Amount to increase by
	 */
	public void addBlock(Block block, int amount){
		block.setStack(block.getStack() + amount);
		Sys.print(amount + " " + block.getName() + " was added to your inventory!");
	}
	
	/**
	 * Removes the amount of blocks to its stack
	 * @param block - Block to control
	 * @param amount - Amount to decrease by
	 */
	public void removeBlock(Block block, int amount){
		block.setStack(block.getStack() - amount);
		Sys.print(amount + " " + block.getName() + " was removed from your inventory!");
	}
	
	/**
	 * Checks if the player has a certain amount (or more) of a specified block
	 * @param block - Specified block
	 * @param amount - Amount to check for
	 * @return boolean
	 */
	public boolean hasBlock(Block block, int amount){
		if(block.getStack() >= amount){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds the amount of items to its stack
	 * @param item - Item to control
	 * @param amount - Amount to increase by
	 */
	public void addItem(Item item, int amount){
		item.setStack(item.getStack() + amount);
		Sys.print(amount + " " + item.getName() + " was added to your inventory!");
	}
	
	/**
	 * Removes the amount of items to its stack
	 * @param item - Item to control
	 * @param amount - Amount to decrease by
	 */
	public void removeItem(Item item, int amount){
		item.setStack(item.getStack() - amount);
		Sys.print(amount + " " + item.getName() + " was removed from your inventory!");
	}
	
	/**
	 * Checks if the player has a certain amount (or more) of a specified item
	 * @param item - Specified item
	 * @param amount - Amount to check for
	 * @return boolean
	 */
	public boolean hasItem(Item item, int amount){
		if(item.getStack() >= amount){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds the amount of food to its stack
	 * @param food - Food to control
	 * @param amount - Amount to increase by
	 */
	public void addFood(Food food, int amount){
		food.setStack(food.getStack() + amount);
		Sys.print(amount + " " + food.getName() + " was added to your inventory!");
	}
	
	/**
	 * Removes the amount of food to its stack
	 * @param food - Food to control
	 * @param amount - Amount to decrease by
	 */
	public void removeFood(Food food, int amount){
		food.setStack(food.getStack() - amount);
		Sys.print(amount + " " + food.getName() + " was removed from your inventory!");
	}
	
	/**
	 * Checks if the player has a certain amount (or more) of a specified food
	 * @param food - Specified food
	 * @param amount - Amount to check for
	 * @return boolean
	 */
	public boolean hasFood(Food food, int amount){
		if(food.getStack() >= amount){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds a specified axe to the player's inventory
	 * @param a - Specified axe
	 */
	public void addAxe(Axe a){
		Sys.print("You have obtained a " + a.getName() + "!");
		axe = a;
	}
	
	/**
	 * Removes the axe owned from the player's inventory
	 */
	public void removeAxe(){
		Sys.print("You have lost your " + axe.getName() + "!");
		axe = null;
	}
	
	/**
	 * Checks if the player owns an axe
	 * @return boolean
	 */
	public boolean hasAxe(){
		if(axe!=null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if the player owns a specific axe
	 * @return boolean
	 */
	public boolean hasAxe(Axe a){
		if(axe==a){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds a specified hoe to the player's inventory
	 * @param h - Specified hoe
	 */
	public void addHoe(Hoe h){
		Sys.print("You have obtained a " + h.getName() + "!");
		hoe = h;
	}
	
	/**
	 * Removes the hoe owned from the player's inventory
	 */
	public void removeHoe(){
		Sys.print("You have lost your " + hoe.getName() + "!");
		hoe = null;
	}
	
	/**
	 * Checks if the player owns a hoe
	 * @return boolean
	 */
	public boolean hasHoe(){
		if(hoe!=null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if the player owns a specific hoe
	 * @return boolean
	 */
	public boolean hasHoe(Hoe h){
		if(hoe==h){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds a specified pickaxe to the player's inventory
	 * @param p - Specified pick
	 */
	public void addPick(Pickaxe p){
		Sys.print("You have obtained a " + p.getName() + "!");
		pickaxe = p;
	}
	
	/**
	 * Removes the pickaxe owned from the player's inventory
	 */
	public void removePick(){
		Sys.print("You have lost your " + pickaxe.getName() + "!");
		pickaxe = null;
	}
	
	/**
	 * Checks if the player owns a pickaxe
	 * @return boolean
	 */
	public boolean hasPick(){
		if(pickaxe!=null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if the player owns a specific pickaxe
	 * @return boolean
	 */
	public boolean hasPick(Pickaxe p){
		if(pickaxe==p){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds a specified shovel to the player's inventory
	 * @param s - Specified shovel
	 */
	public void addShovel(Shovel s){
		Sys.print("You have obtained a " + s.getName() + "!");
		shovel = s;
	}
	
	/**
	 * Removes the shovel owned from the player's inventory
	 */
	public void removeShovel(){
		Sys.print("You have lost your " + shovel.getName() + "!");
		shovel = null;
	}
	
	/**
	 * Checks if the player owns a shovel
	 * @return boolean
	 */
	public boolean hasShovel(){
		if(shovel!=null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checks if the player owns a specific shovel
	 * @return boolean
	 */
	public boolean hasShovel(Shovel s){
		if(shovel==s){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds a specified sword to the player's inventory
	 * @param s - Specified sword
	 */
	public void addSword(Sword s){
		Sys.print("You have obtained a " + s.getName() + "!");
		sword = s;
	}
	
	/**
	 * Removes the sword owned from the player's inventory
	 */
	public void removeSword(){
		Sys.print("You have lost your " + sword.getName() + "!");
		sword = null;
	}
	
	/**
	 * Checks if the player owns a sword
	 * @return boolean
	 */
	public boolean hasSword(){
		if(sword!=null){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Checks if the player owns a specific sword
	 * @return boolean
	 */
	public boolean hasSword(Sword s){
		if(sword==s){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Makes the player eat the specified food
	 * @param food - Specified food to eat
	 */
	public void eat(Food food){
		if(hasFood(food, 1)){
			removeFood(food, 1);
			increaseHealth(food.getHealthRegenAmount());
		}else{
			Sys.print("You don't have any " + food.getName() + " to eat!");
		}
	}
	
	/**
	 * Method ran when the player dies
	 */
	public void death(){
		Sys.print("Oh no! You died! But it's okay, you can play again if you like!");
		SurvivalistText.init();
	}
	
	public void sleep(World w){
		if(hasItem(Item.bed, 1)){
			w.day = true;
			Sys.print("You have slept in your bed!");
		}else{
			Sys.print("You need a bed to sleep!");
		}
	}
	
	/**
	 * Returns the current biome the player is located in
	 * @return Biome
	 */
	public Biome getCurrentBiome(){
		return tPos.getBiome();
	}
}