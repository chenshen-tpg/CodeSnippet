package main.Coding.Algorithms.Normal.CheckRotateOrSotr_1752;

public class TEST {
    public static void main(String[] args) {
        TEST obj = new TEST();
        System.out.println(obj.check(new int[]{5,5,6,6,6,9,1,2}));
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        int dec = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i+1) % n]) {
                dec++;
            }
        }
        if (dec > 1) {
            return false;
        }
        return true;
    }
}
