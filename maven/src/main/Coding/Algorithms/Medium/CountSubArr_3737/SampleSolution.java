package main.Coding.Algorithms.Medium.CountSubArr_3737;

public class SampleSolution {
    public static void main(String[] args) {
        SampleSolution solution = new SampleSolution();
        // Test case: [1,2,2,3] with target 2
        // Subarrays with majority 2: [2], [2], [2,2], [2,3] = 4
        int result = solution.countMajoritySubarrays(new int[]{1, 2, 2, 3}, 2);
        System.out.println("Result: " + result);
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) ans++;
        }
        if (ans == 0) return 0;
        ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }
                int subarrayLen = j - i + 1;
                if (count * 2 > subarrayLen) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
