package org.arif.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        boolean anagram1 = isAnagram1("anagram", "nagaram");
        boolean anagram2 = isAnagram2("anagram", "nagaram");
        System.out.println(anagram);
        System.out.println(anagram1);
        System.out.println(anagram2);
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length()!=t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
