package main.Coding.Algorithms.Normal.FlipGame_293;

import java.util.ArrayList;
import java.util.List;

public class SampleSolution {
    public static void main(String[] args) {

    }
    public List<String> sampleAnswer(String currentState) {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; ++i) {
            if (currentState.charAt(i) == currentState.charAt(i+1) && currentState.charAt(i) == '+') {
                String nextState = (currentState.substring(0, i) + "--" + currentState.substring(i + 2));
                li.add(nextState);
            }
        }
        return li;
    }
}
