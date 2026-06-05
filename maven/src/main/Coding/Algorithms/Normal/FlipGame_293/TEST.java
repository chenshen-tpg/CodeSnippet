package main.Coding.Algorithms.Normal.FlipGame_293;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }


    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> li = new ArrayList<>();
        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i - 1) == currentState.charAt(i) && currentState.charAt(i-1) == '+') {
                StringBuilder sb = new StringBuilder(currentState);
                sb.setCharAt(i-1,'-');
                sb.setCharAt(i,'-');
                li.add(sb.toString());
            }
        }
        return li;
    }



}
