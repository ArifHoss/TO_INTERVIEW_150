package org.arif.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        boolean happy = isHappy(19);
        int n = 19;
        System.out.println(19%10);
        System.out.println(happy);
    }
    public static boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            int sumOfSquares = 0;
            while (n != 0) {
                int lastDigit = n % 10;
                sumOfSquares += (lastDigit * lastDigit);
                n /= 10;
            }
            n = sumOfSquares;
        }
        return n == 1;
    }

}
 /*

  */