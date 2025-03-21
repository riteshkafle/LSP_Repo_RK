package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * The WordProcessorDriver class demonstrates the usage of the WordProcessor class.
 */
public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1
        WordProcessor wp4 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4);
        
        
        WordProcessor wp = new WordProcessor("Java    is a   powerful tool");
        List<String> longestWords = wp.findLongestWords();
        System.out.println("Longest words: " + longestWords);
       

      
        WordProcessor wp5 = new WordProcessor("A B C D E");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5);
        

        
        WordProcessor wp6 = new WordProcessor("");
        List<String> longestWords6 = wp6.findLongestWords();
        System.out.println("Test 6 - Longest words: " + longestWords6);
        
    }
}