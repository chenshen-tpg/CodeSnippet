package main.Coding.Algorithms.Normal.ShortestDistance_2515;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = -1;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int d = Math.abs(i - startIndex);
                int curr = Math.min(d, n - d);
                if (res == -1 || curr < res) {
                    res = curr;
                }
            }
        }

        return res;
    }
}
