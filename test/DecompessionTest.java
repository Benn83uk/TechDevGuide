import net.benshouse.techdevguide.Decompression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecompessionTest {
    @Test
    public void testGoogleExamples() {
        assertEquals("abcabcabcababababc", Decompression.decompress("3[abc]4[ab]c"));
        assertEquals("aaaaaaaaaa", Decompression.decompress("10[a]"));
        assertEquals("aaabaaab", Decompression.decompress("2[3[a]b]"));
    }

    @Test
    public void testSimpleDecompression(){
        assertEquals("aaabbb", Decompression.decompress("3[a]3[b]"));
        assertEquals("abababbababa", Decompression.decompress("3[ab]3[ba]"));
        assertEquals("abc", Decompression.decompress("abc"));
        assertEquals("abc", Decompression.decompress("a1[b]c"));

    }

    @Test
    public void testRecursiveDecompression(){
        assertEquals("ab", Decompression.decompress("1[a1[b]]"));
        assertEquals("aaaaaaaaaaaaaaa", Decompression.decompress("1[a1[a1[a1[a1[a1[a1[a1[a1[a1[a1[a1[a1[a1[a1[a]]]]]]]]]]]]]]]"));
    }

    @Test
    public void testEdgeCases(){
        assertEquals("", Decompression.decompress("1[]"));
        assertEquals("", Decompression.decompress("0[abc]"));
    }
}
