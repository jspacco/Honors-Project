package gui;

import java.awt.Dimension;
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


public class WorldFrame extends JFrame{

	private World myWorld;
	private int myCurrentMapMode;	
	private boolean myIsRun;
	private boolean myIsRedraw;	
	private JPanel myButtonPanel;	
	
	public WorldFrame(World world) {
		super("Seed: " + world.toString());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		myWorld = world;
		myCurrentMapMode = MapMode.BIOME;
		myIsRun = true;
		myIsRedraw = true;
		
		myButtonPanel = new JPanel();						
		this.add(myButtonPanel);
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu fileMenu = new JMenu();
		menubar.add(fileMenu);
				
		this.setJMenuBar(menubar);
				
		redraw();

	}
	
	public void redraw() {
		myButtonPanel.removeAll();
		
		Dimension dim = myWorld.getTileGrid().getDimension();
		int width =(int) dim.getWidth();
		int height = (int) dim.getHeight();
		
		GridLayout layout = new GridLayout(width,height);
		myButtonPanel.setLayout(layout);
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Tile tile = myWorld.getTileGrid().getTile(x, y);
				TileButton temp = new TileButton(tile);
				temp.updateMapMode(myCurrentMapMode);
				myButtonPanel.add(temp);
			}
			
		}		
	}
	
	public void run() {
		myIsRun = true;
		while(myIsRun){
			if(myIsRedraw) {
				redraw();
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
	
	public boolean isRedraw() {
		return myIsRedraw;
	}
	
	public void setIsRedraw(boolean isRedraw) {
		this.myIsRedraw = isRedraw;
	}
}
