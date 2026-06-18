package main.Coding.Algorithms.Normal.FindPath_1791;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int source = 0;
        int destination = 5;
        System.out.println(test.validPath(n,edges,source,destination));
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        boolean [] check = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        check[source] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) return true;
            for (int next : map.get(cur)) {
                if (!check[next]) check[next] = true;
                q.offer(next);
            }
        }

        return false;
    }
}
