package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 20:38
 */
public class DesignTicTacToe0348 {
    int[][] board;
    public DesignTicTacToe0348(int n) {
        board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        int isWin = player;
        for (int i=0; i<board.length; i++){
            if (board[row][i] != player){
                isWin = 0;
                break;
            }
        }
        if (isWin != 0){
            return isWin;
        }
        isWin = player;
        for (int i=0; i<board[0].length; i++){
            if (board[i][col] != player){
                isWin = 0;
                break;
            }
        }
        if (isWin != 0){
            return isWin;
        }
        isWin = player;
        if (row == col){
            for (int i=0; i<board.length; i++){
                if (board[i][i] != player){
                    isWin = 0;
                    break;
                }
            }
            if (isWin != 0){
                return isWin;
            }
        }
        isWin = player;
        if (row + col == board.length - 1){
            for (int i=0; i<board.length; i++){
                if (board[i][board.length - i - 1] != player){
                    isWin = 0;
                    break;
                }
            }
            return isWin;
        }
        return 0;
    }
}
