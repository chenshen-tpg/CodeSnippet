package main.CodingQuestions.Algorithms.Easy.SpecialPos_1582;

public class TEST {
    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (check(mat, i, j)) ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int[][] mat, int i, int j) {
        int cols = mat[0].length;
        int rows = mat.length;
        for (int k = 0; k < cols; k++) {
            if (k != j && mat[i][k] == 1) return false;
        }
        for (int k = 0; k < rows; k++) {
            if (k != i && mat[k][j] == 1) return false;
        }
        return true;
    }
}
