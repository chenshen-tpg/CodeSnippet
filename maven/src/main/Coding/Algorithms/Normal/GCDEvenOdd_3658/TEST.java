package main.Coding.Algorithms.Normal.GCDEvenOdd_3658;

public class TEST {
    public int gcdOfOddEvenSums(int n) {
        int even = 0, odd = 0;
        n *= 2;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        return odd > even ? gcd(odd, even) : gcd(even, odd);
    }

    public int gcd(int i, int j) {
        if (j == 0) return i;
        return gcd(j, i % j);
    }
}
