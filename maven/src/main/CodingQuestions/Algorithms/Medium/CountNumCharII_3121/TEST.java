package main.CodingQuestions.Algorithms.Medium.CountNumCharII_3121;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    public int numberOfSpecialChars(String word) {
        int [] upper = new int [26];
        int [] lower = new int [26];

        Arrays.fill(upper, -1);
        Arrays.fill(lower, -1);
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (Character.isUpperCase(cur)) {
                if (upper[cur - 'A'] == -1) {
                    upper[cur - 'A'] = i;
                }
            } else {
                lower[cur - 'a'] = i;

            }
        }
        int ans = 0;
        for (char i = 0; i < 26; i++) {
            if (upper[i] != -1 && lower[i]!= -1) {
                if (upper[i] > lower[i]) ans++;
            }
        }
        return ans;
    }
    public int numberOfSpecialCharsRefined(String word) {
        int[] upper = new int[26];
        int[] lower = new int[26];

        Arrays.fill(upper, -1);
        Arrays.fill(lower, -1);
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (cur >= 'A' && cur <= 'Z') {
                if (upper[cur - 'A'] == -1) {
                    upper[cur - 'A'] = i;
                }
            } else {
                lower[cur - 'a'] = i;
            }
        }
        int ans = 0;
        for (char i = 0; i < 26; i++) {
            if (upper[i] != -1 && lower[i] != -1) {
                if (upper[i] > lower[i])
                    ans++;
            }
        }
        return ans;
    }
}
