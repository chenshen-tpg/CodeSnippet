package main.CodingQuestions.Algorithms.Easy.MinimumPositiveSUMSubarray_3364;

public class SampleAnswer {
    public static void main(String[] args) {
        SampleAnswer s = new SampleAnswer();

        // Test 1: reverse top 2 rows in a 2x2 window at (0,0)
        int[][] grid1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printGrid(s.reverseSubmatrix(grid1, 0, 0, 2));
        // Expected rows 0,1 cols 0,1 swapped: [[4,5,3],[1,2,6],[7,8,9]]

        // Test 2: reverse full 3x3 grid
        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printGrid(s.reverseSubmatrix(grid2, 0, 0, 3));
        // Expected: [[7,8,9],[4,5,6],[1,2,3]]

        // Test 3: k=1, no change (single row window)
        int[][] grid3 = {
                {1, 2},
                {3, 4}
        };
        printGrid(s.reverseSubmatrix(grid3, 0, 0, 1));
        // Expected: [[1,2],[3,4]] unchanged

        // Test 4: window not at origin, offset (x=1, y=1, k=2)
        int[][] grid4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printGrid(s.reverseSubmatrix(grid4, 1, 1, 2));
        // Expected: rows 1,2 cols 1,2 swapped: [[1,2,3],[4,8,9],[7,5,6]]

        // Test 5: single element grid, k=1
        int[][] grid5 = {{42}};
        printGrid(s.reverseSubmatrix(grid5, 0, 0, 1));
        // Expected: [[42]]
    }
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i0 = x, i1 = x + k - 1; i0 < i1; i0++, i1--) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[i0][j];
                grid[i0][j] = grid[i1][j];
                grid[i1][j] = temp;
            }
        }
        return grid;
    }
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(java.util.Arrays.toString(row));
        }
        System.out.println("---");
    }
}
