package main.CodingQuestions.Algorithms.Easy.MinimalChangesToBS_1758;

public class SampleAnswer {
    public static void main(String[] args) {

    }

    public int minOperations(String s) {
        int n = s.length();
        int countForZeroStart = 0;

        for (int i = 0; i < n; i++) {
            char expectedChar;

            if (i % 2 == 0) {
                expectedChar = '0';
            } else {
                expectedChar = '1';
            }
            if (s.charAt(i) != expectedChar) {
                countForZeroStart++;
            }
        }

        int countForOneStart = n - countForZeroStart;

        return Math.min(countForZeroStart, countForOneStart);
    }
}
