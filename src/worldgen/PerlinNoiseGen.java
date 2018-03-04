package worldgen;
import org.j3d.texture.procedural.PerlinNoiseGenerator;

/* 
PerlinNoiseGenerator from:

http://code.j3d.org/javadoc/org/j3d/texture/procedural/PerlinNoiseGenerator.html
 */

public class PerlinNoiseGen extends WorldGen{

	public PerlinNoiseGen(int width, int height) {
		super(width, height);		
		for(int z = 0; z < 3; z++) {
			PerlinNoiseGenerator PerlinNoise = new PerlinNoiseGenerator((int) Math.random());
			
			for(int x = 0; x < width;x++) {
				for(int y = 0; y < height; y++) {
					double noise = PerlinNoise.tileableNoise2(x, y,myWidth,myHeight);
					myTileValues[x][y][z] = (int)  noise;
					System.out.println(x + ", " + y + ": " + noise + " ("+myTileValues[x][y][z] + ")");
				}
			}
		}
				
	}
}
