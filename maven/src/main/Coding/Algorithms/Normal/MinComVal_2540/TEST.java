package main.Coding.Algorithms.Normal.MinComVal_2540;

public class TEST {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    return num1;
                }
            }
        }
        return -1;
    }

    public int getCommon_Refine(int[] nums1, int[] nums2) {
        for (int num1 : nums1) {
            int l = 0, r = nums2.length - 1;
            while (l <= r) {
                int mid = (l + r) /2;
                if (nums2[mid] == num1) {
                    return num1;
                } else if (nums2[mid] < num1) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public int getCommonTwoPointer(int[] nums1, int[] nums2) {
        int point1 =0;
        int point2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (point1 < len1 && point2 < len2) {
            if (nums1[point1] == nums2[point2]) {
                return nums1[point1];
            } else if (nums1[point1] > nums2[point2]) {
                point2++;
            } else {
                point1++;
            }
        }
        return -1;
    }
}
