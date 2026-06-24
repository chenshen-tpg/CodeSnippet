package main.Coding.Algorithms.Medium.LongestPalinDromicSub_5;

public class SampleSolution {
    public static void main(String[] args) {

    }


    public String longestPalindrome(String s) {
        int start = 0, maxLen = 1;
        for (int center = 0; center < s.length(); center++) {
            // Odd length: "aba"
            int len1 = expand(s, center, center);
            // Even length: "abba"
            int len2 = expand(s, center, center + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = center - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
