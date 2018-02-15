package datastructures;

public class tRectangle {
	private int myWidth;
	private int myHeight;
	
	public tRectangle(int width, int height) {
		myWidth = width;
		myHeight = height;
	}
}


/*
public class tRectangle {
	private tPoint myBottomLeft;
	private int myWidth;
	private int myHeight;
	private tPoint[][] myPointArray;
	
	public tRectangle(int width, int height) {
		this(new tPoint(0,0), width, height);
	}
	
	public tRectangle(tPoint point, int width, int height) {
		myBottomLeft = point;
		myWidth = width;
		myHeight = height;
		myPointArray  = new tPoint[myWidth][myHeight]; 
		for(int x = 0; x < myWidth; x++) {
			for(int y = 0; y < myHeight; y++) {
				myPointArray[x][y] = new tPoint(x,y);
			}
		}
	}
	
	public tRectangle(tPoint point, int width, int height, tPoint[][] pointArray) {
		myBottomLeft = point;
		myWidth = width;
		myHeight = height;
		myPointArray = pointArray;
	}
	
	public tPoint[][] getArray() {
		return myPointArray;
	}
	
	public tPoint getPoint(int x, int y) throws IllegalArgumentException{
		return findWrappedPoint(x,y,myHeight, myWidth);
	}
	
	public tPoint getBottomLeftPoint() {
		return myBottomLeft;
	}
	
	public int getWidth() {
		return myWidth;
	}
	
	public int getHeight() {
		return myHeight;
	}
	
	public boolean equals(Object other) {
		if(other instanceof tRectangle ) {
			tRectangle otherRectangle = (tRectangle) other;
			if(myBottomLeft.equals(otherRectangle.getBottomLeftPoint()) && otherRectangle.getHeight() == myHeight && otherRectangle.getWidth() == myWidth) {
				return true;
			}
			
		}
		return false;
	}
	
	private static tPoint findWrappedPoint(int x, int y, int width, int height) {
		
		int x1 = wrapHelp(x, width);
		int y1 = wrapHelp(y, height);
		return new tPoint(x1,y1);
	}
	
	private static int wrapHelp(int a, int max) {
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
		//else can't happen
		
		return value - 1;
		
	}
}
*/