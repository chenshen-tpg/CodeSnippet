package CodingQuestions.Algorithms.Easy.ArmstrongNumber_1134;

public class Count {
    /***
     *
     Given an integer n, return true if and only if it is an Armstrong number.
     The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.
     Input: n = 153
     Output: true
     Explanation: 153 is a 3-digit number, and 153 = 13 + 53 + 33.
     */

    public static void main(String[] args) {
        Count solution = new Count();
        System.out.println(solution.isArmstrong(2));
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
