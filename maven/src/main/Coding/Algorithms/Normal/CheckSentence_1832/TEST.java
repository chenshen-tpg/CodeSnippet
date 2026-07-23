package main.Coding.Algorithms.Normal.CheckSentence_1832;

public class TEST {
    public static void main(String[] args) {

    }
    public boolean checkIfPangram(String sentence) {
        int [] memo = new int [26];
        for (char c : sentence.toCharArray()) {
            memo[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (memo[i] == 0) return false;
        }
        return true;
    }
}
