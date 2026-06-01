package main.CodingQuestions.Algorithms.Easy.PrimeOfBit_762;

public class TEST {

    public static void main(String[] args) {
        TEST test = new TEST();
        test.countPrimeSetBits(6,10);
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while (left <= right) {
            if (isPrime(Integer.bitCount(left))) count++;
            left++;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
