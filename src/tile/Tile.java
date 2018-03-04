package tile;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import datastructures.tRunnable;
import runner.runner;

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

	public String toString() {
		return myHeight + ", " + myRainfall + ", " + myTemperature;
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
		JFrame frame =new JFrame();
		JButton button = new JButton(this.toString());
		runner.setFrameSize(frame,4);
		frame.add(button);
		frame.setVisible(true);
		
	}

	public int getHeight() {
		return myHeight;
	}
	
	public int getRainfall() {
		return myRainfall;
	}
	
	public int getTemperature() {
		return myTemperature;
	}
}
