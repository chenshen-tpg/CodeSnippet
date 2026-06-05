package main.Coding.Algorithms.Normal.FindCommonChar_1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleSolution {

    public static void main(String[] args) {
        SampleSolution test = new SampleSolution();
        test.commonChars(new String [] {"bella","label","roller"});
    }

    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE); // A template to solve this issue.

        for (String word : words) {
            //Every time we compare with the last one to find out the minimal value
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}
