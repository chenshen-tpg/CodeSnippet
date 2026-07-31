package main.Coding.Algorithms.Medium.minNumPushToType_3016;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.minimumPushes("aabbccddeeffgghhiiiiii");
    }

    public int minimumPushes(String word) {
        int[] memo = new int[26];
        for (char c : word.toCharArray()) {
            memo[c - 'a']++;
        }
        Arrays.sort(memo);
        for (int i = 0, j = memo.length - 1; i < j; i++, j--) {
            int tmp = memo[i];
            memo[i] = memo[j];
            memo[j] = tmp;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (memo[i] == 0)
                break;
            ans += (i / 8 + 1) * memo[i];
        }
        return ans;

    }
}
