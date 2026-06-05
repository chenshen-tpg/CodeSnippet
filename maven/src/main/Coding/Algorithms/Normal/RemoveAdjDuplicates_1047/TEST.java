package main.Coding.Algorithms.Normal.RemoveAdjDuplicates_1047;

public class TEST {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int [] memo = new int [26];
        for (int i = 0; i <len; i++) {
            char cur = s.charAt(i);
            memo[cur - 'a']++;
            if (memo[cur - 'a'] > 1) {
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == cur) {
                        sb.deleteCharAt(j);
                    }
                }
                memo[cur - 'a'] -= 2;
            } else {
                sb.append(cur);
            }
        }
        return sb.toString();
    }
    public String CorrectRemoveDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = sb.length();
            if (n > 0 && sb.charAt(n - 1) == c) {
                sb.deleteCharAt(n - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
