package main.Coding.Algorithms.Normal.WatherBottle_1518;

public class TEST {
    public static void main(String[] args) {
        TEST test= new TEST();
        System.out.println(test.helper(15, 4));
    }

    public int helper (int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            total += newBottles;
            empty = newBottles + empty % numExchange;
        }

        return total;
    }
}
