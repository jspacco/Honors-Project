/*
Code the diamond sqyare algorithm bluh.org
 */

package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import tile.Biome;
import tile.Tile;
import world.World;
import shapes.tRectangle;
import java.util.concurrent.TimeUnit;

public class WorldFrame extends JFrame{

	private World myWorld;
	private MapModes myMapModes;	
	private JPanel myButtonPanel;	
	private tRectangle mySelectedRegion;
	private TileButtonGrid myTileButtonGrid;
	
	private boolean myIsRun;
	private boolean myIsUpdateButtons;	
	private int myWaitInSeconds;
	
	public WorldFrame(World world) {
		super("Seed: " + world.toString());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		myWorld = world;
		myMapModes = new MapModes(myTileButtonGrid);
		myIsRun = false;
		myIsUpdateButtons = false;
		mySelectedRegion = myWorld.getTileGrid().getDimension().copy();
		
		JMenuBar menubar = new WorldMenuBar(this);
		this.setJMenuBar(menubar);
		
		myTileButtonGrid = new TileButtonGrid(myWorld.getTileGrid(),myMapModes,mySelectedRegion);
		myWaitInSeconds = 1;
		myButtonPanel = new JPanel();						
		this.add(myButtonPanel);
				
		draw();

	}
	
	public void updateButtons() {
		int width = mySelectedRegion.getWidth();
		int height = mySelectedRegion.getHeight();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				TileButton temp = myTileButtonGrid.getTileButton(x, y);
				temp.update();
			}
		}
	}
	
	public void draw() {
		myButtonPanel.removeAll();
		
		int width = mySelectedRegion.getWidth();
		int height = mySelectedRegion.getHeight();
		
		GridLayout layout = new GridLayout(width,height);
		myButtonPanel.setLayout(layout);
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				TileButton temp = myTileButtonGrid.getTileButton(x, y);
				temp.update();
				myButtonPanel.add(temp);
			}
			
		}		
	}
	
	public void run() {
		myIsRun = true;
		while(myIsRun){
			try {
				TimeUnit.SECONDS.sleep(myWaitInSeconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(myIsUpdateButtons) {
				updateButtons();
			}
			myWorld.tick();
		}
	}

	public World getWorld() {
		return myWorld;
	}

	public boolean isRun() {
		return myIsRun;
	}

	public void setIsRun(boolean isRun) {
		this.myIsRun = isRun;
	}
	
	public boolean isUpdateButtons() {
		return myIsUpdateButtons;
	}
	
	public void setIsUpdateButtons(boolean isUpdateButtons) {
		this.myIsUpdateButtons = isUpdateButtons;
	}
	
	public MapModes getMapModes() {
		return myMapModes;
	}
}
