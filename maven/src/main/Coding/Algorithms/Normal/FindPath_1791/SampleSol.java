package main.Coding.Algorithms.Normal.FindPath_1791;

public class SampleSol {
    public static void main(String[] args) {

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }

        int[] nodes = new int[n];
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = i;
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int currentSource = edge[0];
            int currentDestination = edge[1];

            int parentSource = findTrueParent(currentSource, parent);
            int parentDestination = findTrueParent(currentDestination, parent);

            if (rank[parentSource] > rank[parentDestination]) {
                parent[parentDestination] = parentSource;
            } else if (rank[parentSource] < rank[parentDestination]) {
                parent[parentSource] = parentDestination;
            } else {
                parent[parentDestination] = parentSource;
                rank[parentSource]++;
            }
        }

        if (findTrueParent(source, parent) == findTrueParent(destination, parent)) {
            return true;
        }

        return false;
    }

    public int findTrueParent(int child, int[] parent) {
        while (parent[child] != child) {
            child = parent[child];
        }

        return parent[child];
    }
}
