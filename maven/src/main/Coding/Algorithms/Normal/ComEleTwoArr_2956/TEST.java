package main.Coding.Algorithms.Normal.ComEleTwoArr_2956;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] memo1 = new int[101];
        int[] memo2 = new int[101];
        for (int num : nums1) {
            memo1[num]++;
        }
        for (int num : nums2) {
            memo2[num]++;
        }
        int temp = 0;
        int temp1 = 0;
        for (int num : nums1) {
            if (memo2[num] > 0) {
                temp++;
            }
        }
        for (int num : nums2) {
            if (memo1[num] > 0) {
                temp1++;
            }
        }
        return new int[] { temp, temp1 };
    }
}
