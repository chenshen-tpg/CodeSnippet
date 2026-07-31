package main.Coding.Algorithms.Normal.SmallestStableIndex_3903;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
//        System.out.println(test.helper(new int [] {5,0,1,4},3));
        System.out.println(test.helper(new int [] {3,2,1},1));
//        System.out.println(test.helper(new int [] {0},0));
    }

    public int helper (int [] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, arr[j]);
            }
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
            }
            if (max - min <= k) {
                return i;
            }
        }
        return -1;
    }
}
