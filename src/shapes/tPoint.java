package shapes;

public class tPoint {
	private int x;
	private int y;
	
	public tPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int manhattenDistance(tPoint other) {
		return Math.abs(x - other.getX()) + Math.abs(y - other.getY());
	}
	
	public double getDistance(tPoint other) {
		return Math.sqrt( Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2));
	}
	
	public boolean equals(Object other) {
		if(other instanceof tPoint) {
			tPoint otherPoint = (tPoint) other;
			if(otherPoint.getX() == x && otherPoint.getY() == y) {
				return true;
			}
		}		
		return false;
	}
	
	public tPoint copy() {
		return new tPoint(x,y);
	}
}
