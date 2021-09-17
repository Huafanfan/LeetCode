package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/17 09:30
 */
public class ValidSudoku0036 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        for (int i=0; i<9; i++){
            map.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
        }

        for (int i=0; i<9; i++){
            Set<Integer> row = new HashSet<>();
            for (int j=0; j<9; j++){
                if (board[i][j] != '.'){
                    int cur = board[i][j] - '0';
                    if(!row.add(cur)){
                        return false;
                    }
                    if (!col.get(j).add(cur)){
                        return false;
                    }
                    if (!map.get((i/3) * 3 + (j/3)).add(cur)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku0036 validSudoku0036 = new ValidSudoku0036();
        System.out.println(validSudoku0036.isValidSudoku(board));
    }
}
