package org.arif.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> substringFromConcatenationWords = findSubstringFromConcatenationWords(s, words);
        System.out.println(substringFromConcatenationWords);

    }
    public static List<Integer> findSubstringFromConcatenationWords(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int totalWord = words.length;
        int totalLength = wordLength * totalWord;

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seen = new HashMap<>();

            for (int j = 0; j < totalWord; j++) {
                int wordStart = i + j * wordLength;
                String word = s.substring(wordStart, wordStart + wordLength);
                if (!wordFrequency.containsKey(word)) {
                    break;
                }
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > wordFrequency.get(word)) {
                    break;
                }
                if (j + 1 == totalWord) {
                    result.add(i);
                }
            }
        System.out.println("seen = " + seen);
        }
        System.out.println("wordFrequency = "+wordFrequency);
        return result;
    }


    public static List<Integer> findSubstring(String sourceString, String[] targetWords) {

        List<Integer> result = new ArrayList<>(); // indices of substrings
        if (sourceString == null || sourceString.length() == 0 || targetWords == null || targetWords.length == 0) {
            return result;
        }

        Map<String, Integer> targetWordFrequencyMap = new HashMap<>(); // Map to store frequency of each target word
        for (String word : targetWords) {
            targetWordFrequencyMap.put(word, targetWordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        int singleWordLength = targetWords[0].length();
        int targetWordsLength = targetWords.length;
        int totalSubstringLength = singleWordLength * targetWordsLength;

        int sourceStringLength = sourceString.length();
        int remainingLength = sourceStringLength - totalSubstringLength;
        for (int sourceStringIndex = 0; sourceStringIndex <= remainingLength; sourceStringIndex++) {

            Map<String, Integer> observedWordFrequencyMap = new HashMap<>(); // Map to store the frequency of words observed within the current window

            for (int targetWordsIndex = 0; targetWordsIndex < targetWordsLength; targetWordsIndex++) {
                int currentWordStart = sourceStringIndex + targetWordsIndex * singleWordLength;
                String currentWord = sourceString.substring(currentWordStart, currentWordStart + singleWordLength);

                if (!targetWordFrequencyMap.containsKey(currentWord)) { // If the word isn't in the target word list, break
                    break;
                }

                observedWordFrequencyMap.put(currentWord, observedWordFrequencyMap.getOrDefault(currentWord, 0) + 1);
                if (observedWordFrequencyMap.get(currentWord) > targetWordFrequencyMap.get(currentWord)) { // If the observed frequency exceeds the target frequency, break
                    break;
                }

                if (targetWordsIndex + 1 == targetWordsLength) { // If all the words are observed the correct number of times.
                    result.add(sourceStringIndex);
                }
            }
        }
        return result;
    }
}
