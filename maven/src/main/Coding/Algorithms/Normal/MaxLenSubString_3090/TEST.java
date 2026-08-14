package main.Coding.Algorithms.Normal.MaxLenSubString_3090;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {

    }
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
            while (hm.get(cur) > 2) {
                char left = s.charAt(j);
                hm.put(left, hm.get(left) - 1);
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
