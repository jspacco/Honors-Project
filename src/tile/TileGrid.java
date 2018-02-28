package tile;

import java.util.Random;

import shapes.tPoint;
import shapes.tRectangle;

public class TileGrid {
	private Random myRandom = new Random(System.currentTimeMillis());;
	private tRectangle myDimension;
	private Tile[][] myTiles;
	
	public TileGrid(int width, int height) {
		myDimension = new tRectangle(width,height);
		myTiles = new Tile[width][height];
		
		for(int x = 0; x < myDimension.getWidth(); x++) {
			for(int y = 0; y < myDimension.getHeight(); y++) {
				myTiles[x][y] = new Tile(0,0,0);				
			}
		}
		
		/*
		tRectangle temp = new tRectangle(0,0,3,3);
		tPoint[] points = myDimension.getRandomWrappedPoints(temp);
		for(tPoint point: points) {
			Tile tile = myTiles[point.getX()][point.getY()];
			tile.incrementHeight(100);
			tile.incrementRainfall(100);
			tile.incrementTemperature(100);
			System.out.println(point + " " + tile);
		}
		*/
		
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 100; j++) {
				tRectangle temp = myDimension.createRandWrappedtangle();
				//tRectangle temp = new tRectangle(-3,-3,3,3);
				tPoint[] points = myDimension.getRandomWrappedPoints(temp);
				for(tPoint point: points) {
					Tile tile = myTiles[point.getX()][point.getY()];
					if(i==0)
						tile.incrementHeight(1);
					else if(i==1)
						tile.incrementRainfall(1);
					else if(i==2)
						tile.incrementTemperature(1);
				}
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