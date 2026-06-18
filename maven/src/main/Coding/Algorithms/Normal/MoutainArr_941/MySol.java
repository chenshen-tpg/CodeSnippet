package main.Coding.Algorithms.Normal.MoutainArr_941;

public class MySol {
    public static void main(String[] args) {
        //[0,1,2,3,4,5,6,7,8,9] Interesting test case.
    }

    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) return false;
        int peak = 0;
        int n = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > peak) {
                peak = arr[i];
                n = i;
            }
        }
        if (n == len - 1 || n == 0) return false;
        for (int i = n; i >= 1; i--) {
            if (arr[i - 1] >= arr[i]) return false;
        }
        for (int i = n; i < len - 1; i++) {
            if (arr[i + 1] >= arr[i]) return false;
        }
        return true;
    }
}
