package main.Coding.Algorithms.Normal.FindCommonChar_1002;

import java.util.*;

public class TEST {


//    Input: words = ["bella","label","roller"]
//    Output: ["e","l","l"]
//    Example 2:

    public static void main(String[] args) {
        TEST test = new TEST();
        test.commonChars(new String [] {"bella","label","roller"});
    }

    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int len = words.length;
        int[][] memo = new int[26][len];
        int section = 0;
        for (String word : words) {
            for (char s : word.toCharArray()) {
                memo[s - 'a'][section]++;
            }
            section++;
        }
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (memo[i][j] > 0) {
                    count++;
                }
            }
            if (count == len) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < len; j++) {
                    min = Math.min(min, memo[i][j]);
                }
                while (min > 0) {
                    ans.add(String.valueOf((char) ('a' + i)));
                    min--;
                }
            }
        }
        return ans;
    }
}
