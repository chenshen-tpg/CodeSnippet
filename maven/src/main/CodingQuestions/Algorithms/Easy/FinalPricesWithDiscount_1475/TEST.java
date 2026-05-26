package main.CodingQuestions.Algorithms.Easy.FinalPricesWithDiscount_1475;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int [] ans = new int [len];
        for (int i = 0; i < len; i++) {
            int price = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    price = prices[i] - prices[j];
                    break;
                } else {
                    price = prices[i];
                }
            }
            if (i == len - 1) {
                ans[i] = prices[i];
            } else {
                ans[i] = price;
            }
        }
        return ans;
    }

    public int[] finalPricesOptmized(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int price = prices[i];
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    price -= prices[j];
                    break;
                }
            }
            ans[i] = price;
        }
        return ans;
    }
}
