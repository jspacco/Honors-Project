package worldgen;

public abstract class WorldGen {
	protected int myWidth;
	protected int myHeight;
	protected int[][][] myTileValues;
	
	public WorldGen(int width, int height) {
		myWidth = width;
		myHeight = height;
		myTileValues = new int[myWidth][myHeight][3];
	}
	
	public int[][][] getGenerationValues(){
		return myTileValues;
	}
}
