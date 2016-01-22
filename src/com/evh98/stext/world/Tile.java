package com.evh98.stext.world;

import java.io.Serializable;

public class Tile implements Serializable{

	private static final long serialVersionUID = 2074703045905365250L;
	
	// Biome in the tile
	private Biome biome;
	// Passive mob in the tile
	private Mob mob;
	
	public Tile(Biome biome, Mob mob){
		this.setBiome(biome);
		this.setMob(mob);
	}

	public Biome getBiome() {
		return biome;
	}

	public void setBiome(Biome biome) {
		this.biome = biome;
	}

	public Mob getMob() {
		return mob;
	}

	public void setMob(Mob mob) {
		this.mob = mob;
	}
}
