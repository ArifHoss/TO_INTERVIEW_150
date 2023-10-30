package org.arif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "abb";
        String t = "cdd";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
//        String ramsonNote = "aa";
//        String magazine = "ab";
//        isRamsonNote(ramsonNote, magazine);

    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        List<Integer> sIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sIndex.add(s.indexOf(s.charAt(i)));
        }
        List<Integer> tIndex = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            tIndex.add(t.indexOf(t.charAt(i)));
        }

        return sIndex.equals(tIndex);
    }

    private static boolean isRamsonNote(String ramsonNote, String magazine) {
        int[] charCount = new int[26];

        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        System.out.println(Arrays.toString(charCount));

        for (char c : ramsonNote.toCharArray()) {
            if (--charCount[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}

/*


 */