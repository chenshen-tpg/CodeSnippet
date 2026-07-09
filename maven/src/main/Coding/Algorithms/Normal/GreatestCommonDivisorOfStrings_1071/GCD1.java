package main.Coding.Algorithms.Normal.GreatestCommonDivisorOfStrings_1071;

public class GCD1 {

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        GCD1 solution = new GCD1();
        System.out.println(solution.gcdOfStrings(str1, str2));
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

}
