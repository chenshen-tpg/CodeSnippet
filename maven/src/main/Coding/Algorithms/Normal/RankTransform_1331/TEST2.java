package main.Coding.Algorithms.Normal.RankTransform_1331;

import java.util.Arrays;
import java.util.HashMap;

public class TEST2 {
    public static void main(String[] args) {
        TEST2 test = new TEST2();
        test.arrayRankTransform(new int [] {37,12,28,9,100,56,80,5,12}); //5,3,4,2,8,6,7,1,3
    }
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int [] temp = arr.clone();
        Arrays.sort(temp);
        int [] ans = new int [len];
        int index = 0;
        for (int i = 1; i < len; i++) {
            if (temp[i] == temp[i-1]) {
                temp[i] = -999;
                index++;
            }
        }
        int newIndex = 0;
        int [] newTemp = new int [len - index];
        for (int i = 0; i < len; i++) {
            if (temp[i] != -999) {
                newTemp[newIndex++] = temp[i];
            }
        }
        for (int i = 0; i < len; i++) {
            int cur = 0;
            for (int j = 0; j < len; j++) {
                if (arr[i] > temp[j]) {
                    cur++;
                }
            }
            ans[i] = cur;
        }
        return ans;
    }

}
