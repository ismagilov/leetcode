import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> main = new Stack<>();
    private Stack<Integer> aux = new Stack<>();

    private int front;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (main.isEmpty())
            front = x;

        main.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (aux.isEmpty())
            while(!main.isEmpty())
                aux.push(main.pop());

        return aux.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (aux.isEmpty())
            return front;

        return aux.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && aux.isEmpty();
    }
}
