package main.Coding.Algorithms.Normal.LongestNice_1763;

public class AI_Solution {
    public String longestNiceSubstring(String s) {
        return helper(s, 0, s.length());
    }

    private String helper(String s, int l, int r) {
        if (r - l < 2) return "";

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) lower[c - 'a'] = true;
            else upper[c - 'A'] = true;
        }

        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            int idx = Character.toLowerCase(c) - 'a';

            // If this char's pair case does not exist, it cannot be in a nice substring crossing i.
            if (!(lower[idx] && upper[idx])) {
                String left = helper(s, l, i);
                String right = helper(s, i + 1, r);
                return left.length() >= right.length() ? left : right;
            }
        }

        // Entire segment is nice.
        return s.substring(l, r);
    }
}
