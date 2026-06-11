package main.Coding.Algorithms.Normal.NumberComplement_476;

public class TEST {
    public static void main(String[] args) {
        int number = 1;
        StringBuilder binary = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            binary.append(bit);
        }

        System.out.println(binary.toString());
    }

    public int findComplement(int num) {
        if (num == 0) return 1;
        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;
        return num ^ mask;

    }

}
