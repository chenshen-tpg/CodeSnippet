package main.Coding.Algorithms.Normal.LongestNice_1763;

import java.util.HashSet;

public class SeparateFunctionTest {
    public static void main(String[] args) {
        SeparateFunctionTest test = new SeparateFunctionTest();
        test.isNice("AbAbaaB");
    }

    public boolean isNice(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c)))) {
                return false;
            }
        }

        return true;
    }
}
