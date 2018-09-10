package net.benshouse.techdevguide;

import java.util.HashMap;
import java.util.List;

/**
 * @author Ben Noble
 * @since 2018-09-10
 * Code challenge from https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string/#!
 */
public class LongestWord {
    /**
     * Find the longest word from the dictionary which appears in order in the input.
     * @param input String to search
     * @param words Words to find in the given string
     * @return Longest word found
     */
    public static String find(String input, List<String> words){
        HashMap<String, Integer> scores = new HashMap<>();
        String currentWinner = "";

        //Calculate scores O(N * W)
        for (int i = 0; i < input.length(); i++){
            Character currentChar = input.charAt(i);
            for (String word : words){
                Integer currentScore = scores.keySet().contains(word) ? scores.get(word) : 0;
                if (word.length() > currentScore && word.charAt(currentScore) == currentChar){
                    scores.put(word, ++currentScore);
                }

                if (word.length() == currentScore && word.length() > currentWinner.length()){
                    currentWinner = word;
                }
            }
        }

        return currentWinner;
    }
}
