package neetcode.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                boolean result = backTrace(i, j, 0, board, word);
                if (result){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrace(int i, int j, int index, char[][] board, String word){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        if (index == word.length()-1){
            return true;
        }
        board[i][j] = '#';
        if (backTrace(i + 1, j, index + 1, board, word)){
            return true;
        }
        if (backTrace(i - 1, j, index + 1, board, word)){
            return true;
        }
        if (backTrace(i, j + 1, index + 1, board, word)){
            return true;
        }
        if (backTrace(i, j - 1, index + 1, board, word)){
            return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
