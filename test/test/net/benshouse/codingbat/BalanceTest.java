package test.net.benshouse.codingbat;

import net.benshouse.codingbat.Balance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BalanceTest {
    @Test
    public void testExamples(){
        assertTrue(Balance.canBalance(new int[] {1, 1, 1, 2, 1}));
        assertFalse(Balance.canBalance(new int[] {2, 1, 1, 2, 1}));
        assertTrue(Balance.canBalance(new int[] {10,10}));
    }

    @Test
    public void smallArray(){
        assertFalse(Balance.canBalance(new int[]{10}));
        assertTrue(Balance.canBalance(new int[]{}));
    }

    @Test
    public void simpleExamples(){
        assertTrue(Balance.canBalance(new int[]{1,1}));
        assertTrue(Balance.canBalance(new int[]{1,0,1}));
        assertTrue(Balance.canBalance(new int[]{1,0,0,1}));
    }
}
