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
	
	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        tPoint other = (tPoint) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
	
	
	public tPoint copy() {
		return new tPoint(x,y);
	}
	
	public String toString() {
		return x +", " + y;
	}
}
