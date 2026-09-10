package main.Coding.Algorithms.Medium.CountComm_3871;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.countCommas(1000001);
    }

    public long countCommas(long n) {
        long ans = 0;
        long x = 1000;
        
        while(x <= n){
            long nos = n - x + 1;
            ans = ans + nos;
            x = x * 1000;
        }

        return ans;
    }
}
