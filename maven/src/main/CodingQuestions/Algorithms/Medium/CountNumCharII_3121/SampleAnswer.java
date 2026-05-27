package main.CodingQuestions.Algorithms.Medium.CountNumCharII_3121;

import java.util.HashMap;

public class SampleAnswer {
    public static void main(String[] args) {

    }
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> lastLower = new HashMap<>();
        HashMap<Character, Integer> firstUpper = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastLower.put(c, i);
            } else {
                firstUpper.putIfAbsent(c, i);
            }
        }
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            char upper = Character.toUpperCase(c);
            if (lastLower.containsKey(c) && firstUpper.containsKey(upper)) {
                if (lastLower.get(c) < firstUpper.get(upper)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
