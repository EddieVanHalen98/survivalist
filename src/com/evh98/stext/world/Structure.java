package com.evh98.stext.world;

import java.io.Serializable;

public class Structure implements Serializable{

	// Structure ID
	private final int id;
	// Structure name
	private final String name;
	// Features in the structure
	private final String features;
	// 
	
	/**
	 * Constructer
	 * @param id - Structure ID
	 * @param name - Structure name
	 * @param features - Features in the structure
	 */
	public Structure(int id, String name, String features){
		this.id = id;
		this.name = name;
		this.features = features;
	}

	/*
	 * Structure objects
	 */
	public static final Structure forest = new Structure(1, "Tier 1 House", "");
	
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
	 * Returns a structure based on the id passed through
	 * @param id - Structure ID
	 * @return Structure
	 */
	public static Structure getStructure(int id){
		Structure s;
		switch(id){
		case 1:
			s = forest;
			break;
		default:
			return null;
		}
		return s;
	}
}