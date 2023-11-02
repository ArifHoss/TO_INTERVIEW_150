package org.arif.hashmap;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagramList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
//                System.out.println(map);
            }
            map.get(sortedString).add(s);
        }
        anagramList.addAll(map.values());
        System.out.println("map.values() = "+map.values());
        System.out.println("result = "+anagramList);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        result.addAll(map.values());
        return result;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> groupAnagramList = new ArrayList<>();
        for (String word : strs) {
            boolean foundAnagramGroup = false;

            for (List<String> group : groupAnagramList) {
                if (isAnagram(word, group.get(0))) {
                    group.add(word);
                    foundAnagramGroup = true;
                    break;
                }
            }
            if (!foundAnagramGroup) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(word);
                groupAnagramList.add(newGroup);
            }
        }
        return groupAnagramList;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
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
}
