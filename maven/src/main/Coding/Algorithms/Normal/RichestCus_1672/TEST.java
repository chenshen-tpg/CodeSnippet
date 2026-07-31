package main.Coding.Algorithms.Normal.RichestCus_1672;

public class TEST {
    public static void main(String[] args) {

    }

    public int helper (int [][] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
