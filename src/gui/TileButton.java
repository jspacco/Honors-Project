package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import tile.Tile;

public class TileButton extends JButton{
	private Tile myTile;
	
	
	public TileButton(Tile tile) {
		super();
		myTile = tile;
		//this.setBackground(new Color(cch(tile.getHeight()),cch(tile.getRainfall()),cch(tile.getTemperature())));
		//this.setBackground(new Color(cch(tile.getHeight()),0,0));
		//this.setBackground(new Color(cch(tile.getHeight()+tile.getRainfall()+tile.getTemperature()),0,0));
		//this.setForeground(Color.WHITE);
		this.setForeground(new Color(cch(tile.getHeight()+tile.getRainfall()+tile.getTemperature()),0,0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void updateMapMode(int mapMode) {
		this.setText("h" + myTile.getHeight() + ", t" + myTile.getTemperature() + ", r"+ myTile.getRainfall());
		this.setText(this.getBackground().toString());
		double temp = myTile.getHeight()+myTile.getRainfall()+myTile.getTemperature();
		temp/=300;
		temp*=10;
		temp = (int)temp;
		temp*=10;

		this.setText(""+temp);
	}
	
	public int cch(int y) {
		return (y*255)/300;
	}
}
