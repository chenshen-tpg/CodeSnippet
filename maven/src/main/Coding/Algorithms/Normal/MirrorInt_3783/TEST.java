package main.Coding.Algorithms.Normal.MirrorInt_3783;

public class TEST {
    public static void main(String[] args) {

    }
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        int rev = Integer.valueOf(sb.toString());
        return Math.abs(n - rev);
    }
}
