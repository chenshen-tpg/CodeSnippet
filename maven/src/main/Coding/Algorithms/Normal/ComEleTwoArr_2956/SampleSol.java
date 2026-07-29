package main.Coding.Algorithms.Normal.ComEleTwoArr_2956;

public class SampleSol {
    public static void main(String[] args) {

    }
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int [] res = new int[2];

        for (int n: nums1) {
            for (int k: nums2) {
                if (n == k) {
                    res[0]++;
                    break;
                }
            }
        }

        for (int k: nums2) {
            for (int n: nums1) {
                if (k == n) {
                    res[1]++;
                    break;
                }
            }
        }

        return res;
    }
}
