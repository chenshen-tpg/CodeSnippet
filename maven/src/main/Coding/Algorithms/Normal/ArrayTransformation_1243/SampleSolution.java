package main.Coding.Algorithms.Normal.ArrayTransformation_1243;

import java.util.Arrays;
import java.util.List;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public List<Integer> transformArray(int[] nums) {
        boolean changed = true;
        while (changed) {
            int[] arr = nums.clone();
            changed = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    arr[i]--;
                    changed = true;
                } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                    arr[i]++;
                    changed = true;
                }
            }
            nums = arr;
        }
        List<Integer> ans = Arrays.stream(nums).boxed().toList();
        return ans;
    }
}
