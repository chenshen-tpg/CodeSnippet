package main.Coding.Algorithms.Normal.RankTransform_1331;

import java.util.Arrays;
import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.arrayRankTransform(new int [] {37,12,28,9,100,56,80,5,12}); //5,3,4,2,8,6,7,1,3
    }
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int [] temp = Arrays.copyOf(arr, len);
        //        int temp[]=arr.clone();
        int [] ans = new int [len];
        Arrays.sort(temp);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;
        for (int num : temp) {
            if (!hm.containsKey(num)) {
                hm.put(num, rank);
                rank++;
            }
        }
        for (int i = 0; i < len; i++) {
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }
}
