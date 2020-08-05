package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 11:02
 */
public class WordSearch0079 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'}
                                     ,{'S','F','E','S'}
                                     ,{'A','D','E','E'}};
        String word = "ABCEFSADEESE";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        char[][] point = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (recursion(board,point,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean recursion(char[][] board, char[][] point, String word, int index, int x, int y) {
        if (index == word.length()){
            return true;
        }
        else{
            if ((x>=0&&x< board.length)&&(y>=0&&y< board[0].length)&&(point[x][y]==0)){
                if (board[x][y] == word.charAt(index)){
                    point[x][y] = 1;
                    if (recursion(board,point,word,index+1,x+1,y)){
                        return true;
                    }
                    if (recursion(board,point,word,index+1,x,y+1)){
                        return true;
                    }
                    if (recursion(board,point,word,index+1,x-1,y)){
                        return true;
                    }
                    if (recursion(board,point,word,index+1,x,y-1)){
                        return true;
                    }
                    point[y][x] = 0;
                    //return Recursion(board,point,word,index,x+1,y)
                    //        ||Recursion(board,point,word,index,x,y+1)
                    //        ||Recursion(board,point,word,index,x-1,y)
                    //        ||Recursion(board,point,word,index,x,y-1);
                }
            }
        }
        return false;
    }

    //private boolean[][] marked;
    //
    ////        x-1,y
    //// x,y-1  x,y    x,y+1
    ////        x+1,y
    //private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    //// 盘面上有多少行
    //private int m;
    //// 盘面上有多少列
    //private int n;
    //private String word;
    //private char[][] board;
    //
    //public boolean exist(char[][] board, String word) {
    //    m = board.length;
    //    if (m == 0) {
    //        return false;
    //    }
    //    n = board[0].length;
    //    marked = new boolean[m][n];
    //    this.word = word;
    //    this.board = board;
    //
    //    for (int i = 0; i < m; i++) {
    //        for (int j = 0; j < n; j++) {
    //            if (dfs(i, j, 0)) {
    //                return true;
    //            }
    //        }
    //    }
    //    return false;
    //}
    //
    //private boolean dfs(int i, int j, int start) {
    //    if (start == word.length() - 1) {
    //        return board[i][j] == word.charAt(start);
    //    }
    //    if (board[i][j] == word.charAt(start)) {
    //        marked[i][j] = true;
    //        for (int k = 0; k < 4; k++) {
    //            int newX = i + direction[k][0];
    //            int newY = j + direction[k][1];
    //            if (inArea(newX, newY) && !marked[newX][newY]) {
    //                if (dfs(newX, newY, start + 1)) {
    //                    return true;
    //                }
    //            }
    //        }
    //        marked[i][j] = false;
    //    }
    //    return false;
    //}
    //
    //private boolean inArea(int x, int y) {
    //    return x >= 0 && x < m && y >= 0 && y < n;
    //}
    //
    //public static void main(String[] args) {
    //
    //    char[][] board =
    //            {
    //                    {'A', 'B', 'C', 'E'},
    //                    {'S', 'F', 'E', 'S'},
    //                    {'A', 'D', 'E', 'E'}
    //            };
    //
    //    String word = "ABCEFSADEESE";
    //
    //    //char[][] board = {{'a', 'b'}};
    //    //String word = "ba";
    //    WordSearch0079 solution = new WordSearch0079();
    //    boolean exist = solution.exist(board, word);
    //    System.out.println(exist);
    //}
}
