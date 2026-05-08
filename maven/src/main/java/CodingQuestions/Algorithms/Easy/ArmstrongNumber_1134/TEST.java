package CodingQuestions.Algorithms.Easy.ArmstrongNumber_1134;


public class TEST {
    public static void main(String[] args) {
        TEST obj = new TEST();
        System.out.println(obj.method(153));
    }

    public boolean loopSolution (int n) {
        int ans = 0;
        int cur = n, len = 0;
        while (cur > 0) {
            cur/= 10;
            len++;
        }
        int cal = n;
        while (cal > 0) {
            int dig = cal % 10;
            ans += Math.pow(dig, len);
            cal /= 10;
        }
        return ans == n;
    }
    public boolean method (int n) {
        int ans = 0;
        //logarithms to get the length
        int length = (n == 0) ? 1 : (int) Math.log10(n) + 1;
        int cal = n;
        while (cal > 0) {
            int dig = cal % 10;
            ans += Math.pow(dig, length);
            cal /= 10;
        }
        return ans == n;
    }

    public boolean refinedWay(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;
        int[] powTable = new int[10];
        for (int d = 0; d < 10; d++) {
            powTable[d] = (int) Math.pow(d, length);
        }
        int sum = 0;
        for (char c : digits) {
            int digit = c - '0';
            sum += powTable[digit];
        }
        return sum == n;
    }
}
