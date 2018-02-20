package tile;

import java.util.Random;

import shapes.tPoint;
import shapes.tRectangle;

public class TileGrid {
	private Random myRandom;
	private tRectangle myDimension;
	private Tile[][] myTiles;
	
	public TileGrid(int width, int height) {
		myRandom = new Random(System.currentTimeMillis());
		myDimension = new tRectangle(width,height);
		myTiles = new Tile[width][height];
		
		for(int x = 0; x < myDimension.getWidth(); x++) {
			for(int y = 0; y < myDimension.getHeight(); y++) {
				myTiles[x][y] = new Tile(0,0,0);				
			}
		}
	}
	
	public Tile getTile(tPoint point) {
		return getTile((int)point.getX(),(int)point.getY());
	}
	
	public Tile getTile(int x, int y) {
		tPoint point = myDimension.findWrappedPoint(x,y);		
		return myTiles[point.getX()][point.getY()];
	}

	public Random getRandom() {
		return myRandom;
	}

	public tRectangle getDimension() {
		return myDimension;
	}
	
}