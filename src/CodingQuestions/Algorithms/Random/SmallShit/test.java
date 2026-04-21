package CodingQuestions.Algorithms.Random.SmallShit;

public class test {
    public static void main(String[] args) {
        int test = 1234560;
        test ts = new test();
        System.out.println(ts.reverseIntMath(test));

    }

    // Method 1: Using StringBuilder
    public static int reverseIntStringBuilder(int n) {
        int sign = n < 0 ? -1 : 1;
        String reversed = new StringBuilder(String.valueOf(Math.abs(n))).reverse().toString();
        return sign * Integer.parseInt(reversed);
    }

    // Method 2: Mathematical approach
    public static int reverseIntMath(int n) {
        int res = 0;
        int num = Math.abs(n);
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return n < 0 ? -res : res;
    }

    // Method 3: Handling overflow (LeetCode style)
    public static int reverseIntSafe(int n) {
        int res = 0;
        while (n != 0) {
            int pop = n % 10;
            n /= 10;
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) return 0; // overflow
            res = res * 10 + pop;
        }
        return res;
    }

}
