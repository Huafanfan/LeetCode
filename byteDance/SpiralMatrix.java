package byteDance;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    enum STATU
    {
        One, Two, Three, Four;
    };
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int cycle = 0;
        STATU status = STATU.One;
        while (res.size() != row * col) {
            switch (status) {
                case One:
                    for (int i = cycle; i < col - cycle; i++) {
                        res.add(matrix[cycle][i]);
                    }
                    status = STATU.Two;
                    break;
                case Two:
                    for (int i = cycle + 1; i < row - cycle; i++) {
                        res.add(matrix[i][col - 1 - cycle]);
                    }
                    status = STATU.Three;
                    break;
                case Three:
                    for (int i = col - 2 - cycle; i >= cycle; i--) {
                        res.add(matrix[row - cycle - 1][i]);
                    }
                    status = STATU.Four;
                    break;
                case Four:
                    for (int i = row - 2 - cycle; i >= cycle + 1; i--) {
                        res.add(matrix[i][cycle]);
                    }
                    status = STATU.One;
                    cycle++;
                    break;
                default:
            }
        }
        return res;
    }

}
