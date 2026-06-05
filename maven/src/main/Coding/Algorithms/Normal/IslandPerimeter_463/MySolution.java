package main.Coding.Algorithms.Normal.IslandPerimeter_463;

public class MySolution {
    public static void main(String[] args) {

    }
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += check(grid,i,j);
                }
            }
        }
        return ans;
    }
    public int check (int [][] grid, int x, int y) {
        int count = 4;
        if (x + 1 < grid.length && grid[x+1][y] == 1) count--;
        if (x - 1 >= 0 && grid[x-1][y] == 1) count--;
        if (y + 1< grid[0].length && grid[x][y+1] == 1) count--;
        if (y - 1 >= 0 && grid[x][y-1] == 1) count--;
        return count;
    }
}
