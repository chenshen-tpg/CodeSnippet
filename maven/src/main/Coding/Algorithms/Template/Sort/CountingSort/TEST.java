package main.Coding.Algorithms.Template.Sort.CountingSort;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        int [] arr = new int [] {2,3,5,6,7,8,10};
        test.helper(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void helper (int [] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int a : arr) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        int [] memo = new int [max - min + 1];
        int index = 0;
        for (int a : arr) {
            memo[a - min] ++;
        }

        for (int j = 0; j < memo.length; j++) {
            while (memo[j] > 0) {
                arr[index++] = j + min;
                memo[j]--;
            }
        }
    }
}
