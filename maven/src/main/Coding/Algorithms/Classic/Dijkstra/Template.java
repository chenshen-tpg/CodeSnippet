package main.Coding.Algorithms.Classic.Dijkstra;

import java.util.*;

public class Template {
    // Node class for priority queue (min-heap by distance)
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * Dijkstra's Algorithm using Priority Queue
     * Time: O((V + E) log V)
     * Space: O(V)
     *
     * @param n number of nodes (0 to n-1)
     * @param edges list of [from, to, weight]
     * @param start starting node
     * @return shortest distances from start to all nodes
     */
    public static int[] dijkstra(int n, int[][] edges, int start) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            // For undirected graph, uncomment:
            // graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // Initialize distances
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // Priority queue: min-heap by distance
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        // Track visited nodes
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;
            int d = curr.distance;

            // Skip if already visited
            if (visited[u]) continue;
            visited[u] = true;

            // Skip if outdated
            if (d > dist[u]) continue;

            // Relax edges
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    /**
     * Alternative: with path reconstruction
     */
    public static class DijkstraResult {
        public int[] distance;
        public int[] parent; // For path reconstruction

        public DijkstraResult(int[] distance, int[] parent) {
            this.distance = distance;
            this.parent = parent;
        }

        public List<Integer> getPath(int target) {
            List<Integer> path = new ArrayList<>();
            for (int v = target; v != -1; v = parent[v]) {
                path.add(v);
            }
            Collections.reverse(path);
            return path;
        }
    }

    public static DijkstraResult dijkstraWithPath(int n, int[][] edges, int start) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;

            if (curr.distance > dist[u]) continue;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return new DijkstraResult(dist, parent);
    }

    // Example usage
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1, 1},
            {0, 2, 4},
            {1, 2, 2},
            {1, 3, 5},
            {2, 3, 1}
        };
        int start = 0;

        int[] dist = dijkstra(n, edges, start);
        System.out.println("Shortest distances from " + start + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("  to " + i + ": " + dist[i]);
        }

        DijkstraResult result = dijkstraWithPath(n, edges, start);
        System.out.println("\nWith paths:");
        for (int i = 0; i < n; i++) {
            System.out.println("  to " + i + ": " + result.getPath(i) + " (dist: " + result.distance[i] + ")");
        }
    }
}
