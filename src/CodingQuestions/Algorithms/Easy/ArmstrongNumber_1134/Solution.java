package CodingQuestions.Algorithms.Easy.ArmstrongNumber_1134;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isArmstrong(int n) {
        int count = 0, temp = n;
        while (temp > 0) {
            count += Math.pow(temp % 10, String.valueOf(n).length());
            temp /= 10;
        }
        return n == count;
    }
}
