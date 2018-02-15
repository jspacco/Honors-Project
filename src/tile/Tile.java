package tile;

import java.awt.Color;
import java.util.Random;

import datastructures.tRunnable;

public class Tile extends tRunnable{
	public static final int maxHeight = 100;
	public static final int maxRainfall = 100;
	public static final int maxTemperature = 100;
	
	private int myHeight;
	private int myRainfall;
	private int myTemperature;
	
	private Biome myBiome;
	
	public Tile(int height, int rainfall, int temperature) {
		myHeight = height;
		myRainfall = rainfall;
		myTemperature = temperature;
	}

	@Override
	public void tick() {
		myHeight++;		
	}

	@Override
	public String getReadableClassType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	public int getHeight() {
		return myHeight;
	}

	public void setHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	public int getRainfall() {
		return myRainfall;
	}

	public void setRainfall(int myRainfall) {
		this.myRainfall = myRainfall;
	}

	public int getTemperature() {
		return myTemperature;
	}

	public void setTemperature(int myTemperature) {
		this.myTemperature = myTemperature;
	}
	
	
}
