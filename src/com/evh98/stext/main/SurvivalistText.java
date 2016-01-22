package com.evh98.stext.main;

import com.evh98.stext.manager.Command;
import com.evh98.stext.world.Player;
import com.evh98.stext.world.World;

public class SurvivalistText {
	
	// Name of the game
	public static final String NAME = "Survivalist";
	// Version of the game
	public static final String VER = "1.0.0";
	// Is a game running
	public static boolean isPlaying;
	// User's input as a string
	public static String input;
	// Command parameter
	public static String cp;
	
	// New world object
	public static World w = new World();
	// New player object
	public static Player p = new Player();
	
	/**
	 * Initialises the game
	 */
	public static void init(){
		if(Command.isEntered(input, "play", "start", null)){
			Command.play(w, p, cp);
			clearText();
		}else if(Command.isEntered(input, "/load", null, null)){
			Command.load(cp, w, p);
			clearText();
		}else{
			Command.invalid();
			clearText();
			init();
		}
	}
	
	/**
	 * Grabs input from the user, and runs the command
	 */
	public static void getInput(){
		if(Command.isEntered(input, "move", "go", "travel")){
			Command.move(w, p, cp);
			endTurn();
		}else if(Command.isEntered(input, "collect", "get", "obtain")){
			Command.collect(p, cp);
			endTurn();
		}else if(Command.isEntered(input, "eat", null, null)){
			Command.eat(p, cp);
			endTurn();
		}else if(Command.isEntered(input, "attack", "kill", null)){
			Command.attack(p);
			endTurn();
		}else if(Command.isEntered(input, "surroundings", null, null)){
			Command.surroundings(w, p);
			endTurn();
		}else if(Command.isEntered(input, "craft", "make", null)){
			Command.craft(p, cp);
			endTurn();
		}else if(Command.isEntered(input, "smelt", null, null)){
			Command.smelt(p, cp);
			endTurn();
		}else if(Command.isEntered(input, "sleep", "rest", null)){
			Command.sleep(w, p);
			endTurn();
		}else if(Command.isEntered(input, "/save", null, null)){
			Command.save(w, p);
			clearText();
		}else if(Command.isEntered(input, "/load", null, null)){
			Command.load(cp, w, p);
			clearText();
		}
		else{
			Command.invalid();
			clearText();
		}
	}
	
	/**
	 * Ends the player's current turn and updates everything
	 */
	public static void endTurn(){
		w.tickCount++;
		w.timeCheck();
		w.randomMob(p);
		clearText();
	}
	
	/**
	 * Clears text
	 */
	public static void clearText(){
		Window.input.setText("");
	}
	
	/**
	 * Main method
	 */
	public static void main(String args[]){
		Window w = new Window();
		Sys.print("Hello, and welcome to " + NAME + "!");
	}
}