package main.Coding.Algorithms.Medium.LongSubNoRepeat_3;

import java.util.HashSet;
import java.util.Set;

public class TEST {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int ans = 0;
        int curLong = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            while (hs.contains(cur)) {
                hs.remove(s.charAt(j++));
                curLong--;
            }
            hs.add(cur);
            curLong++;
            ans = Math.max(ans, curLong);
        }
        return ans;
    }
}
