package tile;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

public class TileGrid {
	private Random myRandom;
	private Dimension myDimension;
	private Tile[][] myTiles;
	
	public TileGrid(int width, int height) {
		myRandom = new Random(System.currentTimeMillis());
		myDimension = new Dimension(width,height);
		myTiles = new Tile[width][height];
		
		for(int x = 0; x < myDimension.width; x++) {
			for(int y = 0; y < myDimension.height; y++) {
				myTiles[x][y] = new Tile(0,0,0);				
			}
		}
	}
		
	public Tile getTile(Point point) {
		return getTile((int)point.getX(),(int)point.getY());
	}
	
	public Tile getTile(int x, int y) {
		Point point = findWrappedPoint(x,y);
		int x1 = (int) point.getX();
		int y1 = (int) point.getY();
		
		return myTiles[x1][y1];
	}
	
	public Point findWrappedPoint(Point point) {
		return findWrappedPoint((int)point.getX(),(int)point.getY());
	}
	
	public Point findWrappedPoint(int x, int y) {
		
		int x1 = wrapHelp((int) x, (int) myDimension.getWidth());
		int y1 = wrapHelp((int) y, (int) myDimension.getHeight());
		return new Point(x1,y1);
	}
	
	private static int wrapHelp(int a, int max) {
		boolean pos = 0 <= a;
		boolean inrange = a < max;
		
		if(pos && inrange) {
			return a;
		}
		int value = 0;
		if(!pos) {
			int diffrence = 0 - a;
			diffrence=diffrence%max;
			value = max - diffrence;
		}
		else if(!inrange) {
			int diffrence = max - a;
			diffrence=diffrence%max;
			value = diffrence;
		}
		
		return value - 1;
		
	}

	public Random getRandom() {
		return myRandom;
	}

	public Dimension getDimension() {
		return myDimension;
	}
	
}