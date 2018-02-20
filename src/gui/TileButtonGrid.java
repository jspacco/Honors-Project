package gui;

import java.util.Random;

import shapes.tPoint;
import shapes.tRectangle;
import tile.Tile;
import tile.TileGrid;

public class TileButtonGrid {
	private tRectangle myDimension;
	private TileButton[][] myTileButtons;
	private TileGrid myTileGrid;
	
	public TileButtonGrid(TileGrid tileGrid, int x, int y, int width, int height) {
		this(tileGrid,new tPoint(x,y),width,height);
	}
	
	public TileButtonGrid(TileGrid tileGrid, tPoint bottomLeft, int width, int height) {
		this(tileGrid,new tRectangle(bottomLeft,width,height));
	}
	
	public TileButtonGrid(TileGrid tileGrid, tRectangle dimension) {
		myDimension = dimension;
		myTileButtons = new TileButton[myDimension.getWidth()][dimension.getHeight()];
		myTileGrid = tileGrid;
		for(int x = myDimension.getBottomLeft().getX(); x < myDimension.getWidth(); x++) {
			for(int y = myDimension.getBottomLeft().getY(); y < myDimension.getHeight(); y++) {
				myTileButtons[x][y] = new TileButton(myTileGrid.getTile(x, y));				
			}
		}
	}
	
	public TileButton getTileButton(tPoint point) {
		return getTileButton(point.getX(),point.getY());
	}
	
	public TileButton getTileButton(int x, int y) {
		return myTileButtons[x][y];
	}
}
