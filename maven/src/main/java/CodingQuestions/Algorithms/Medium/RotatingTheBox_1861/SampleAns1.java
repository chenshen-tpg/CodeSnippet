package CodingQuestions.Algorithms.Medium.RotatingTheBox_1861;

public class SampleAns1 {
    public char[][] rotateTheBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; ++i) {
            int low = n - 1;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == '#') {
                    res[j][m - i - 1] = '.';
                    res[low][m - i - 1] = '#';
                    low--;
                } else {
                    if (grid[i][j] == '*') low = j - 1;
                    res[j][m - i - 1] = grid[i][j];
                }
            }
        }
        return res;
    }
}
