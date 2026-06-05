package main.Coding.Algorithms.Normal.TicTacToe_1275;

public class TEST {

    public String tictactoe(int[][] moves) {

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                moves[x][y] = -1;
            } else {
                moves[x][y] = -2;
            }
        }
        return check(moves);
    }


    public String check (int [][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0] == -1 ? "A" : "B";
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i] == -1 ? "A" : "B";
            }
        }
        // Check diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0] == -1 ? "A" : "B";
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] == -1 ? "A" : "B";
        }
        // Check for draw or pending
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 0)
                    return "Pending";
        return "Draw";
    }
}
