package com.evh98.stext.world;

import java.util.Random;

import com.evh98.stext.main.Sys;

public class World {

	// Random object
	private static Random r = new Random();
	
	// Name of the world
	public String name;
	// Tiles in the world
	public Tile[][] tiles = new Tile[8][8];
	// Tick count of the world
	public int tickCount;
	// Boolean to track whether it is day or not
	public boolean day;
	
	/**
	 * Generates the world
	 */
	public void generate(){
		for(int i=0;i<=7;i++){
			for(int j=0;j<=7;j++){
				int x = r.nextInt(100)+1;
				int a;
				if(x<=100 && x>=60){
					a = r.nextInt(4) + 1;
				}else{
					a = 0;
				}
				tiles[i][j] = new Tile(Biome.getBiome((r.nextInt(9)+1)), Mob.getMob(a));
			}
		}
		tickCount = 1;
	}
	
	public void randomMob(Player p){
		if(day==false){
			int a = r.nextInt(4) + 5;
			Mob m = Mob.getMob(a);
			int x = r.nextInt(5) + 1;
		
			if(x==1){
				Sys.print("A wild " + m.getName() + " has appeared!");
				Battle.mainHostile(p, m);
			}
		}
	}
	
	public void timeCheck(){
		if(tickCount>=1 && tickCount<=34){
			day = true;
		}
		if(tickCount>=35 && tickCount<=60){
			day = false;
		}
		if(tickCount>=61){
			tickCount = 1;
			day = true;
		}
		if(tickCount==1){
			Sys.print("It is now day!");
		}
		if(tickCount==35){
			Sys.print("It is now night!");
		}
	}
	
	public void deathCheck(Player p){
		if(p.health==0){
			p.death();
		}
	}
}