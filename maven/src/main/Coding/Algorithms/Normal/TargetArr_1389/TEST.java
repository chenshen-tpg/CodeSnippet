package main.Coding.Algorithms.Normal.TargetArr_1389;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.createTargetArray(new int [] {0,1,2,3,4}, new int [] {0,1,2,2,1});

    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
