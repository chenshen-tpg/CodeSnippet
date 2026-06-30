package main.Coding.Algorithms.Medium.NumberOfSubStringContainingAllThreeCharacter_1358;

public class TEST {

    public static void main(String[] args) {
        String s = "abcabc";
        TEST test = new TEST();
        test.numberOfSubstrings(s);
    }

//        [0,2] = "abc"
//        [0,3] = "abca"
//        [0,4] = "abcab"
//        [0,5] = "abcabc"

    public int numberOfSubstrings(String s) {
        int [] memo = new int [3];
        int ans = 0, j = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            memo[c - 'a']++;
            while (memo[0] > 0 && memo[1] > 0 && memo[2] > 0) {
                ans += len - i;
                memo[s.charAt(j++) - 'a']--;
            }
        }
        return ans;
    }
}
