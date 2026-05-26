package main.CodingQuestions.Algorithms.Easy.CountSpecialChars_3120;

public class TEST {
    public static void main(String[] args) {

    }
    public int numberOfSpecialChars(String word) {
        int [] memo = new int [128];
        for (char w : word.toCharArray()) {
            memo[w]++;
        }
        int ans = 0;
        for (int i = 0; i < memo.length - 32; i++) {
            if (memo[i] >0 && memo[i + 32] > 0) {
                ans += 1;
            }
        }
        return ans;
    }
}
