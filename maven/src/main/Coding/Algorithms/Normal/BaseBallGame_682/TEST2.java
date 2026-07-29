package main.Coding.Algorithms.Normal.BaseBallGame_682;

import java.util.Stack;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);

            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());

            } else if (op.equals("C")) {
                stack.pop();

            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
