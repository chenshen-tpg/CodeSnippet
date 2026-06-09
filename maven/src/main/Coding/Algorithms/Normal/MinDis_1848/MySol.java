package main.Coding.Algorithms.Normal.MinDis_1848;

public class MySol {
    public static void main(String[] args) {

    }
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                ans = Math.min(ans, Math.abs(start - i));
            }
        }
        return ans;
    }
}
