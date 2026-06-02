package main.CodingQuestions.Algorithms.Easy.ShortestDistance_2515;

public class MySolution {
    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        String[] words = {"hello", "i", "am", "leetcode", "hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(mySolution.closestTarget(words,target, startIndex));
    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int len = words.length;
        int i, j;
        int forwardLen = 0;
        int backwardLen = 0;
        for (i = startIndex; i < len; i++) {
            if (words[i].equals(target)) {
                ans = Math.min(ans, forwardLen);
            }
            forwardLen++;
        }
        for (i = 0; i < startIndex; i++) {
            if (words[i].equals(target)) {
                ans = Math.min(ans, forwardLen);
            }
            forwardLen++;
        };
        for (j = startIndex; j >= 0; j--) {
            if (words[j].equals(target)) {
                ans= Math.min(ans, backwardLen);
            }
            backwardLen++;
        }
        for (j = len - 1; j >= 0; j--) {
            if (words[j].equals(target)) {
                ans = Math.min(ans, backwardLen);
            }
            backwardLen++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
