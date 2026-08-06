package main.Coding.Algorithms.Normal.SmallestDivDig_3345;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.smallestNumber(10,2);
    }

    public int smallestNumber(int n, int t) {
        for (int i = n; i <= 1000; i++) {
            int temp = i;
            int product = 1;

            while (temp != 0) {
                product *= temp % 10;
                temp /= 10;
            }

            if (product % t == 0) {
                return i;
            }
        }
        return -1;
    }
}
