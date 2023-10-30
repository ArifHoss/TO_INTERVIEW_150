package org.arif.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "baa";
        String t = "abb";
        String s1 = "abcabc";
        String t1 = "abcdef";
        for (int i = 0; i < s1.length(); i++) {
        System.out.println("s1.indexOf() = "+s1.indexOf(s1.charAt(i)));
        }
        boolean isomorphic = isIsomorphic(s, t);
        boolean isomorphic1 = isIsomorphic1(s1, t1);
//        System.out.println(isomorphic);
        System.out.println(isomorphic1);

    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        List<Integer> sShadow = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sShadow.add(s.indexOf(s.charAt(i)));
        }
        List<Integer> tShadow = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            tShadow.add(t.indexOf(t.charAt(i)));
        }
        return sShadow.equals(tShadow);
    }
    public static boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        System.out.println(map);
        return true;
    }
    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        return transformString(s).equals(transformString(t));
    }
    private static List<Integer> transformString(String string) {
        List<Integer> transformation = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            transformation.add(string.indexOf(string.charAt(i)));
        }
        System.out.println(transformation);

        return transformation;
    }
}
