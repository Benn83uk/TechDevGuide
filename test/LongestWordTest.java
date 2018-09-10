import net.benshouse.techdevguide.LongestWord;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestWordTest {
    @Test
    public void googleExamples() {
        assertEquals("apple", LongestWord.find("abppplee", Arrays.asList("able", "ale", "apple", "bale", "kangaroo")));
    }

    @Test
    public void testLongestWord(){
        assertEquals("kangaroo", LongestWord.find("kabnpgpaprleeoo", Arrays.asList("able", "ale", "apple", "bale", "kangaroo")));
        assertEquals("able", LongestWord.find("abpleep", Arrays.asList("able", "ale", "apple", "bale", "kangaroo")));
        assertEquals("ale", LongestWord.find("aplebepp", Arrays.asList("able", "ale", "apple", "bale", "kangaroo")));
    }
}
