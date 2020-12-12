package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 14:23
 */
public class Lcof12 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                //boolean[][] isMeet = new boolean[board.length][board[0].length];
                //if (dfs(board, i, j, word, 0, isMeet)){
                //    return true;
                //}
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 5.04%
     * 82.19%
     * @param board
     * @param i
     * @param j
     * @param word
     * @param wordIndex
     * @param isMeet
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, String word, int wordIndex, boolean[][] isMeet){
        if (wordIndex == word.length()){
            return true;
        }
        if (i<0 || i >= board.length || j<0 || j >= board[0].length || isMeet[i][j] || board[i][j] != word.charAt(wordIndex)){
            return false;
        }
        isMeet[i][j] = true;
        boolean isMatch = dfs(board, i + 1, j, word, wordIndex + 1, isMeet)||
                dfs(board, i - 1, j, word, wordIndex + 1, isMeet)||
                dfs(board, i, j + 1, word, wordIndex + 1, isMeet)||
                dfs(board, i, j - 1, word, wordIndex + 1, isMeet);
        isMeet[i][j] = false;
        return isMatch;
    }

    /**
     * 97.94%
     * 44.61%
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    /**
     * A B C E
     * S F E S
     * A D E E
     */
}