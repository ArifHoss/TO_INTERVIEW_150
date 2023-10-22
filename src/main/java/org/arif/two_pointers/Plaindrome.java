package org.arif.two_pointers;

public class Plaindrome {
    public static void main(String[] args) {
        Plaindrome plaindrome = new Plaindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean isPlain = plaindrome.isPlaindrome(s);
        System.out.println(isPlain);
    }
    public boolean isPlaindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(newString);

        String reversedString = sb.reverse().toString();
        return newString.equals(reversedString);
    }
}
