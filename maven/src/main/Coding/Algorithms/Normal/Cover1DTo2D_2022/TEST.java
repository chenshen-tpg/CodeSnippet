package main.Coding.Algorithms.Normal.Cover1DTo2D_2022;

public class TEST {
    public static void main(String[] args) {

    }
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] ans = new int [m][n];
        int index = 0;
        if (m * n != original.length) {
            return new int[][]{};
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[index++];
            }
        }
        return ans;
    }
}
