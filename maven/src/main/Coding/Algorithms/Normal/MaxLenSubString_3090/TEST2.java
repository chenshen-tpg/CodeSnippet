package main.Coding.Algorithms.Normal.MaxLenSubString_3090;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int maximumLengthSubstring(String s) {
        int [] memo = new int [26];
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length();i++) {
            char cur = s.charAt(i);
            memo[cur - 'a']++;
            while (memo[cur - 'a'] > 2) {
                memo[s.charAt(left) - 'a']--;
                left++;
            }
            ans = Math.max(ans , i - left + 1);
        }
        return ans;
    }
}
