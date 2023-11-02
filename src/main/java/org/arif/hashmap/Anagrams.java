package org.arif.hashmap;

import java.util.HashSet;
import java.util.Set;

public class Anagrams {
    public static void main(String[] args) {
        String input = "abc";
        Set<String> anagram = generateAnagram(input);
        System.out.println(anagram);
    }

    public static Set<String> generateAnagram(String input) {
        Set<String> anagrams = new HashSet<>();
        anagramsGenerator("", input, anagrams);
        return anagrams;
    }

    private static void anagramsGenerator(String prefix, String input, Set<String> anagrams) {
        if (input.length() == 0) {
            anagrams.add(prefix);
        }
        for (int i = 0; i < input.length(); i++) {
            String newPrefix = prefix + input.charAt(i);
            String newInput = input.substring(0, i) + input.substring(i + 1);
            anagramsGenerator(newPrefix, newInput, anagrams);
        }
    }
}

/**
 * First Iteration of anagramsGenerator:
 * prefix: ""
 * input: "ab"
 * anagrams: Empty Set
 * The function now enters a loop iterating through each character in "ab".
 *
 * First Loop (i = 0):
 *
 * newPrefix: "a" (prefix + "a")
 * newRemaining: "b" ("ab" without the 0th character, "a")
 * Recursive Call: anagramsGenerator("a", "b", anagrams)
 * Inside this Recursive Call:
 * prefix: "a"
 * input: "b"
 * anagrams: Empty Set
 * Again, we loop through each character in "b".
 *
 * First (and only) Loop (i = 0):
 * newPrefix: "ab" ("a" + "b")
 * newRemaining: "" ("b" without the 0th character, "b")
 * Recursive Call: anagramsGenerator("ab", "", anagrams)
 * ####### Inside this Recursive Call:
 *
 * prefix: "ab"
 * input: ""
 * Since input is empty, "ab" is added to the anagrams set.
 * Back to the first call of anagramsGenerator("", "ab", anagrams), the loop continues.
 *
 * Second Loop (i = 1):
 *
 * newPrefix: "b" (prefix + "b")
 * newRemaining: "a" ("ab" without the 1st character, "b")
 * Recursive Call: anagramsGenerator("b", "a", anagrams)
 * Inside this Recursive Call:
 * prefix: "b"
 * input: "a"
 * First (and only) Loop (i = 0):
 * newPrefix: "ba" ("b" + "a")
 * newRemaining: "" ("a" without the 0th character, "a")
 * Recursive Call: anagramsGenerator("ba", "", anagrams)
 * ####### Inside this Recursive Call:
 *
 * prefix: "ba"
 * input: ""
 * Since input is empty, "ba" is added to the anagrams set.
 * After this recursive process completes, the anagrams set contains {"ab", "ba"}. The
 * iteration ends here, and the set containing all the anagrams of "ab" is returned.
 */