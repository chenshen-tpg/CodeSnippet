package main.Coding.Algorithms.Normal.Lonely_531;

public class TEST {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0] == null) {
            return 0;
        }

        int rows = picture.length;
        int cols = picture[0].length;
        int[] blackInRow = new int[rows];
        int[] blackInColumn = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (picture[row][col] == 'B') {
                    blackInRow[row]++;
                    blackInColumn[col]++;
                }
            }
        }

        int ans = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (picture[row][col] == 'B'
                        && blackInRow[row] == 1
                        && blackInColumn[col] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int helper(char[][] picture, int k, int l) {
        if (picture == null || k < 0 || k >= picture.length
                || picture[k] == null || l < 0 || l >= picture[k].length
                || picture[k][l] != 'B') {
            return 0;
        }

        for (int col = 0; col < picture[k].length; col++) {
            if (col != l && picture[k][col] == 'B') {
                return 0;
            }
        }
        for (int row = 0; row < picture.length; row++) {
            if (row != k && picture[row] != null
                    && l < picture[row].length && picture[row][l] == 'B') {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
