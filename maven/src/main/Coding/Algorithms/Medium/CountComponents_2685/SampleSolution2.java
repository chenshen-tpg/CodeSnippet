package main.Coding.Algorithms.Medium.CountComponents_2685;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SampleSolution2 {
    boolean[] visited;

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {3, 5}
        };
        SampleSolution2 solution = new SampleSolution2();
        int result = solution.countCompleteComponents(n, edges);
        System.out.println("Number of complete components: " + result);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(), components = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components.add(bfsTraversal(i, adj));
            }
        }
        int count = 0;
        for (int i = 0; i < components.size(); i++) {
            int nodes = components.get(i).size(), edge = 0;
            for (int vertex : components.get(i)) {
                edge += adj.get(vertex).size();
            }
            if (edge == nodes * (nodes - 1)) {
                count++;
            }
        }
        return count;
    }

    private ArrayList<Integer> bfsTraversal(int node, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);
        ArrayList<Integer> component = new ArrayList<>();
        while (!queue.isEmpty()) {
            int popped = queue.poll();
            component.add(popped);

            for (int neighbour : adj.get(popped)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return component;
    }
}
