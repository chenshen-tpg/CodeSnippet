package main.Coding.Algorithms.Normal.DistributeARR_3069;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] resultArray(int[] nums) {
        int [] ans = new int [nums.length];
        List<Integer> li1 = new ArrayList();
        List<Integer> li2 = new ArrayList();
        li1.add(nums[0]);
        li2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (li1.get(li1.size() - 1) > li2.get(li2.size() - 1)) {
                li1.add(nums[i]);
            } else {
                li2.add(nums[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < li1.size(); i++) {
            ans[index++] = li1.get(i);
        }
        for (int i = 0; i < li2.size(); i++) {
            ans[index++] = li2.get(i);
        }
        return ans;
    }
}
