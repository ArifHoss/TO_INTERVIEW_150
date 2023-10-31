package org.arif.hashmap;

import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        boolean wordPattern = wordPattern("abba", "dog cat cat dog");
        boolean wordPattern1 = wordPattern("abba", "dog cat cat fish");
        boolean wordPattern2 = wordPattern("aaaa", "dog cat cat dog");
        System.out.println(wordPattern);
        System.out.println(wordPattern1);
        System.out.println(wordPattern2);
    }
    public static boolean wordPattern(String pattern, String s) {

        String[] splitedString = s.split(" ");


        if (splitedString.length != pattern.length()) return false;


        List<Integer> patternList = new ArrayList<>();
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!patternMap.containsKey(c)) {
                patternMap.put(c, i);
            }
            patternList.add(patternMap.get(c));
        }

        List<Integer> stringList = new ArrayList<>();
        Map<String , Integer> stringMap = new HashMap<>();
        for (int i = 0; i < splitedString.length; i++) {
            String word = splitedString[i];
            if (!stringMap.containsKey(word)) {
                stringMap.put(word, i);
            }
            stringList.add(stringMap.get(word));
        }
        return patternList.equals(stringList);
    }
}
