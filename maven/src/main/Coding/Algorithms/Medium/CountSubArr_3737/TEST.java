package main.Coding.Algorithms.Medium.CountSubArr_3737;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.countMajoritySubarrays(new int [] {1,2,2,3}, 2);
    }
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = 0;
                for (int k = i; k <= j; k++) {
                    if (nums[k] == target) {
                            temp++;
                    }
                }
                if (temp * 2 > (j - i + 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
