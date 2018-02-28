package gui;

import java.util.Random;

import shapes.tPoint;
import shapes.tRectangle;
import tile.Tile;
import tile.TileGrid;

public class TileButtonGrid {
	private TileGrid myTileGrid;
	private tRectangle myDimension;
	private TileButton[][] myTileButtons;
	private MapModes myMapModes;
	
	public TileButtonGrid(TileGrid tileGrid, MapModes mapModes, int x, int y, int width, int height) {
		this(tileGrid,mapModes,new tPoint(x,y),width,height);
	}
	
	public TileButtonGrid(TileGrid tileGrid, MapModes mapModes, tPoint bottomLeft, int width, int height) {
		this(tileGrid,mapModes,new tRectangle(bottomLeft,width,height));
	}
	
	public TileButtonGrid(TileGrid tileGrid, MapModes mapModes, tRectangle dimension) {
		myDimension = dimension;
		myTileButtons = new TileButton[myDimension.getWidth()][dimension.getHeight()];
		myTileGrid = tileGrid;
		myMapModes = mapModes;
		for(int x = myDimension.getBottomLeft().getX(); x < myDimension.getWidth() + myDimension.getBottomLeft().getX(); x++) {
			for(int y = myDimension.getBottomLeft().getY(); y < myDimension.getHeight() + myDimension.getBottomLeft().getY(); y++) {
				myTileButtons[x][y] = new TileButton(mapModes,myTileGrid.getTile(x, y), new tPoint(x,y));				
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
