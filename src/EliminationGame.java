/**
* https://leetcode.com/problems/elimination-game/description/
*/
public class EliminationGame {
    public int lastRemaining(int n) {
        int step = 1;
        int head = 1;
        int remaining = n;
        boolean left = true;
        
        while (remaining > 1) {
            if (left || remaining % 2 == 1)
                head += step;
                
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        
        return head;
    }
}
