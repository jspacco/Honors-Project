package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import shapes.tPoint;
import tile.Tile;

public class TileButton extends JButton{
	private MapModes myMapModes;
	private Tile myTile;
	private tPoint myPoint;
	
	public TileButton(MapModes mapModes, Tile tile, tPoint point) {
		super();
		myMapModes = mapModes;
		myTile = tile;
		myPoint = point;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myTile.edit();
			}
		});
	}
	
	public void update() {
		myMapModes.updateTileButton(this);
	}
	
	public Tile getTile() {
		return myTile;
	}
	
}
