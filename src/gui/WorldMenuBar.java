package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import runner.runner;
import world.World;

public class WorldMenuBar extends JMenuBar{
	private WorldFrame myFrame;
	
	public WorldMenuBar(WorldFrame frame) {
		super();
		myFrame = frame;
		
		/*
		File
		 */
		JMenu file = new JMenu("File");
		
		JMenuItem newFrame = new JMenuItem("New");
		newFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Work in progress");
			}
			
		});
		file.add(newFrame);
		
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Work in progress");
			}
		});
		file.add(save);
		
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Work in progress");
			}
		});
		file.add(load);
		
		
		this.add(file);
		/*
		Settings
		 */
		JMenu settings = new JMenu("Settings");
		
		JMenuItem runItem = new JMenuItem("Run");//: " + myFrame.isRun());
		runItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(myFrame.isRun()) {
					myFrame.setRun(false);
				}
				else {
					myFrame.run();
				}
				System.out.println(myFrame.isRun());
			}
		});			
		settings.add(runItem);
		
		JMenuItem updateItem = new JMenuItem("Update Graphics");//: " + myFrame.isUpdateButtons());
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(myFrame.isUpdateButtons()) {
					myFrame.setUpdateButtons(false);
				}
				else {
					myFrame.updateButtons();
				}
				System.out.println(myFrame.isUpdateButtons());
			}
		});
		
		settings.add(updateItem);
		this.add(settings);
		
		/*
		MapMode
		 */
		JMenu mapMode = new JMenu("Map Mode");
		int mapModeSize = frame.getMapModes().size();
		
		for(int i = 0; i < mapModeSize; i++) {
			String name = frame.getMapModes().getMapModeName(i);
			JMenuItem mapModeItem = new JMenuItem(name);
			mapModeItem.addActionListener(new MapModeItemListener(frame.getMapModes(), i,frame));
			mapMode.add(mapModeItem);
		}
		this.add(mapMode);
		
	}
	
	private class MapModeItemListener implements ActionListener{
		private MapModes myMapModes;
		private int myMapMode;
		private WorldFrame myFrame;
		
		private MapModeItemListener(MapModes mapModes, int mapMode, WorldFrame frame) {
			myMapModes = mapModes;
			myMapMode = mapMode;
			myFrame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {
			myMapModes.setMapMode(myMapMode);
			myFrame.updateButtons();
		}
		
	}
}
