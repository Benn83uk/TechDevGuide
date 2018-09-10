package net.benshouse.techdevguide;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ben Noble
 * @since 2018-09-10
 * Code challenge from https://techdevguide.withgoogle.com/paths/advanced/compress-decompression/#code-challenge
 */
public class Decompression {
    private static final Pattern PATTERN= Pattern.compile("(?<num>\\d+)\\[(?<letters>[a-z]*)\\]");

    /**
     * Decompresses a compressed String.
     * Example "3[abc]4[ab]c" => "abcabcabcababababc"
     * @param input String of format number[string]
     * @return [string] written [number] times.
     */
    public static String decompress(String input){
        String result = input;
        Matcher matcher = PATTERN.matcher(result);
        while (matcher.find()){
            String found = matcher.group();
            String num = matcher.group("num");
            String letters = matcher.group("letters");
            int number = Integer.parseInt(num);
            result = result.replace(found, expand(letters, number));
            matcher = PATTERN.matcher(result);
        }
        return result;
    }

    private static String expand(String input, int repeat){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeat; i++){
            result.append(input);
        }
        return result.toString();
    }
}
