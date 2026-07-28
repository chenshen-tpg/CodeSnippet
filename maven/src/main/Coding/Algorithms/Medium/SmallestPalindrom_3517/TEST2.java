package main.Coding.Algorithms.Medium.SmallestPalindrom_3517;

import java.util.Arrays;

public class TEST2 {
    public static void main(String[] args) {

    }
    public String smallestPalindrome(String s) {
        int n = s.length(), m = n / 2;
        if (n == 1 || n == 2) return s;
        char[] temp = s.substring(0, m).toCharArray();
        Arrays.sort(temp);
        String first = new String(temp);
        StringBuilder rev = new StringBuilder(first).reverse();
        if (n % 2 == 1) first += s.charAt(m);
        return first + rev;

    }
}
