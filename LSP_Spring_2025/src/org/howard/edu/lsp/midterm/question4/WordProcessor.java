package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and returns all the longest words.
 * It assumes that the input does not include punctuation.
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructs a WordProcessor with the given sentence.
     * 
     * @param sentence the sentence to process.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all words with the maximum length in the order they appear in the sentence.
     * It handles varying amounts of whitespace between words.
     * If the input is empty or contains no words, it returns an empty list.
     *
     * @return a List of Strings containing the longest words.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        
        // Check for null or empty input
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }
        
        // Split the sentence by one or more whitespace characters.
        String[] words = sentence.split("\\s+");
        int maxLength = 0;
        
        // Determine the maximum word length.
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        
        // Collect all words with the maximum length in the order they appear.
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        
        return longestWords;
    }
}