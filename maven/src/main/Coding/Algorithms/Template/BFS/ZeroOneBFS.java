package main.Coding.Algorithms.Template.BFS;

import main.Coding.Lib.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;



public class ZeroOneBFS {

    public static int[] zeroOneBFS(int n, List<List<Pair>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0;
        dq.offerFirst(src);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int w = neighbor.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;

                    if (w == 0)
                        dq.offerFirst(v); // prioritize
                    else
                        dq.offerLast(v);
                }
            }
        }

        return dist;
    }
}