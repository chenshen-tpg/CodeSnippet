package main.Coding.Algorithms.Medium.LongestPalinDromicSub_5;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.longestPalindrome("badad"));
    }


    public String longestPalindrome(String s) {
        String ans = "";
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (check(temp) && temp.length() > longest) {
                    ans = temp;
                    longest = temp.length();
                }
            }
        }
        return ans;
    }

    public boolean check (String s) {
        int len = s.length();
        if (len == 1) return true;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public boolean check2 (String s) {
        if (s.length() == 1)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
