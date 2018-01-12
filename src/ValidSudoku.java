/**
* https://leetcode.com/problems/valid-sudoku/description/
*/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                
                int k = 3 * (i / 3) + j / 3;
                int l = 3 * (i % 3) + j % 3; 
                if (board[k][l] != '.' && !cube.add(board[k][l]))
                    return false;
            }
        }
        
        return true;
    }
}
