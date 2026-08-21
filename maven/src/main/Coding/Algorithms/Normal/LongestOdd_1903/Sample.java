package main.Coding.Algorithms.Normal.LongestOdd_1903;

public class Sample {
    public static void main(String[] args) {

    }
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
