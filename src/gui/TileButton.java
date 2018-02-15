package gui;

import javax.swing.JButton;
import tile.Tile;

public class TileButton extends JButton{
	private Tile myTile;
	
	
	public TileButton(Tile tile) {
		super();
		myTile = tile;
	}
	
	public void updateMapMode(int mapMode) {
		this.setText(myTile.getHeight() + ", " + myTile.getTemperature() + ", "+ myTile.getRainfall());
	}
}
