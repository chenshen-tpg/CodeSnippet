package main.Coding.Algorithms.Normal.LongestNiceSub_1763;

/**
 * LeetCode 1763 - Longest Nice Substring
 *
 * Linear approach O(26·n) using sliding window.
 *
 * Key idea:
 *   A "nice" substring needs every letter type it contains to appear in
 *   BOTH upper and lower case.  The number of distinct letter types in
 *   any substring is between 1 and 26.
 *
 *   For each possible count k (1 … 26) we run one sliding-window pass:
 *     - Expand the right pointer, tracking how many unique letter types
 *       are present ("types") and how many of those are "complete"
 *       (have both cases, "complete").
 *     - Shrink the left pointer whenever types > k.
 *     - When types == k AND complete == k the whole window is nice;
 *       record it if it is the longest seen so far.
 *
 *   Total time: O(26 · n)  →  O(n)
 *   Space:      O(1)  (fixed-size arrays of length 26)
 */
public class LinearSol {

    public static void main(String[] args) {
        LinearSol sol = new LinearSol();
        System.out.println(sol.longestNiceSubstring("YazaAay")); // "aAa"
        System.out.println(sol.longestNiceSubstring("Bb"));      // "Bb"
        System.out.println(sol.longestNiceSubstring("c"));       // ""
        System.out.println(sol.longestNiceSubstring("dDzeE"));   // "dDzeE"
    }

    public String longestNiceSubstring(String s) {
        int n = s.length();
        int bestStart = 0, bestLen = 0;
        for (int k = 1; k <= 26; k++) {
            int[] lower = new int[26]; // frequency of lowercase letters a-z
            int[] upper = new int[26]; // frequency of uppercase letters A-Z
            int types    = 0; // distinct letter types currently in window
            int complete = 0; // letter types that have both cases in window
            for (int left = 0, right = 0; right < n; right++) {
                char rc  = s.charAt(right);
                int  idx = Character.toLowerCase(rc) - 'a';
                if (Character.isLowerCase(rc)) {
                    lower[idx]++;
                    if (lower[idx] == 1) {          // first lowercase of this type
                        if (upper[idx] == 0) types++;   // brand-new letter type
                        else                 complete++; // partner already present
                    }
                } else {
                    upper[idx]++;
                    if (upper[idx] == 1) {
                        if (lower[idx] == 0) types++;
                        else                 complete++;
                    }
                }
                while (types > k) {
                    char lc   = s.charAt(left);
                    int  lidx = Character.toLowerCase(lc) - 'a';

                    if (Character.isLowerCase(lc)) {
                        lower[lidx]--;
                        if (lower[lidx] == 0) {
                            if (upper[lidx] == 0) types--;
                            else                  complete--;
                        }
                    } else {
                        upper[lidx]--;
                        if (upper[lidx] == 0) {
                            if (lower[lidx] == 0) types--;
                            else                  complete--;
                        }
                    }
                    left++;
                }

                // ── Check: window is nice when every type is complete ─────
                if (types == k && complete == k) {
                    int len = right - left + 1;
                    if (len > bestLen) {
                        bestLen   = len;
                        bestStart = left;
                    }
                }
            }
        }

        return s.substring(bestStart, bestStart + bestLen);
    }
}

