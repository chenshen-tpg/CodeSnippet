package main.Coding.Algorithms.Normal.FindTheHiestAltitude_1732;

public class TEST {

    public static void main(String[] args) {

    }


    public int largestAltitude(int[] gain) {
        int ini = 0;
        int ans = 0;
        for (int i = 0; i < gain.length; i++) {
            ini += gain[i];
            if (ini > ans) {
                ans = ini;
            }
        }
        return ans;
    }
}
