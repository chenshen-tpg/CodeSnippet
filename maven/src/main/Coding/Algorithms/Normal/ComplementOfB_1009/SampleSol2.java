package main.Coding.Algorithms.Normal.ComplementOfB_1009;

public class SampleSol2 {
    public static void main(String[] args) {


    }


    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int cur = n, count = 1;
        while (cur != 0) {
            n = n ^ count;
            count <<= 1;
            cur >>= 1;
        }
        return n;
    }
}
