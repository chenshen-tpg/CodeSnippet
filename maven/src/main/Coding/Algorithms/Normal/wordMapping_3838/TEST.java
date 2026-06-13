package main.Coding.Algorithms.Normal.wordMapping_3838;

public class TEST {
    public static void main(String[] args) {

    }

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int temp = 0;
            for (char cur : word.toCharArray()) {
                temp += weights[cur - 'a'];
            }
            sb.append((char) ('z' - (temp % 26)));
        }
        return sb.toString();
    }
}
