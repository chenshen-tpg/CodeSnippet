package main.Coding.Algorithms.Normal.NumOfStringAsSubString_1967;

public class TEST {
    public static void main(String[] args) {

    }
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String s : patterns) {
            if (word.contains(s)) ans++;
        }
        return ans;
    }
}
