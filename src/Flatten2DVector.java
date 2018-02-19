/**
* https://leetcode.com/problems/flatten-2d-vector/description/
*/
public class Flatten2DVector implements Iterator<Integer> {
    private final LinkedList<Iterator<Integer>> q = new LinkedList<>();
    
    public Vector2D(List<List<Integer>> vec2d) {
        for (List<Integer> r : vec2d) {
            if (r == null) continue;
            
            if (r.size() > 0) 
                q.add(r.iterator());
        }
    }

    @Override
    public Integer next() {
        Iterator<Integer> head = q.peek();
        
        Integer res = head.next();
        if (!head.hasNext())
            q.poll();
        
        return res;
    }

    @Override
    public boolean hasNext() {
        return q.size() > 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
