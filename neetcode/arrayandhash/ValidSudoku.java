package neetcode.arrayandhash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/23 11:29
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> clo = new ArrayList<>();
        List<Set<Character>> square = new ArrayList<>();
        for (int i=0; i<9; i++){
            row.add(new HashSet<>());
            clo.add(new HashSet<>());
            square.add(new HashSet<>());
        }
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                if (row.get(i).contains(board[i][j])
                        || clo.get(j).contains(board[i][j])
                        || square.get(i / 3 * 3 + j / 3).contains(board[i][j])){
                    return false;
                }
                row.get(i).add(board[i][j]);
                clo.get(j).add(board[i][j]);
                square.get(i / 3 * 3 + j / 3).add(board[i][j]);
            }
        }
        return true;
    }
}
