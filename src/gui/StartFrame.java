package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import runner.runner;
import tile.TileGrid;
import world.World;

public class StartFrame extends JFrame{

	public StartFrame() {
		super();
		JPanel panel = new JPanel();
		
		JButton button00 = new JButton();
		button00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TileGrid.launchSettings = 0;
				create();
			}
		});
		panel.add(button00);
		
		JButton button01 = new JButton();
		button01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TileGrid.launchSettings = 1;
				create();				
			}
		});
		panel.add(button01);
		
		this.add(panel);
	}
	
	public void create() {
		WorldFrame myWorldFrame = new WorldFrame(new World(50,50));
		runner.setFrameSize(myWorldFrame, 2);
		myWorldFrame.setVisible(true);
		myWorldFrame.run();
	}
}
