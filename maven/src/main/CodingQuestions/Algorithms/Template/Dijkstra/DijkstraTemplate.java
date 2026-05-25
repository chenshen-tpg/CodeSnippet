package main.CodingQuestions.Algorithms.Template.Dijkstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class DijkstraTemplate {


    public static int[] dijkstra(int n, List<List<Pair>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.dist - b.dist
        );

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            // Skip outdated entries
            if (d > dist[u]) continue;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Example: u -> v (weight)
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        int[] dist = dijkstra(n, adj, 0);

        System.out.println(Arrays.toString(dist));
    }
}


