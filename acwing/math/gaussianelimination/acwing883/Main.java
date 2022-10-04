package acwing.math.gaussianelimination.acwing883;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/4 15:57
 */
public class Main {
    static double eps = 1e-6;
    static double[][] a;

    static int gauss(int n){
        int col, row;
        for (col=0, row=0; col<n; col++){
            int t = row;

            // 先找到当前这一列，绝对值最大的一个数字所在的行号
            for (int i=row; i<n; i++){
                if (Math.abs(a[i][col]) > Math.abs(a[t][col])){
                    t = i;
                }
            }

            // 如果当前这一列的最大数都是 0 ，那么所有数都是 0
            if (Math.abs(a[t][col]) < eps){
                continue;
            }

            // 把当前这一行，换到最上面（不是第一行，是第 r 行）去
            for (int i=col; i<n+1; i++){
                double tmp = a[t][i];
                a[t][i] = a[row][i];
                a[row][i] = tmp;
            }

            // 把当前这一行的第一个数，变成 1， 方程两边同时除以 第一个数，必须要到着算，不然第一个数直接变1，系数就被篡改，后面的数字没法算
            for (int i=n; i>=col; i--){
                a[row][i] /= a[row][col];
            }

            // 把当前列下面的所有数，全部消成 0
            for (int i = row+1; i<n; i++){
                // 如果非0 再操作，已经是 0就没必要操作了
                if (Math.abs(a[i][col]) > eps){
                    // 从后往前，当前行的每个数字，都减去对应列 * 行首非0的数字，这样就能保证第一个数字是 a[i][0] -= 1*a[i][0];
                    for (int j=n; j>=col; j--){
                        a[i][j] -= a[row][j] * a[i][col];
                    }
                }
            }
            // 这一行的工作做完，换下一行
            row++;
        }

        if (row < n){
            for (int i = row; i < n; i++){
                if (Math.abs(a[i][n]) > eps){
                    // 无解
                    return 2;
                }
            }
            // 无穷多组解
            return 1;
        }
        // 唯一解 ↓，从下往上回代，得到方程的解
        for (int i=n-1; i>=0; i--){
            for (int j=i+1; j<n; j++){
                //因为只要得到解，所以只用对 最后一列 进行操作
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
        // 唯一解
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        a = new double[n][n + 1];
        for (int i=0; i<n; i++){
            for (int j=0; j<n+1; j++){
                a[i][j] = in.nextDouble();
            }
        }
        int t = gauss(n);
        if (t == 0){
            for (int i=0; i<n; i++){
                if (Math.abs(a[i][n]) < eps){
                    a[i][n] = 0;
                }
                System.out.format("%.2f\n", a[i][n]);
            }
        } else if (t == 1){
            System.out.println("Infinite group solutions");
        } else {
            System.out.println("No solution");
        }
    }
}
