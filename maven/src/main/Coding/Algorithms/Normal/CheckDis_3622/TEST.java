package main.Coding.Algorithms.Normal.CheckDis_3622;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.checkDivisibility(10);
    }


    public boolean checkDivisibility(int n) {
        int sum = 0;
        int multi = 1;
        int temp = n;
        while (temp > 0) {
            int cur = temp % 10;
            temp /= 10;
            sum += cur;
            multi *= cur;
        }
        return n % (multi + sum) == 0;
    }
}
