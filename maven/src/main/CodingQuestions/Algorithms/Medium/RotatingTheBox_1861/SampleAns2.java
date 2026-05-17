package main.CodingQuestions.Algorithms.Medium.RotatingTheBox_1861;

public class SampleAns2 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            int emptyRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (rotated[i][j] == '*') {
                    emptyRow = i - 1;
                } else if (rotated[i][j] == '#') {
                    rotated[i][j] = '.';
                    rotated[emptyRow][j] = '#';
                    emptyRow--;
                }
            }
        }
        return rotated;
    }
}
