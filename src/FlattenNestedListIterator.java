import lib.NestedInteger;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    private final ArrayDeque<Iterator<NestedInteger>> s = new ArrayDeque<>();
    private NestedInteger nextInt;
    
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        if (null != nestedList)
            s.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!s.isEmpty()) {
            Iterator<NestedInteger> it = s.peek();
            if (!it.hasNext())
                s.pop();
            else {
                nextInt = it.next();
                if (nextInt.isInteger())
                    return true;
                else
                    s.push(nextInt.getList().iterator());
            }
        }
        
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
