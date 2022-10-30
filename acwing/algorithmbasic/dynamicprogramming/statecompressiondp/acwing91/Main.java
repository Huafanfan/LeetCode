package acwing.algorithmbasic.dynamicprogramming.statecompressiondp.acwing91;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/22 20:41
 */
public class Main {
    static int N = 20,M = 1 << N;
    static int[][] f = new int[M][N];
    static int[][] weight = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                weight[i][j] = in.nextInt();
            }
        }
        for (int i=0; i < 1 << n; i++){
            Arrays.fill(f[i], 0x3f3f3f);
        }

        f[1][0] = 0;
        for (int state=0; state<(1<<n); state++){
            //一共有多少步
            for (int j=0; j<n; j++){
                // 表示能够走到j,才能进行下一步
                // i 这个状态的第 j 位是不是1
                if ((state >> j & 1) == 1){
                    //我们用倒数第二步来化整为零
                    for (int k=0; k<n; k++){
                        //首先减掉最后一个点剩下的路径中要能够走到k才能够进行状态计算
                        // i 里面减去 j 之后的状态的第k位是不是1
                        if (((state-(1 << j)) >> k & 1) == 1){
                            //0 - k - j的途径 f[state - (1 << j)][k] + w[k][j]
                            f[state][j] = Math.min(f[state][j], f[state - (1 << j)][k] + weight[k][j]);
                        }
                    }
                }
            }
        }
        //最后输出从定义出发，不难想到，f[state][j],state表示的是二进制的全0表示都走过，j表示从0走到n-1
        System.out.println(f[(1 << n) - 1][n-1]);
    }
}
