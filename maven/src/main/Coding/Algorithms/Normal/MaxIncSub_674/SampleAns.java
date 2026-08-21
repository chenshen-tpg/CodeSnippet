package main.Coding.Algorithms.Normal.MaxIncSub_674;

import main.Coding.Lib.Pair;

import java.util.PriorityQueue;

public class SampleAns {
    public static void main(String[] args) {

    }
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(n, (a, b) -> b.getKey()-a.getKey());
        for (int i = 0; i < n; i++) {
            maxHeap.add(new Pair<>(score[i], i));
        }
        String[] result = new String[n];
        int rank = 1;
        while (!maxHeap.isEmpty()) {
            Pair<Integer, Integer> pair = maxHeap.poll();
            if (rank == 1) {
                result[pair.getValue()] = "Gold Medal";
            } else if (rank == 2) {
                result[pair.getValue()] = "Silver Medal";
            } else if (rank == 3) {
                result[pair.getValue()] = "Bronze Medal";
            } else {
                result[pair.getValue()] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }
}
