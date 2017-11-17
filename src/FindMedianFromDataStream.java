/**
* https://leetcode.com/problems/find-median-from-data-stream/description/
*/
public class FindMedianFromDataStream {
    private Queue<Integer> leftMax = new PriorityQueue<>(Comparator.<Integer>naturalOrder().reversed());
    private Queue<Integer> rightMin = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        leftMax.offer(num);
        rightMax.offer(leftMax.poll());
        
        if (rightMin.size() > leftMax.size())
            leftMax.offer(rightMin.poll());
    }
    
    public double findMedian() {
        if (leftMax.size() == rightMin.size())
            return (leftMax.peek() + rightMin.peek()) / 2.0;
        else 
            return leftMax.peek();
    }
}
