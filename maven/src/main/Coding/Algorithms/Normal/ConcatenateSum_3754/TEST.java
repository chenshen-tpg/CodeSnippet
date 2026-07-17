package main.Coding.Algorithms.Normal.ConcatenateSum_3754;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();

        test.sumAndMultiply(10203004);
    }

    public long sumAndMultiply(int n) {
        long dig = 0;
        long sum = 0;
        int temp = n;
        while (temp > 0) {
            if (temp % 10 != 0) {
                dig = dig * 10 + temp % 10;
            }
            sum += temp % 10;
            temp /= 10;
        }
        long revDig = 0;
        while (dig > 0) {
            revDig = revDig * 10 + dig % 10;
            dig /= 10;
        }
        return revDig * sum;
    }
}
