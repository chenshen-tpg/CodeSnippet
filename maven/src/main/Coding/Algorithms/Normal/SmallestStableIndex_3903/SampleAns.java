package main.Coding.Algorithms.Normal.SmallestStableIndex_3903;

public class SampleAns {
    public static void main(String[] args) {

    }

    public int firstStableIndex(int[] nums, int k) {
        int pre[] = new int[nums.length];
        int suff[] = new int[nums.length];
        pre[0] = nums[0];
        suff[suff.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }
        for (int i = suff.length - 2; i >= 0; i--) {
            suff[i] = Math.min(suff[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] - suff[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
