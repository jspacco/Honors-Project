package world;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

import datastructures.tRunnable;
import tile.Biome;
import tile.Tile;
import tile.TileGrid;
import worldgen.PerlinNoiseGen;

public class World extends tRunnable{
	private TileGrid myTileGrid;
	
	public World(int width, int height) {		
		myTileGrid = new TileGrid(width, height, new PerlinNoiseGen(width,height));
		
	}

	public String getReadableClassType() {
		return "World";
	}

	public void edit() {
		// TODO Auto-generated method stub
		
	}

	public void tick() {
		for(int x = 0; x < myTileGrid.getDimension().getWidth(); x++) {
			for(int y = 0; y < myTileGrid.getDimension().getHeight(); y++) {
				myTileGrid.getTile(x, y).tick();
			}
		}
		
	}
	
	public TileGrid getTileGrid() {
		return myTileGrid;
	}
}
