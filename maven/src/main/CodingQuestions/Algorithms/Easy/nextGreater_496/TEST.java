package main.CodingQuestions.Algorithms.Easy.nextGreater_496;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.nextGreaterElement(new int [] {4,1,2}, new int [] {1,3,4,2});
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        int j;
        for (int i = 0; i < len1; i++) {
            boolean fond = false;
            for (j = 0; j < len2; j++) {
                if (fond && nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
                if (nums2[j] == nums1[i]) {
                    fond = true;
                }
            }
            if (j == nums2.length) {
                ans[i] = -1;
            }

        }
        return ans;
    }
}
