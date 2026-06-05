package main.Coding.Algorithms.Normal.AvailableCaptureForRook_999;

public class TEST {

    public static void main(String[] args) {
        TEST obj = new TEST();
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(obj.numRookCaptures(board));
    }


    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return find(board, i, j, 0, 1) + find(board, i, j, 1, 0) + find(board, i, j, 0, -1) + find(board, i, j, -1, 0);
                }
            }
        }
        return 0;
    }

    public int find(char[][] b, int x, int y, int i, int j) {
        while (x >= 0 && x < 8 && y >= 0 && y < 8 && b[x][y] != 'B') {
            if (b[x][y] == 'p') return 1;
            x += i;
            y += j;
        }
        return 0;
    }
}
