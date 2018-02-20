package tile;

import java.awt.Color;
import java.util.Random;

import datastructures.tRunnable;

public class Tile extends tRunnable{
	
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
				
	}

	@Override
	public String getReadableClassType() {
		return "tile";
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	public int getHeight() {
		return myHeight;
	}

	public void setHeight(int height) {
		this.myHeight = height;
		if(myHeight < 0 || myHeight >= 100)
			myHeight = 0;
	}

	public void incrementHeight(int height) {
		setHeight(myHeight+height);
	}
	
	public int getRainfall() {
		return myRainfall;
	}

	public void setRainfall(int rainfall) {
		this.myRainfall = rainfall;
		if(myRainfall < 0 || myRainfall >= 100)
			myRainfall = 0;
	}

	public void incrementRainfall(int rainfall) {
		setRainfall(myRainfall+rainfall);
	}
	
	public int getTemperature() {
		return myTemperature;
	}

	public void setTemperature(int temperature) {
		this.myTemperature = temperature;
		if(myTemperature < 0 || myTemperature >= 100)
			myTemperature = 0;
	}
	
	public void incrementTemperature(int temperature) {
		setTemperature(myTemperature+temperature);
	}
}
