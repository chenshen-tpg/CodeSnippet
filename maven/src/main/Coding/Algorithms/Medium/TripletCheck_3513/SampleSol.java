package main.Coding.Algorithms.Medium.TripletCheck_3513;

public class SampleSol {
    public static void main(String[] args) {

    }
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }

        return ans;
    }
}
