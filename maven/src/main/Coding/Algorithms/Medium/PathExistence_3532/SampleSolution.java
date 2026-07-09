package main.Coding.Algorithms.Medium.PathExistence_3532;

public class SampleSolution {

    public static void main(String[] args) {
        SampleSolution test = new SampleSolution();
        test.pathExistenceQueries(4, new int [] {2,5,6,8},2,new int [][] {{0,1},{0,2},{1,3},{2,3}});
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int id = 0;
        component[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                id++;
            }
            component[i] = id;
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = component[u] == component[v];
        }
        return ans;
    }
}
