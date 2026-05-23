package main.CodingQuestions.Algorithms.Medium.SearchInRotatedSortedArray_33;

import java.util.Arrays;

public class SampleAns1 {
    public static void main(String[] args) {
        SampleAns1 s = new SampleAns1();

        run(s, new int[]{4,5,6,7,0,1,2}, 0, 4);   // classic rotated, found
        run(s, new int[]{4,5,6,7,0,1,2}, 3, -1);  // classic rotated, not found
        run(s, new int[]{1}, 0, -1);              // single element, miss
        run(s, new int[]{1}, 1, 0);               // single element, hit
        run(s, new int[]{1,3}, 3, 1);             // small array, hit
        run(s, new int[]{3,1}, 1, 1);             // rotated size 2
        run(s, new int[]{5,1,3}, 5, 0);           // pivot near front
        run(s, new int[]{5,1,3}, 3, 2);           // right sorted half hit
        run(s, new int[]{6,7,8,1,2,3,4,5}, 2, 4); // larger rotated
        run(s, new int[]{1,2,3,4,5,6}, 4, 3);     // not rotated case
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private static void run(SampleAns1 s, int[] nums, int target, int expected) {
        int actual = s.search(nums, target);
        System.out.printf(
                "nums=%s, target=%d => actual=%d, expected=%d, %s%n",
                Arrays.toString(nums),
                target,
                actual,
                expected,
                actual == expected ? "PASS" : "FAIL"
        );
    }
}
