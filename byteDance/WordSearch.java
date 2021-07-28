package byteDance;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (dfs(board, chars, i , j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int index){
        if (index == word.length){
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word[index]){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        if (dfs(board, word, i + 1, j, index+1)){
            board[i][j] = temp;
            return true;
        }
        if (dfs(board, word, i - 1, j, index+1)){
            board[i][j] = temp;
            return true;
        }
        if (dfs(board, word, i, j + 1, index+1)){
            board[i][j] = temp;
            return true;
        }
        if (dfs(board, word, i, j - 1, index+1)){
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {

    }
}
