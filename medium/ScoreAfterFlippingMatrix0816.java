package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/7 09:37
 */
public class ScoreAfterFlippingMatrix0816 {
    public int matrixScore1(int[][] A) {
        /**
         * 0 0 1 1
         * 1 0 1 0
         * 1 1 0 0
         *
         * 0 0
         * 0 1
         * 1 1
         * 0 1
         * 1 1
         * 0 0
         * 1 1
         * 0 0
         *
         * 1 1
         * 1 0
         * 1 1
         * 1 0
         * 1 1
         * 1 1
         * 1 1
         * 1 1
         */
        for (int i=0; i<A[0].length; i++){
            int count1 = 0;
            int count0 = 0;
            for (int j=0; j<A.length; j++){
                if (A[j][i] == 1){
                    count1++;
                }
                else {
                    count0++;
                }
            }
            if (count0 > count1){
                for (int j=0; j<A.length; j++){
                    A[j][i] = (A[j][i] + 1)%2;
                }
            }

            for (int j=0; j<A.length; j++){
                if (A[j][i] == 0){
                    boolean isHeight1 = false;
                    for (int k=i-1; k>=0; k--){
                        if (A[j][k] == 1){
                            isHeight1 = true;
                            break;
                        }
                    }
                    if (!isHeight1){
                        //翻转行
                        for (int k=0; k<A[0].length; k++){
                            A[j][k] = (A[j][k] + 1)%2;
                        }
                    }
                }
            }

            count1 = 0;
            count0 = 0;
            for (int j=0; j<A.length; j++){
                if (A[j][i] == 1){
                    count1++;
                }
                else {
                    count0++;
                }
            }
            if (count0 > count1){
                for (int j=0; j<A.length; j++){
                    A[j][i] = (A[j][i] + 1)%2;
                }
            }
        }
        int result = 0;
        for (int i=0; i<A.length; i++){
            StringBuilder num = new StringBuilder();
            for (int j=0; j<A[0].length; j++){
                num.append(A[i][j]);
            }
            result += Integer.parseInt(num.toString(),2);
        }
        return result;
    }

    public int matrixScore2(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                    nOnes += (1 - A[i][j]);
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix0816 scoreAfterFlippingMatrix0816 = new ScoreAfterFlippingMatrix0816();
        int[][] A = {{0,0,1,1}, {1,0,1,0}, {1,1,0,0}};
        int[][] B = {{0,0}, {0,1}, {1,1}, {0,1}, {1,1}, {0,0}, {1,1}, {0,0}};
        System.out.println(scoreAfterFlippingMatrix0816.matrixScore1(A));
    }
}
