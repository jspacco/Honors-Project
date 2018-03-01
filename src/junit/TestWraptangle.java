package junit;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import shapes.tPoint;
import shapes.tRectangle;

public class TestWraptangle
{

    @Test
    public void testWraptangleNoWrapping() {
        tRectangle rect = new tRectangle(10,10);
        int x=2;
        int y=3;
        int w=2;
        int h=2;
        
        tRectangle result = rect.createWrappedtangle(x, y, w, h, 0);
        Set<tPoint> correct = new HashSet<tPoint>();
        for (int i=x; i<x+w; i++){
            for (int j=y; j<y+h; j++){
                correct.add(new tPoint(i, j));
            }
        }
        tPoint[] points = rect.getRandomWrappedPoints(result);
        for (tPoint t : points){
            assertTrue(correct.contains(t));
        }
    }
    
    @Test
    public void testWraptangleWrapRight(){
        tRectangle rect = new tRectangle(10,10);
        int x=8;
        int y=3;
        int w=4;
        int h=4;
        // TODO: make this wrap around for X but not for Y
        tRectangle result = rect.createWrappedtangle(x, y, w, h, 0);
        Set<tPoint> correct = new HashSet<tPoint>();
        for (int i=x; i<x+w; i++){
            for (int j=y; j<y+h; j++){
                correct.add(new tPoint(i, j));
            }
        }
        tPoint[] points = rect.getRandomWrappedPoints(result);
        for (tPoint t : points){
            assertTrue(correct.contains(t));
        }
    }

}
