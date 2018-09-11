import net.benshouse.techdevguide.Minesweeper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest {
    private int countBombs(boolean[][] field){
        int count = 0;
        for (int x = 0; x < field.length; x++){
            for (int y = 0; y < field[x].length; y++){
                if (field[x][y]) count++;
            }
        }
        return count;
    }

    private void assertArraysAreEqual(int[][] expected, int[][] actual){
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++){
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    private boolean arraysAreEqual(boolean[][] expected, boolean[][] actual){
        if (expected.length != actual.length) return false;
        for (int i = 0; i < expected.length; i++){
            if (!Arrays.equals(expected[i], actual[i])) return false;
        }
        return true;
    }

    @Test
    public void googleExample(){
        assertEquals(9999, countBombs(new Minesweeper(100,100,9999).getCells()));
    }

    @Test
    public void testMax(){
        assertEquals(100, countBombs(new Minesweeper(10,10,100).getCells()));
        assertThrows(IllegalArgumentException.class, () -> new Minesweeper(10,10,101));
    }

    @Test
    public void testMin(){
        assertEquals(0, countBombs(new Minesweeper(10,10,0).getCells()));
    }

    @Test
    public void testSmallMap(){
        int[][] expected = new int[][]{
                {0,0},
                {0,0}
        };
        assertArraysAreEqual(expected, new Minesweeper(2,2,0).getMap());

        expected = new int[][]{
                {9,9},
                {9,9}
        };
        assertArraysAreEqual(expected, new Minesweeper(2,2,4).getMap());

        expected = new int[][]{
                {1,0},
                {9,1}
        };
        Minesweeper actual = new Minesweeper(2,2,1, new Random(10L));
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {1,9},
                {0,1}
        };
        actual = new Minesweeper(2,2,1, new Random(1L));
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {2,9},
                {9,2}
        };
        actual = new Minesweeper(2,2,2, new Random(1L));
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {1,1},
                {9,9}
        };
        actual = new Minesweeper(2,2,2, new Random(100L));
        actual.printCells();
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {9,2},
                {9,9}
        };
        actual = new Minesweeper(2,2,3, new Random(100L));
        actual.printCells();
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {9,9},
                {9,9}
        };
        actual = new Minesweeper(2,2,4, new Random(100L));
        actual.printCells();
        assertArraysAreEqual(expected, actual.getMap());
    }

    @Test
    public void test9By9Map(){
        int[][] expected = new int[][]{
                {0,2,9},
                {2,9,2},
                {9,2,0}
        };
        Minesweeper actual = new Minesweeper(3,3,3, new Random(10L));
        actual.printCells();
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {1,9,2},
                {1,9,9},
                {0,1,1}
        };
        actual = new Minesweeper(3,3,3, new Random(1L));
        actual.printCells();
        assertArraysAreEqual(expected, actual.getMap());

        expected = new int[][]{
                {2,9,2},
                {9,4,9},
                {2,9,2}
        };
        actual = new Minesweeper(3,3,4, new Random(106L));
        actual.printCells();
        assertArraysAreEqual(expected, actual.getMap());
    }

    /**
     * Want to know that if we generate new Minesweepers, they should usually be different.
     */
    @Test
    public void testRandomness(){
        boolean diff = false;
        Minesweeper previous = new Minesweeper(2,2,1);
        for (int i = 0; i < 10; i++){
            Minesweeper mines = new Minesweeper(2,2,1);
            if (!arraysAreEqual(previous.getCells(), mines.getCells())){
                diff = true;
                break;
            }
        }
        assertTrue(diff, "All generated maps were the same");
    }

    /**
     * Not really a test, but a brute force method for finding a Seed which will generate a given map
     * NOTE: This only runs through a limited number of iterations. If you're looking for a large
     *       map, this might not be enough iterations!
     */
    @Test
    public void findSeedForExpected(){
        final int ITERATIONS = 1000;
        boolean[][] expected = new boolean[][]{
                {false,true,false},
                {true,false,true},
                {false,true,false}
        };

        boolean found = false;
        for (int i = 0; i < ITERATIONS; i++){
            Minesweeper mines = new Minesweeper(3,3,4, new Random(i));
            if (arraysAreEqual(expected, mines.getCells())){
                found = true;
                System.out.println("Found with seed: " + i);
                break;
            }
        }
        assertTrue(found, "Did not find a seed for the given map");
    }
}
