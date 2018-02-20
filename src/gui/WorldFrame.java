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
import gui.MapMode;
import shapes.tRectangle;


public class WorldFrame extends JFrame{

	private World myWorld;
	private int myCurrentMapMode;	
	private boolean myIsRun;
	private boolean myIsUpdateButtons;	
	private JPanel myButtonPanel;	
	private tRectangle mySelectedRegion;
	private TileButtonGrid myTileButtonGrid;
	
	
	public WorldFrame(World world) {
		super("Seed: " + world.toString());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		myWorld = world;
		myCurrentMapMode = MapMode.BIOME;
		myIsRun = true;
		myIsUpdateButtons = false;
		mySelectedRegion = myWorld.getTileGrid().getDimension().copy();
		myTileButtonGrid = new TileButtonGrid(myWorld.getTileGrid(),mySelectedRegion);
		
		myButtonPanel = new JPanel();						
		this.add(myButtonPanel);
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu fileMenu = new JMenu();
		menubar.add(fileMenu);
				
		this.setJMenuBar(menubar);
				
		draw();

	}
	
	public void updateButtons() {
		int width = mySelectedRegion.getWidth();
		int height = mySelectedRegion.getHeight();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				TileButton temp = myTileButtonGrid.getTileButton(x, y);
				temp.updateMapMode(myCurrentMapMode);
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
				temp.updateMapMode(myCurrentMapMode);
				myButtonPanel.add(temp);
			}
			
		}		
	}
	
	public void run() {
		myIsRun = true;
		while(myIsRun){
			if(myIsUpdateButtons) {
				updateButtons();
			}
			myWorld.tick();
		}
	}

	public World getWorld() {
		return myWorld;
	}

	public int getCurrentMapMode() {
		return myCurrentMapMode;
	}

	public void setCurrentMapMode(int myCurrentMapMode) {
		this.myCurrentMapMode = myCurrentMapMode;
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
	
	public void setIsRedraw(boolean isUpdateButtons) {
		this.myIsUpdateButtons = isUpdateButtons;
	}
}
