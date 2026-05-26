package main.CodingQuestions.Algorithms.Easy.TicTacToe_1275;

public class SampleAns {
    public static void main(String[] args) {
        int[][] moves = {
                {0,0}, {0,1}, {0,2},
                {1,1}, {1,0}, {1,2},
                {2,1}, {2,0}, {2,2}
        };
        SampleAns obj = new SampleAns();
        obj.tictactoe(moves);
    }

    public String tictactoe(int[][] moves) {
        int[] rows = new int[3], cols = new int[3];
        int diag = 0, antiDiag = 0;
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0], c = moves[i][1];
            int mark = (i % 2 == 0) ? 1 : -1;
            rows[r] += mark;
            cols[c] += mark;
            if (r == c) diag += mark;
            if (r + c == 2) antiDiag += mark;
            if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 ||Math.abs(diag) == 3 || Math.abs(antiDiag) == 3) {
                return mark == 1 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
