package main.Coding.Algorithms.Normal.LongestOdd_1903;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.largestOddNumber("52");
    }

    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Integer.parseInt(num.charAt(i) + "") % 2 != 0) {
                while (i >= 0) {
                    sb.append(num.charAt(i));
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
