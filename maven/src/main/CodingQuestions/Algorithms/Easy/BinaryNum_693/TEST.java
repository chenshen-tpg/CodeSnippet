package main.CodingQuestions.Algorithms.Easy.BinaryNum_693;

public class TEST {
    public static void main(String[] args) {

    }
    public boolean hasAlternatingBits(int n) {
        String temp = Integer.toString(n, 2);
        int len = temp.length();
        for (int i = 0; i < len - 1; i++) {
            if (temp.charAt(i) == temp.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
