package runner;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.StartFrame;
import gui.WorldFrame;
import world.World;

public class runner {

	public static void main(String[] args) {
		WorldFrame myWorldFrame = new WorldFrame(new World(20,20));
		runner.setFrameSize(myWorldFrame, 2);
		myWorldFrame.setVisible(true);
	}
	
	public static void setFrameSize(JFrame frame, int constant) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
		int width =(int) (screenSize.getWidth() / constant);
		int height =(int) (screenSize.getHeight() / constant);		
		
		frame.setSize(new Dimension(width,height));
	}


}
