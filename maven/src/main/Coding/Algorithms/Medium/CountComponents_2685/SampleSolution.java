package main.Coding.Algorithms.Medium.CountComponents_2685;

import java.util.ArrayList;
import java.util.List;

public class SampleSolution {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {3, 5}
        };
        SampleSolution solution = new SampleSolution();
        int result = solution.countCompleteComponents(n, edges);
        System.out.println("Number of complete components: " + result);
    }
    boolean [] memo;
    public int countCompleteComponents(int n, int[][] edges) {
        memo = new boolean [n];
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!memo[i]) {
                List<Integer> gether = new ArrayList();
                dfs(i, graph, gether);
                int nodeSum = 0;
                int nodes = gether.size();
                for (int node : gether) {
                    nodeSum += graph.get(node).size();
                }
                int edgeSum = nodeSum;
                if (edgeSum == nodes * (nodes - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs (int node, List<List<Integer>> graph, List<Integer> gether) {
        memo[node] = true;
        gether.add(node);
        for (int n : graph.get(node)) {
            if (!memo[n]) {
                dfs (n, graph, gether);
            }
        }
    }
}
