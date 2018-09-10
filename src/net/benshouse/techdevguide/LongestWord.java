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
     * @param dictionary Words to find in the given string
     * @return Longest word found
     */
    public static String find(String input, List<String> dictionary){
        //Populate initial scores - O(d)
        HashMap<String, Integer> scores = new HashMap<>();
        for (String s : dictionary){
            scores.put(s, 0);
        }

        //Calculate scores O(n) * O(d)
        for (int i = 0; i < input.length(); i++){
            Character currentChar = input.charAt(i);
            for (String word : scores.keySet()){
                Integer currentScore = scores.get(word);
                if (word.length() > currentScore && word.charAt(currentScore) == currentChar){
                    scores.replace(word, ++currentScore);
                }
            }
        }

        //Find winner O(d)
        String currentWinner = "";
        for (String word : scores.keySet()){
            Integer finalScore = scores.get(word);
            if (word.length() == finalScore && word.length() > currentWinner.length()){
                currentWinner = word;
            }
        }

        return currentWinner;
    }
}
