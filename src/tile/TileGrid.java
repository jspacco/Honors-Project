package tile;

import java.util.Random;

import shapes.tPoint;
import shapes.tRectangle;

public class TileGrid {
    public static final int ONE_RECTANGLE = 0;
    public static final int ONE_HUNDRED_RECTANGLES = 1;
    public static final int TEN_RECTANGLES = 2;
    
	private Random myRandom = new Random(System.currentTimeMillis());;
	private tRectangle myDimension;
	private Tile[][] myTiles;
	public static int launchSettings = ONE_HUNDRED_RECTANGLES;
	
	public TileGrid(int width, int height) {
		myDimension = new tRectangle(width,height);
		myTiles = new Tile[width][height];
		
		for(int x = 0; x < myDimension.getWidth(); x++) {
			for(int y = 0; y < myDimension.getHeight(); y++) {
				myTiles[x][y] = new Tile(0,0,0);				
			}
		}
		generate();
		
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
	
	private void generate(int iteration, int increment){
	    // not using this, but a possible way to parameterize configuration settings
	    for(int i = 0; i < 3; i++) {
            for(int j = 0; j < iteration; j++) {
                tRectangle temp = myDimension.createRandWrappedtangle();
                //tRectangle temp = new tRectangle(-3,-3,3,3);
                tPoint[] points = myDimension.getRandomWrappedPoints(temp);
                for(tPoint point: points) {
                    Tile tile = myTiles[point.getX()][point.getY()];
                    if(i==0)
                        tile.incrementHeight(increment);
                    else if(i==1)
                        tile.incrementRainfall(increment);
                    else if(i==2)
                        tile.incrementTemperature(increment);
                }
            }
        }
	}
	
	private void generate_00() {
		tRectangle temp = new tRectangle(-3,-3,10,10);
		tPoint[] points = myDimension.getRandomWrappedPoints(temp);
		for(tPoint point: points) {
			Tile tile = myTiles[point.getX()][point.getY()];
			tile.incrementHeight(99);
			tile.incrementRainfall(99);
			tile.incrementTemperature(99);
			System.out.println(point + " " + tile);
		}
	}
	
	private void generate_01() {
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
	
	private void generate_02() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 10; j++) {
				tRectangle temp = myDimension.createRandWrappedtangle();
				//tRectangle temp = new tRectangle(-3,-3,3,3);
				tPoint[] points = myDimension.getRandomWrappedPoints(temp);
				for(tPoint point: points) {
					Tile tile = myTiles[point.getX()][point.getY()];
					if(i==0)
						tile.incrementHeight(10);
					else if(i==1)
						tile.incrementRainfall(10);
					else if(i==2)
						tile.incrementTemperature(10);
				}
			}
		}
	}
	
	private void generate() {
		if(launchSettings==ONE_RECTANGLE) generate_00();
		else if(launchSettings==ONE_HUNDRED_RECTANGLES) generate_01();
		else if(launchSettings==TEN_RECTANGLES) generate_02();	
	}
	
}