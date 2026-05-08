package CodingQuestions.Algorithms.Easy.ImplementStackUsingQueue_225;

import java.util.LinkedList;


/***
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */
public class TEST {
    LinkedList<Integer> queue;
    public static void main(String[] args) {
        TEST myStack = new TEST();// Simple test case
        myStack.push(1); // Stack: 1
        myStack.push(2); // Stack: 2->1
        System.out.println(myStack.top()); // Output: 2
        System.out.println(myStack.pop()); // Output: 2
        System.out.println(myStack.empty()); // Output: false

        // More complex test case
        myStack.push(3); // Stack: 3->1
        myStack.push(4); // Stack: 4->3->1
        System.out.println(myStack.top()); // Output: 4
        System.out.println(myStack.pop()); // Output: 4
        System.out.println(myStack.top()); // Output: 3
        myStack.push(5); // Stack: 5->3->1
        System.out.println(myStack.top()); // Output: 5
        System.out.println(myStack.pop()); // Output: 5
        System.out.println(myStack.pop()); // Output: 3
        System.out.println(myStack.pop()); // Output: 1
        System.out.println(myStack.empty()); // Output: true
        // Edge case: pop/top on empty stack
        System.out.println("Pop on empty: " + (myStack.queue.isEmpty() ? "null" : myStack.pop()));
        System.out.println("Top on empty: " + (myStack.queue.isEmpty() ? "null" : myStack.top()));
    }


    public void push(int x) {
        // queue.addFirst(x);
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
