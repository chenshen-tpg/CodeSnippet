package main.Coding.Algorithms.Normal.MinLenAfterRemovingSub_2696;

import java.util.Stack;

public class SampleSol {
    public static void main(String[] args) {

    }
    public int minLength(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if ((c == 'B') && (!stack.isEmpty() && stack.peek() == 'A')) {
                stack.pop();
            } else if ((c == 'D')&& (!stack.isEmpty() && stack.peek() == 'C')) {
                stack.pop();
            }
            else {
                stack.add(c);
            }
        }
        return stack.size();
    }
}
