import java.util.LinkedList;

public class ImplementQueueUsingStacks232 {
    private LinkedList<Integer> in = new LinkedList();
    private LinkedList<Integer> out = new LinkedList();

    private int front;

    public ImplementQueueUsingStacks232() {
    }

    public void push(int x) {
        if (in.isEmpty()) {
            front = x;
        }

        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.pop();
    }

    public int peek() {
        if (!out.isEmpty()) {
            return out.peek();
        }

        return front;
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks232 s = new ImplementQueueUsingStacks232();

        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }
}
