package com.evh98.stext.world;

import java.io.Serializable;

public class Biome implements Serializable{

	// Biome ID
	private final int id;
	// Biome name
	private final String name;
	// Features in the biome
	private final String features;
	
	/**
	 * Constructer
	 * @param id - Biome ID
	 * @param name - Biome name
	 * @param features - Features in the biome
	 */
	public Biome(int id, String name, String features){
		this.id = id;
		this.name = name;
		this.features = features;
	}

	/*
	 * Biome objects
	 */
	public static final Biome forest = new Biome(1, "Forest", "trees and dirt");
	public static final Biome desert = new Biome(2, "Desert", "sand and sugar canes");
	public static final Biome plains = new Biome(3, "Plains", "dirt");
	public static final Biome swamp = new Biome(4, "Swamp", "trees, dirt and clay");
	public static final Biome jungle = new Biome(5, "Jungle", "trees, cocoa beans and dirt");
	public static final Biome icy = new Biome(6, "Icy", "trees, snow and dirt");
	public static final Biome hills = new Biome(7, "Extreme Hills", "trees, stone and dirt");
	public static final Biome ocean = new Biome(8, "Ocean", "water");
	public static final Biome village = new Biome(9, "Village", "a village");
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFeatures() {
		return features;
	}
	
	/**
	 * Returns a biome based on the id passed through
	 * @param id - Biome ID
	 * @return Biome
	 */
	public static Biome getBiome(int id){
		Biome b;
		switch(id){
		case 1:
			b = forest;
			break;
		case 2:
			b = desert;
			break;
		case 3:
			b = plains;
			break;
		case 4:
			b = swamp;
			break;
		case 5:
			b = jungle;
			break;
		case 6:
			b = icy;
			break;
		case 7:
			b = hills;
			break;
		case 8:
			b = ocean;
			break;
		case 9:
			b = village;
			break;
		default:
			return null;
		}
		return b;
	}
}