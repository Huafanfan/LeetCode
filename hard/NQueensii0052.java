package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/17 09:26
 */
public class NQueensii0052 {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return backtace(n, 0, columns, diagonals1, diagonals2);
    }
    public int backtace(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if (row == n){
            return 1;
        }
        else {
            int count = 0;
            for (int i = 0; i < n; i++){
                if (columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtace(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
    public int totalNQueensBits(int n) {
        return backtace(n, 0, 0, 0, 0);
    }
    public int backtace(int n, int row, int columns, int diagonals1, int diagonals2){
        if (row == n){
            return 1;
        }
        else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0){
                /**
                 * 负数的二进制为其绝对值的反码加1(补码)
                 * 6 ： 0 0110
                 * -6： 1 1010
                 * 所以一个数与自己的负数，就可以取得最低非0位
                 */
                int position = availablePositions & (-availablePositions);
                /**
                 * 6 : 0110
                 * 5:  0101
                 * 6 & 5 可以将6的最低1位 置为0
                 */
                availablePositions = availablePositions & (availablePositions - 1);
                count += backtace(n, row + 1, columns | position, (diagonals1 | position) >> 1, (diagonals2 | position) << 1);

            }
            return count;
        }
    }

    public static void main(String[] args) {
        NQueensii0052 nQueensii0052 = new NQueensii0052();
        System.out.println(nQueensii0052.totalNQueensBits(8));
    }
}
