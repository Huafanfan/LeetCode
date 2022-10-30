package acwing.algorithmimprovement.dp.digitaltrianglemodel.acwing1027;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/30 16:53
 */
public class Main {
    static int N = 20;
    //含义是从（1,1）开始分别走到(i1,k - i1) (i2,k - i2)的路径的最大值
    static int[][][] f = new int[N + N][N][N];
    static int[][] w = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (true){
            int x = in.nextInt();
            int y = in.nextInt();
            int c = in.nextInt();
            if (x == 0 && y == 0 && c == 0) {
                break;
            }
            w[x][y] = c;
        }
        //因为我们是两条路径同时走，所以路径之和一开始就是2，一步+一步，最少就是2，最后一步就2倍n
        for (int k = 2 ; k <= n + n ; k ++ )
        {
            //i1是第一条路径的横坐标，一开始从1开始，走到n
            for (int i1 = 1 ; i1 <= n ; i1 ++ )
            {
                //i2是第二条路径的横坐标，一开始也从1开始，走到n
                for (int i2 = 1 ; i2 <= n ; i2 ++ ){
                    //算出两条路径他们各自每一步的纵坐标
                    int j1 = k - i1,j2 = k - i2;
                    //判断他们这些纵坐标有没有越界
                    if (j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n){
                        //如果两个点重合了，那就只用加一次，随便先加哪一个都行，
                        //因为两条路径同时走，他们可以走重复的点，但是带走点上面的值只能带一次
                        //所以第一条路径加也行，第二条路径同理
                        int t = w[i1][j1];
                        //如果没有重合 ，这里就判断横坐标就行，代码短一点
                        //横坐标不同，他们就不重合了，再加上另外一个点上面的值
                        if(i1 != i2) {
                            t += w[i2][j2];
                        }
                        //接下来时是两条路的是四种情况，0表示向右，1表示向下
                        //下下11   右下01   下右10   右右00

                        //解释
                        //(1,1)走到(k - i1)(k - i2) 路径的最大值
                        //求的时候每一种状态时候，dp问题都是看最后一步是怎么来的
                        //第一种就是下下，两种路径的上一步都是从上面走下来，
                        //所以加上上一步的路径再加上当前走到的两个点的值
                        //以下三种情况同理
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1 - 1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1 - 1][i2] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1][i2] + t);
                    }
                }
            }
        }

        //输出就是最后一步(1,1)分别走到了终点(n,(n + n) - n) (n,(n + n) - n) 的路径的最大值
        //为什么是n + n 呢，因为k是等于路径的横纵坐标之和，所以只用看一条，终点是(n,n),所以就是n+n
        System.out.println(f[n + n][n][n]);
    }
}
