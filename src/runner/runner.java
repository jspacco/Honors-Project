package runner;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.WorldFrame;
import world.World;

public class runner {

	public static void main(String[] args) {		
		WorldFrame myWorldFrame = new WorldFrame(new World(10,10));
		setFrameSize(myWorldFrame, 4);
		myWorldFrame.setVisible(true);
		myWorldFrame.run();
	}
	
	public static void setFrameSize(JFrame frame, int constant) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
		int width =(int) (screenSize.getWidth() / constant);
		int height =(int) (screenSize.getHeight() / constant);		
		
		frame.setSize(new Dimension(width,height));
	}


}
