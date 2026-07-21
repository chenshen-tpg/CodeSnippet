package main.Coding.Algorithms.Normal.Shift2D_1260;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int cells = rows * cols;
        k %= cells;
        List<List<Integer>> li = new ArrayList(rows);
        for (int i = 0; i < rows; i++) {
            List<Integer> cur = new ArrayList();
            for (int j = 0; j < cols; j++) {
                int index = (i * cols + j - k + cells ) % cells;
                cur.add(grid[index / cols][index % cols]);
            }
            li.add(cur);
        }
        return li;
    }
}
