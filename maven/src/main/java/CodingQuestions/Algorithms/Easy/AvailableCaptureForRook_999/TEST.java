package CodingQuestions.Algorithms.Easy.AvailableCaptureForRook_999;

public class TEST {
    /***
     You are given an 8 x 8 matrix representing a chessboard. There is exactly one white rook represented by 'R', some number of white bishops 'B', and some number of black pawns 'p'. Empty squares are represented by '.'.
     A rook can move any number of squares horizontally or vertically (up, down, left, right) until it reaches another piece or the edge of the board. A rook is attacking a pawn if it can move to the pawn's square in one move.
     Note: A rook cannot move through other pieces, such as bishops or pawns. This means a rook cannot attack a pawn if there is another piece blocking the path.
     Return the number of pawns the white rook is attacking.

     nput: board = [[".",".",".",".",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    [".",".",".","R",".",".",".","p"],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".",".",".",".",".","."]]
     */
    public static void main(String[] args) {
        TEST obj = new TEST();
        char[][] board = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println(obj.numRookCaptures(board));
    }


    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return find(board,i,j,0,1) + find(board,i,j,1,0) + find(board,i,j,0,-1) + find(board,i,j,-1,0);
                }
            }
        }
        return 0;
    }

    public int find(char[][] b, int x, int y, int i, int j) {
        while (x >= 0 && x < 8 && y >= 0 && y <8 && b[x][y] != 'B') {
            if (b[x][y] == 'p') return 1;
            x += i; y += j;
        }
        return 0;
    }
}
