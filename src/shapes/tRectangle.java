package shapes;

public class tRectangle{
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
	
	public tPoint findWrappedPoint(tPoint point) {
		return findWrappedPoint((int)point.getX(),(int)point.getY());
	}
	
	public tPoint findWrappedPoint(int x, int y) {
		
		x = wrapHelp(x, width);
		y = wrapHelp(y, height);
		return new tPoint(x,y);
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
		
		return value - 1;
		
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
	
}
