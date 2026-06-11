package main.Coding.Algorithms.Medium.WaysToAssignEdgeWeight_3558;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }

    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int maxDep = dfs(g, 1, 0);
        return qpow(maxDep - 1);
    }

    public int dfs(List<List<Integer>> g, int x, int y) {
        int max = 0;
        for (int i : g.get(x)) {
            if (i == y)
                continue;
            max = Math.max(max, dfs(g, i, x) + 1);
        }
        return max;
    }
    private int dfsDepthIterative(List<List<Integer>> graph, int root) {
        int n = graph.size() - 1;
        int[] parent = new int[n + 1];
        int[] depth = new int[n + 1];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        parent[root] = -1;

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            maxDepth = Math.max(maxDepth, depth[node]);

            for (int neighbor : graph.get(node)) {
                if (neighbor == parent[node]) continue;
                parent[neighbor] = node;
                depth[neighbor] = depth[node] + 1;
                stack.push(neighbor);
            }
        }

        return maxDepth;
    }
    private int qpow(int i) {
        long res = 1;
        long base = 2;
        while (i > 0) {
            if ((i & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            i >>= 1;
        }
        return (int) res;
    }
    private int pow2Mod(int exp) {
        long result = 1L;
        long current = 2L;

        while (exp > 0) {
            if ((exp & 1) != 0) {
                result = (result * current) % MOD;
            }
            current = (current * current) % MOD;
            exp >>= 1;
        }
        return (int) result;
    }
}
