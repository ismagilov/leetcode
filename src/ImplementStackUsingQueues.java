import java.util.LinkedList;

/**
 * https://leetcode.com/problems/implement-stack-using-queues
 */
public class ImplementStackUsingQueues {
    private LinkedList<Integer> q = new LinkedList<>();

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        int sz = q.size();

        q.offer(x);
        while (sz > 0) {
            q.offer(q.poll());
            sz--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
