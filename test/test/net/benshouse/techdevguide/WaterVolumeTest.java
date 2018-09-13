package test.net.benshouse.techdevguide;

import net.benshouse.techdevguide.WaterVolume;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WaterVolumeTest {
    @Test
    public void googleExample(){
        WaterVolume wv = new WaterVolume(new int[]{1,3,2,4,1,3,1,4,5,2,2,1,4,2,2});
        assertEquals(15, wv.totalLakeVolume());
    }

    @Test
    public void testSmallSingleLake(){
        WaterVolume wv = new WaterVolume(new int[]{1,0,1});
        assertEquals(1, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{1,0, 0,1});
        assertEquals(2, wv.totalLakeVolume());
    }

    @Test
    public void testLargerLakes(){
        WaterVolume wv = new WaterVolume(new int[]{2,0,2});
        assertEquals(2, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{2,0,0,2});
        assertEquals(4, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{3,0,0, 0,3});
        assertEquals(9, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{3,0,0,3});
        assertEquals(6, wv.totalLakeVolume());
    }

    @Test
    public void testSmallMultipleLakes(){
        WaterVolume wv = new WaterVolume(new int[]{1,0,1,0,1});
        assertEquals(2, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{1,0, 0,1,0,1});
        assertEquals(3, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{1,0,1,1,0,1});
        assertEquals(2, wv.totalLakeVolume());
    }

    @Test
    public void testUnequalLakes(){
        WaterVolume wv = new WaterVolume(new int[]{1,0,2});
        assertEquals(1, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{2,0,1});
        assertEquals(1, wv.totalLakeVolume());
    }

    @Test
    public void upStart(){
        WaterVolume wv = new WaterVolume(new int[]{1,2,0,2});
        assertEquals(2, wv.totalLakeVolume());
    }

    @Test
    public void downStart(){
        WaterVolume wv = new WaterVolume(new int[]{2,1,0,2});
        assertEquals(3, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{2,1,0,1});
        assertEquals(1, wv.totalLakeVolume());
    }

    @Test
    public void testInvalidLakes(){
        WaterVolume wv = new WaterVolume(new int[]{});
        assertEquals(0, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{1,1});
        assertEquals(0, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{1,1,1});
        assertEquals(0, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{2,1});
        assertEquals(0, wv.totalLakeVolume());

        wv = new WaterVolume(new int[]{2,2,1});
        assertEquals(0, wv.totalLakeVolume());
    }
}
