package shapes;

import java.util.Random;

public class tRectangle{
	Random myRandom = new Random(Double.doubleToLongBits(Math.random()));
	
	private tPoint bottomLeft;
	private int width;
	private int height;
	
	public tRectangle(int width, int height) {
		this(new tPoint(0,0),width,height);
	}
	
	public tRectangle(int x, int y, int width, int height) {
		this(new tPoint(x,y),width,height);
	}
	
	public tRectangle(tPoint bottomLeft, int width, int height) {
		this.bottomLeft =bottomLeft;
		this.width = width;
		this.height = height;
	}
	
	public tRectangle copy() {
		return new tRectangle(bottomLeft.copy(),width,height);
	}
	
	public tPoint[] getRandomWrappedPoints(tRectangle randWrappedtangle) {
		////System.out.println("randWrappedtangle" + randWrappedtangle);
		int wrapped_x = randWrappedtangle.getX();
		int wrapped_y = randWrappedtangle.getY();
		int wrapped_width = randWrappedtangle.getWidth();
		int wrapped_height = randWrappedtangle.getHeight();
		
		tPoint[] randomWrappedPoints = new tPoint[wrapped_width*wrapped_height];
		int index = 0;
		for(int x = wrapped_x; x < wrapped_width + wrapped_x; x++) {
			for(int y = wrapped_y; y < wrapped_height + wrapped_y; y++) {
				randomWrappedPoints[index] = findWrappedPoint(x,y);
				index++;
			}
		}
		
		return randomWrappedPoints;
	}
	
	public tRectangle createRandWrappedtangle() {
		int x = myRandom.nextInt(width);
		int y = myRandom.nextInt(height);
		int corner = myRandom.nextInt(4);	
		
		int _width = myRandom.nextInt(width - 1);
		int _height = myRandom.nextInt(height - 1);

		if(corner == 2 || corner == 1)			
			x = x -_width;
		if(corner == 2 || corner == 3)
			y = y - _height;
		
		return new tRectangle(x,y,_width,_height);
	}
	
	public tPoint findWrappedPoint(tPoint point) {
		return findWrappedPoint((int)point.getX(),(int)point.getY());
	}
	
	public tPoint findWrappedPoint(int x, int y) {
		
		int _x = wrapHelp(x, width);
		int _y = wrapHelp(y, height);
		
		//if( 0 > _x || 0 > _y|| _x >= width || _y >= height) 
			//System.out.println(new tPoint(x,y) + " => " + new tPoint(_x,_y));
		return new tPoint(_x,_y);
	}
	
	private static int wrapHelp(int a, int max) {
		boolean pos = 0 <= a;
		boolean inrange = a < max;
		
		////System.out.println("\t" + a + " pos " + pos + " inrange " + inrange);
		
		if(pos && inrange) {
			return a;
		}
		int value = 0;
		if(!pos) {
			int diffrence = 0 - a;
			diffrence=diffrence%max;
			value = max - diffrence;
		}
		if(!inrange) {
			int diffrence = max - a;
			////System.out.print(max + "-" + a + "=" + diffrence + ", " + diffrence);
			diffrence=diffrence%max;
			////System.out.println("%" + max + "=" + diffrence%max);
			value = diffrence;
			////System.out.println();
		}
		
		return wrapHelp(value, max);
		
	}
	
	public tPoint getBottomLeft() {
		return bottomLeft;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return bottomLeft.getX();
	}
	
	public int getY() {
		return bottomLeft.getY();
	}
	
	public String toString() {
		return bottomLeft + ", w" + width + ", h" + height;
	}
	
}
