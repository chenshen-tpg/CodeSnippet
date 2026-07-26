package main.Coding.Algorithms.Normal.MinLenAfterRemovingSub_2696;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.minLength("ABFCACDB");
    }

    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("AB") != -1 || sb.indexOf("CD") != -1) {
            if (sb.indexOf("AB") != -1) {
                sb.delete(sb.indexOf("AB"), sb.indexOf("AB") + 2);
            }
            if (sb.indexOf("CD") != -1) {
                sb.delete(sb.indexOf("CD"), sb.indexOf("CD") + 2);
            }
        }
        return sb.length();
    }
}
