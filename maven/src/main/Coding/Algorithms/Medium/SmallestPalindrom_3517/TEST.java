package main.Coding.Algorithms.Medium.SmallestPalindrom_3517;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.smallestPalindrome("daccad");
    }
    public String smallestPalindrome(String s) {
        int [] memo = new int [26];
        int len = s.length();
        for (char cur : s.toCharArray()) {
            memo[cur - 'a'] ++;
        }
        char [] ans = new char[len];
        int left = 0, right = len - 1;

        for (int i = 0; i < 26; i++) {
            while (memo[i] >= 2) {
                char c = (char) ('a' + i);
                ans[left++] = c;
                ans[right--] = c;
                memo[i] -= 2;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (memo[i] == 1) {
                ans[left] = (char) ('a' + i);
                break;
            }
        }
        return new String(ans);
    }
}
