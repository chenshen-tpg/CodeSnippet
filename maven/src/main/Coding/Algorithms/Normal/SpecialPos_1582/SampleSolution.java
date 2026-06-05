package main.Coding.Algorithms.Normal.SpecialPos_1582;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int i, j, ans = 0;
        int m = mat.length, n = mat[0].length;
        int rowCount[] = new int[m];
        int colCount[] = new int[n];

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
