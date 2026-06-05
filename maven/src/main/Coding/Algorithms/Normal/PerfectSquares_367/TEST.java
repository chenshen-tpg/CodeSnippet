package main.Coding.Algorithms.Normal.PerfectSquares_367;

public class TEST {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(Math.sqrt(n));
    }

    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt == (int) sqrt;
    }
}
