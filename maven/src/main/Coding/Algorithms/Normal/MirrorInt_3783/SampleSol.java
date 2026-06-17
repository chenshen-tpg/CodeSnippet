package main.Coding.Algorithms.Normal.MirrorInt_3783;

public class SampleSol {
    public static void main(String[] args) {

    }

    public int mirrorDistance(int n) {
        int a = n;
        int cur = 0;
        while (a != 0) {
            cur = cur * 10 + a % 10;
            a = a / 10;
        }

        return Math.abs(cur - n);
    }
}
