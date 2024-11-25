package Day26;

import java.util.Stack;

public class QueueUsingStacks {
    private static Stack<Integer> st1 = new Stack<>();
    private static Stack<Integer> st2 = new Stack<>();

    QueueUsingStacks() {

    }

    /**
     * Push element X to the back of queue.
     */
    static void push(int x) {
        st1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    static int pop() {
        if (!st2.isEmpty()) return st2.pop();
        while (!st1.isEmpty()) st2.push(st1.pop());
        return st2.pop();
    }

    /**
     * Get the front element of the queue.
     */
    static int peek() {
        if (!st2.isEmpty()) return st2.peek();
        while (!st1.isEmpty()) st2.push(st1.pop());
        return st2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    static boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
