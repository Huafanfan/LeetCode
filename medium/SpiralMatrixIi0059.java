package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixIi0059 {
    enum STATU
    {
        One, Two, Three, Four;
    };
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cycle = 0;
        int size = 1;
        STATU status = STATU.One;
        while (size <= n * n) {
            switch (status) {
                case One:
                    for (int i = cycle; i < n - cycle; i++) {
                        res[cycle][i] = size++;
                    }
                    status = STATU.Two;
                    break;
                case Two:
                    for (int i = cycle + 1; i < n - cycle; i++) {
                        res[i][n - 1 - cycle] = size++;
                    }
                    status = STATU.Three;
                    break;
                case Three:
                    for (int i = n - 2 - cycle; i >= cycle; i--) {
                        res[n - cycle - 1][i] = size++;
                    }
                    status = STATU.Four;
                    break;
                case Four:
                    for (int i = n - 2 - cycle; i >= cycle + 1; i--) {
                        res[i][cycle] = size++;
                    }
                    status = STATU.One;
                    cycle++;
                    break;
                default:
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixIi0059 spiralMatrixIi0059 = new SpiralMatrixIi0059();
        System.out.println(Arrays.deepToString(spiralMatrixIi0059.generateMatrix(3)));
    }
}
