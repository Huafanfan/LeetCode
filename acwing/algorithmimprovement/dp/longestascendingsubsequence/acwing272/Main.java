package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing272;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/6 17:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[][] f = new int[n+1][n+1];
        for (int i=1; i<=n; i++){
            a[i] = in.nextInt();
        }
        for (int i=1; i<=n; i++){
            b[i] = in.nextInt();
        }

//        朴素
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                //这是不包含a[i]的情况
                f[i][j] = f[i-1][j];
                //包含a[i]
                //如果a跟b相等才能够进行包含a[i],因为是b[j]结尾的，所以b[j]一定包含
                if (a[i] == b[j]){
                    //每一个最低就是自己1
                    f[i][j] = 1;
                    //然后参考最长上升子序列，枚举前就j - 1个数分别一他们为结尾统计结果
                    for (int k=1; k<j; k++){
                        //如果j > 前面j - 1个数，举例子k，那就将以b[k]结尾的最长公共子序列加上符合条件的b[j]就是加上1个
                        if (b[k] < b[j]){
                            f[i][j] = Math.max(f[i][j], f[i][k] + 1);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i=1; i<=n; i++){
            res = Math.max(res, f[n][i]);
        }
        System.out.println(res);

        // 优化
//        for (int i=1; i<=n; i++){
//            int maxv = 0;
//            for (int j=1; j<=n; j++){
//                //这是不包含a[i]的情况
//                f[i][j] = f[i-1][j];
//                //如果a跟b相等才能够进行包含a[i],因为是b[j]结尾的，所以b[j]一定包含
//                if (a[i] == b[j]){
//                    f[i][j] = Math.max(f[i][j], maxv);
//                }
//                if (b[j] < a[i]){
//                    maxv = Math.max(maxv, f[i][j] + 1);
//                }
//            }
//        }
//        int res = 0;
//        for (int i=1; i<=n; i++){
//            res = Math.max(res, f[n][i]);
//        }
//        System.out.println(res);
    }
}
