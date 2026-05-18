package main.Concept.JavaQuestion.JavaConcept.Template.Graph.BFS;

import java.util.*;

public class VisitedGraph {

    // Generic BFS: find shortest number of steps from src to dst
    public static int bfs(int src, int dst, Map<Integer, List<Integer>> adj) {
        if (src == dst) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int step = 0;

        // Initialize
        queue.offer(src);
        visited.add(src);

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                for (int next : adj.getOrDefault(cur, new ArrayList<>())) {
                    if (next == dst) return step;   // found target
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return -1; // no path from src to dst
    }

    public static void main(String[] args) {
        // Graph:  0 - 1 - 2 - 3
        //              \- 4
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(0, List.of(1));
        adj.put(1, List.of(0, 2, 4));
        adj.put(2, List.of(1, 3));
        adj.put(3, List.of(2));
        adj.put(4, List.of(1));

        System.out.println(bfs(0, 3, adj)); // 3 steps: 0->1->2->3
        System.out.println(bfs(0, 4, adj)); // 2 steps: 0->1->4
        System.out.println(bfs(0, 0, adj)); // 0 steps: already there
        System.out.println(bfs(3, 4, adj)); // 3 steps: 3->2->1->4
    }
}
