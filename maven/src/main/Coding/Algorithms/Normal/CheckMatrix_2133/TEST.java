package main.Coding.Algorithms.Normal.CheckMatrix_2133;

import main.Coding.Algorithms.Medium.MinimumDeletionsToKSpecial_3085.Array;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.checkValid(new int [] []{{1,2,3},{3,1,2},{2,3,1}});
    }


    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] seenRow = new boolean[n + 1];
            boolean[] seenCol = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int r = matrix[i][j];
                int c = matrix[j][i];
                if (r < 1 || r > n || seenRow[r]) return false;
                if (c < 1 || c > n || seenCol[c]) return false;
                seenRow[r] = true;
                seenCol[c] = true;
            }
        }
        return true;
    }
}
