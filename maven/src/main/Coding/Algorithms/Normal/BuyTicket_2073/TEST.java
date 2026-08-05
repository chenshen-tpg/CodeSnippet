package main.Coding.Algorithms.Normal.BuyTicket_2073;

public class TEST {
    public static void main(String[] args) {

    }


    public int helper (int [] tickets, int k) {
        int num = tickets[k];
        int ans = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[i], num);
            } else {
                ans += Math.min(tickets[i], num - 1);
            }
        }
        return ans;
    }
}
