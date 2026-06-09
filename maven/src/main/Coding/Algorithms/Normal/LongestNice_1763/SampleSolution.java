package main.Coding.Algorithms.Normal.LongestNice_1763;

import java.util.HashSet;

public class SampleSolution {
    public String longestNiceSubstring(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isNice(sub) == true) {
                    if (sub.length() > result.length()) result = sub;
                }
            }
        }

        return result;
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
