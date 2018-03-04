package tile;

import java.util.Random;

import shapes.tPoint;
import shapes.tRectangle;
import worldgen.WorldGen;

public class TileGrid {
	private Random myRandom = new Random(System.currentTimeMillis());;
	private tRectangle myDimension;
	private Tile[][] myTiles;
	private WorldGen myWorldGen;
	
	public TileGrid(int width, int height, WorldGen worldGen) {
		myDimension = new tRectangle(width,height);
		myTiles = new Tile[width][height];
		myWorldGen = worldGen;
		int[][][] worldValues = worldGen.getGenerationValues();
		
		for(int x = 0; x < myDimension.getWidth(); x++) {
			for(int y = 0; y < myDimension.getHeight(); y++) {
				int[] tileValues = worldValues[x][y];
				myTiles[x][y] = new Tile(tileValues[0],tileValues[1],tileValues[2]);
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