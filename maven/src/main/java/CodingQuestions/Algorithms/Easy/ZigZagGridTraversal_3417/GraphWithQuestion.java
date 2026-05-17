package CodingQuestions.Algorithms.Easy.ZigZagGridTraversal_3417;

import java.util.ArrayList;
import java.util.List;

public class GraphWithQuestion {
    /***
     *
     *
     You are given an m x n 2D array grid of positive integers.

     Your task is to traverse Grid in a zigzag pattern while skipping every alternate cell.

     Zigzag pattern traversal is defined as following the below actions:

     Start at the top-left cell (0, 0).
     Move right within a row until the end of the row is reached.
     Drop down to the next row, then traverse left until the beginning of the row is reached.
     Continue alternating between right and left traversal until every row has been traversed.
     Note that you must skip every alternate cell during the traversal.

     Return an array of integers result containing, in order, the value of the cells visited during the zigzag traversal with skips.


     Input: grid = [[1,2,3],[4,5,6],[7,8,9]]

     Output: [1,3,5,7,9]
     */
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[][] grid2 = {{2, 1}, {2, 1}, {2, 1}};
        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(zigzag(grid1));
        System.out.println(zigzag(grid2));
        System.out.println(zigzag(grid3));

        // Large square grid 10x10
        int[][] grid4 = new int[10][10];
        int val = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid4[i][j] = val++;
            }
        }
        List<Integer> result4 = zigzag(grid4);
        System.out.println("10x10 grid, first 10: " + result4.subList(0, 10));
        System.out.println("10x10 grid, last 10: " + result4.subList(result4.size() - 10, result4.size()));

        // Large rectangular grid 20x5
        int[][] grid5 = new int[20][5];
        val = 1;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                grid5[i][j] = val++;
            }
        }
        List<Integer> result5 = zigzag(grid5);
        System.out.println("20x5 grid, first 10: " + result5.subList(0, 10));
        System.out.println("20x5 grid, last 10: " + result5.subList(result5.size() - 10, result5.size()));

        // Large rectangular grid 5x20
        int[][] grid6 = new int[5][20];
        val = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                grid6[i][j] = val++;
            }
        }
        List<Integer> result6 = zigzag(grid6);
        System.out.println("5x20 grid, first 10: " + result6.subList(0, 10));
        System.out.println("5x20 grid, last 10: " + result6.subList(result6.size() - 10, result6.size()));
    }

    public static List<Integer> zigzag(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean goingRight = true;

        for (int row = 0; row < rows; row++) {
            if (goingRight) {
                for (int col = 0; col < cols; col++) {
                    if ((row + col) % 2 == 0) {
                        result.add(grid[row][col]);
                    }
                }
            } else {
                for (int col = cols - 1; col >= 0; col--) {
                    if ((row + col) % 2 == 0) {
                        result.add(grid[row][col]);
                    }
                }
            }
            goingRight = !goingRight;
        }
        return result;
    }
}
