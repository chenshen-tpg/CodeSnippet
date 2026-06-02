package main.CodingQuestions.Algorithms.Easy.ShortestDistance_2515;

public class SampleSolution2 {
    public static void main(String[] args) {

    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                //forward && backward
                int diff = Math.abs(i - startIndex);
                int circularDist = n - diff;
                ans = Math.min(ans, Math.min(diff, circularDist));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
