import java.util.Comparator;

/**
* https://leetcode.com/problems/guess-number-higher-or-lower
* 
* The guess API is defined in the parent class GuessGame.
*   @param num, your guess
*   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
*   int guess(int num);
*/
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int b = 1, e = n;
        
        int guessed = 0;
        while (b <= e) {
            guessed = b + (e - b) / 2;
            
            int res = guess(guessed);
            if (res == 0)
                break;
            else if (res == 1)
                b = guessed + 1;
            else 
                e = guessed - 1;
        }
        
        return guessed;
    }
}

class GuessGame {
    private final int answer = 10;

    public int guess(int g) {
        return Integer.valueOf(answer).compareTo(Integer.valueOf(g));
    }
}
