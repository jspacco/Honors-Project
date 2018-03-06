package worldgen;
import java.util.Random;

import org.j3d.texture.procedural.PerlinNoiseGenerator;

/* 
PerlinNoiseGenerator from:

http://code.j3d.org/javadoc/org/j3d/texture/procedural/PerlinNoiseGenerator.html
 */

public class PerlinNoiseGen extends WorldGen{

	public PerlinNoiseGen(int width, int height) {
		super(width, height);
		Random rand = new Random();
		
		for(int z = 0; z < 3; z++) {
			int seed = rand.nextInt(Integer.MAX_VALUE);
			System.out.println("seed: " + seed);
			PerlinNoiseGenerator PerlinNoise = new PerlinNoiseGenerator(seed);
			/*
			long time = System.currentTimeMillis();			
			int length = (int)(Math.log10(time)+1);
			String timestr = String.valueOf(time).substring(length-2, length);			
			int seed = Integer.parseInt(timestr);
			
			seed = seed * 10000; 
			
			System.out.println(seed + " (" + time + ")");
			
			//seed doesn't apear to affect it at all
			PerlinNoiseGenerator PerlinNoise = new PerlinNoiseGenerator(seed);
			*/
			for(int x = 0; x < width;x++) {
				for(int y = 0; y < height; y++) {
					float _x = mapValues(x,width,1.0f);
					float _y = mapValues(y,height,1.0f);
										
					double noise = PerlinNoise.tileableNoise2(_x, _y,1.0f,1.0f);
					
					int _n =  (int) mapValues((float)noise,1f,100f);
					_n += 13;
					_n = (int) mapValues((float)_n,26f,100f);
					
					myTileValues[x][y][z] = _n;
					//System.out.println(x + ", " + y +"(" +_x + "/1.0, " + _y +"/1.0)"+ ": " + noise + " ("+myTileValues[x][y][z] + ")");
					//System.out.println(myTileValues[x][y][z]);
				}
			}
		}
				
	}
	
	//   h  ?
	//   - = -
	//   b  b2
	private static float mapValues(float h, float b,float b2) {		
		return (h*b2)/b;
	}
	/*
	public static void main(String[] args) {
		int min = 9000;
		int max = -min;
		
		WorldGen gen = new PerlinNoiseGen(1000,1000);
		int[][][] values = gen.getGenerationValues();
		for(int x = 0; x < values.length; x++) {
			for(int y = 0; y < values[x].length;y++) {
				int value = values[x][y][0];
				if(min > value)
					min = value;
				if(max < value)
					max = value;
				//System.out.printf("%-3d ",value);
			}
			//System.out.println("");
		}
		
		System.out.println("min: " + min + ", max: " + max);
	}
	*/
	
}
