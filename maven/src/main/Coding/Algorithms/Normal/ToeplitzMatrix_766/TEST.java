package main.Coding.Algorithms.Normal.ToeplitzMatrix_766;

import java.util.HashMap;
import java.util.Map;

public class TEST {
    /***
     [[1,2,3,4],
     [5,1,2,3],
     [9,5,1,2]]
     */
    public static void main(String[] args) {

    }

    public boolean helper(int[][] matrix) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int cur = r - c;
                if (!hm.containsKey(cur)) {
                    hm.put(cur, matrix[r][c]);
                } else if (hm.get(cur) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
