package datastructures;

public class tPoint {
	private int myX;
	private int myY;
	
	public tPoint(int x, int y) {
		myX = x;
		myY = y;
	}
	
	public int manhattenDistance(tPoint other) {
		return Math.abs(myX - other.getX()) + Math.abs(myY - other.getY());
	}
	
	public double getDistance(tPoint other) {
		return Math.sqrt( Math.pow(myX - other.getX(), 2) + Math.pow(myY - other.getY(), 2));
	}
	
	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
	
	public boolean equals(Object other) {
		if(other instanceof tPoint) {
			tPoint otherPoint = (tPoint) other;
			if(otherPoint.getX() == myX && otherPoint.getY() == myY) {
				return true;
			}
		}		
		return false;
	}
}
