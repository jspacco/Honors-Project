package runner;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class testgridconvertion {
	
	public static void main(String[] args) {
		int temp = 1;
		
		int width = 25;
		int height = width;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(width,height));
				
		for(int x = 0; x < width;x++) {
			for(int y = 0; y < height; y++) {
				int x1 = converter(x-(2*width*temp),width);
				int y1 = converter(y-(2*height*temp), height);
				
				JButton temp1 = new JButton("(" +  x1 + ", " + y1 + ")");
				frame.add(temp1);
			}
		}

		setFrameSize(frame, 4);
		frame.setVisible(true);
	}
	
	public static int wrapHelp(int a, int max) {
		boolean pos = 0 <= a;
		boolean inrange = a < max;
		
		if(pos && inrange) {
			return a;
		}
		int value = 0;
		if(!pos) {
			int diffrence = 0 - a;
			diffrence=diffrence%max;
			value = max - diffrence;
		}
		else if(!inrange) {
			int diffrence = max - a;
			diffrence=diffrence%max;
			value = diffrence;
		}
		
		return value - 1;
		
	}
	
	public static void setFrameSize(JFrame frame, int constant) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
		int width =(int) (screenSize.getWidth() / constant);
		int height =(int) (screenSize.getHeight() / constant);		
		
		frame.setSize(new Dimension(width,height));
	}
	
	public static int converter(int a, int max) {
		boolean pos = 0 <= a;
		boolean inrange = a < max;
		
		if(pos && inrange) {
			return a;
		}
		int value = 0;
		if(!pos) {
			int diffrence = 0 - a;
			diffrence=diffrence%max;
			value = max - diffrence;
		}
		else if(!inrange) {
			int diffrence = max - a;
			diffrence=diffrence%max;
			value = diffrence;
		}
		
		return value - 1;
		
	}
	


}
