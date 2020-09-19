import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack
 */
class MinStack {
    private final static class Node {
        int v;
        int min;
    }
    private final Stack<Node> s = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        Node n = new Node();
        n.v = x;

        if (s.isEmpty()) {
            n.min = x;
        } else {
            int curMin = s.peek().min;
            if (x < curMin)
                n.min = x;
            else
                n.min = curMin;
        }

        s.push(n);
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().v;
    }

    public int getMin() {
        if (!s.isEmpty())
            return s.peek().min;
        else
            return -1;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();

        m.push(10);
        m.push(5);
        m.push(1);
        m.push(1);

        System.out.println("min = " + m.getMin());
        m.pop();
        System.out.println("min = " + m.getMin());
        m.pop();
        System.out.println("min = " + m.getMin());
    }
}
