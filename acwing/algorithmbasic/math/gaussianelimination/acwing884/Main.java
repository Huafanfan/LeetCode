package acwing.algorithmbasic.math.gaussianelimination.acwing884;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/4 16:10
 */
public class Main {
    static int[][] a;

    static int gauss(int n){
        int col, row;
        for (col=0, row=0; col<n; col++){
            int t = row;

            for (int i=row; i<n; i++){
                if (a[i][col] !=0){
                    t = i;
                    break;
                }
            }

            if (a[t][col] == 0){
                continue;
            }

            // 把当前这一行，换到最上面（不是第一行，是第 r 行）去
            for (int i=col; i<n+1; i++){
                int tmp = a[t][i];
                a[t][i] = a[row][i];
                a[row][i] = tmp;
            }


            // 把当前列下面的所有数，全部消成 0
            for (int i = row+1; i<n; i++){
                // 如果非0 再操作，已经是 0就没必要操作了
                if (a[i][col] != 0){
                    for (int j=n; j>=col; j--){
                        a[i][j] ^= a[row][j];
                    }
                }
            }
            // 这一行的工作做完，换下一行
            row++;
        }

        if (row < n){
            for (int i = row; i < n; i++){
                if (a[i][n] != 0){
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
                a[i][n] ^= a[i][j] & a[j][n];
            }
        }
        // 唯一解
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        a = new int[n][n + 1];
        for (int i=0; i<n; i++){
            for (int j=0; j<n+1; j++){
                a[i][j] = in.nextInt();
            }
        }
        int t = gauss(n);
        if (t == 0){
            for (int i=0; i<n; i++){
                System.out.println(a[i][n]);
            }
        } else if (t == 1){
            System.out.println("Multiple sets of solutions");
        } else {
            System.out.println("No solution");
        }
    }
}
