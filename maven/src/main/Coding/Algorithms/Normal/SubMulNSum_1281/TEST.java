package main.Coding.Algorithms.Normal.SubMulNSum_1281;

public class TEST {
    public static void main(String[] args) {

    }

    public int subtractProductAndSum(int n) {
        int temp = n;
        int add = 0;
        int mul = 1;
        while (temp > 0) {
            int cur = temp % 10;
            add += cur % 10;
            mul *= cur % 10;
            temp /= 10;
        }
        return mul - add;
    }
}
