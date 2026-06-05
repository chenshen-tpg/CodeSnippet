package main.Coding.Algorithms.Normal.MaxPopulationYear_1854;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();

        int[][] logs = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1981}
        };

        int result = test.maximumPopulation(logs);
        System.out.println(result);
    }

    public int maximumPopulation(int[][] logs) {
        int [] memo = new int [100];
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            while (birth < death) {
                memo[birth - 1950]++;
                birth++;
            }
        }
        int com = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            if (memo[i] > com) {
                ans = i;
                com = memo[i];
            }
        }
        return ans + 1950;
    }
}
