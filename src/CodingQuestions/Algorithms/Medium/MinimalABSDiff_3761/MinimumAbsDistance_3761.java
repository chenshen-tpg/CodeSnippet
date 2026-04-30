package CodingQuestions.Algorithms.Medium.MinimalABSDiff_3761;

import java.util.HashMap;
import java.util.Map;

public class MinimumAbsDistance_3761 {

    public static void main(String[] args) {
        MinimumAbsDistance_3761 test = new MinimumAbsDistance_3761();
        test.minMirrorPairDistance(new int[]{21, 120});
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> prev = new HashMap<>();
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (prev.containsKey(x)) {
                ans = Math.min(ans, i - prev.get(x));
            }
            prev.put(reverseNum(x), i);
        }

        return ans == n + 1 ? -1 : ans;
    }

    private int reverseNum(int x) {
        int y = 0;
        while (x > 0) {
            y = y * 10 + (x % 10);
            x /= 10;
        }
        return y;
    }
}
