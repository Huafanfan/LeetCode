package hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/16 12:06
 */
public class SudokuSolver0037 {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }
    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }


    // 二进制中1表示 对应位置已经有值了
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[][] cells = new int[3][3];

    public void solveSudoku2(char[][] board) {
        int cnt = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                char c = board[i][j];
                if(c == '.'){
                    cnt++;
                }else{
                    int n = c - '1';
                    // rows[i] |= (1 << n);
                    // cols[j] |= (1 << n);
                    // cells[i/3][j/3] |= (1 << n);
                    fillNumber(i, j, n, true);
                }
            }
        }
        backtrace(board, cnt);
    }

    private boolean backtrace(char[][] board, int cnt){
        if(cnt == 0){
            return true;
        }
        // 获取当前 候选项最少（即限制最多）的格子下标
        int[] pos = getMinOkMaskCountPos(board);
        int x = pos[0], y = pos[1];
        // okMask 值为1的 位 表示 对应的数字 当前可以填入
        int okMask = getOkMask(x, y);

        for(char c='1'; c<='9'; c++){
            int index = c - '1';
            if(testMask(okMask, index)){
                fillNumber(x, y, index, true);
                board[x][y] = c;
                if(backtrace(board, cnt-1)) {
                    return true; // 题目假定唯一解
                }
                board[x][y] = '.';
                fillNumber(x, y, index, false);
            }
        }

        return false;
    }

    // n 0..8
    private void fillNumber(int x, int y, int n, boolean fill){
        // 因为回溯先选择后撤销，所以fill先true后false, false时对应位置一定是1，所以异或可行
        // rows[x] = fill ? rows[x] | (1<<n) : rows[x] ^ (1<<n);
        // cols[y] = fill ? cols[y] | (1<<n) : cols[y] ^ (1<<n);
        // cells[x/3][y/3] = fill ? cells[x/3][y/3] | (1<<n) : cells[x/3][y/3] ^ (1<<n);

        // ture set 1, false set 0
        rows[x] = fill ? rows[x] | (1<<n) : rows[x] & ~(1<<n);
        cols[y] = fill ? cols[y] | (1<<n) : cols[y] & ~(1<<n);
        cells[x/3][y/3] = fill ? cells[x/3][y/3] | (1<<n) : cells[x/3][y/3] & ~(1<<n);
    }

    private int getOkMask(int x, int y){
        return ~(rows[x] | cols[y] | cells[x/3][y/3]);
    }

    // mask 二进制 低9位 中 1的个数
    private int getOneCountInMask(int mask){
        int res = 0;
        for(int i=0; i<9; i++){
            int test = 1 << i;
            if((mask & test) != 0){
                res++;
            }
        }
        return res;
    }

    // mask 二进制 低index位 是否为 1
    private boolean testMask(int mask, int index){
        return (mask & (1 << index)) != 0;
    }

    // 获取候选项最少的位置
    private int[] getMinOkMaskCountPos(char[][] board){
        int[] res = new int[2];
        int min = 10;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == '.'){
                    int okMask = getOkMask(i, j);
                    int count = getOneCountInMask(okMask);
                    if(count < min){
                        min = count;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        SudokuSolver0037 sudokuSolver0037 = new SudokuSolver0037();
        sudokuSolver0037.solveSudoku2(a);
        System.out.println(Arrays.deepToString(a));
    }
}
