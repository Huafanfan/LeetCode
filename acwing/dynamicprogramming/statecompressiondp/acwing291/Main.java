package acwing.dynamicprogramming.statecompressiondp.acwing291;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/16 18:02
 */
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = 12,M = 1 << N;
        long[][] f = new long[N][M];
        int[][] state = new int[M][M];
        boolean[] st = new boolean[M];

        while(true){
            int n = scan.nextInt();
            int m = scan.nextInt();
            // 如果n跟m同时为0结束循环
            if(n == 0 && m == 0){
                break;
            }
            for(int i = 0 ; i < 1 << n ; i ++ ){
                // 表示的是当前前面0的个数
                int cnt = 0;
                // 表示合法
                boolean flag = true;
                // 从上到下判断有多少个0
                for(int j = 0 ; j < n ; j ++ ){
                    //判断现在这一位是不是1
                    if((i >> j & 1) == 1){
                        //如果是1，判断一下1前面的0的个数是不是偶数，奇数就结束
                        if((cnt & 1) == 1){
                            // 判断一个数是不是奇数，&1等于1就是奇数，反之就是偶数
                            flag = false;
                            break;
                        }
                        cnt = 0;
                    }else {
                        // 如果当前不是1，0的个数+1
                        cnt ++ ;
                    }
                }
                //最后还需要判断一下最后一层0的个数是不是奇数
                if((cnt & 1) == 1) {
                    flag = false;
                }
                // 最后将这一种状态存入st数组，表示true合法或者false非合法
                st[i] = flag;
            }
            //这是i-1 到 i列的方块
            for(int i = 0 ; i < 1 << n  ; i ++ ){
                // 将所有的状态清零，因为多组数据，防止上一组数据的影响
                Arrays.fill(state[i],0);
                //这是i-2到i-1列的方块
                for(int j = 0 ; j < 1 << n ; j ++ ){
                    // 满足这两个条件的方案合法
                    if((i & j) == 0 && st[i | j] ){
                        //1、i跟j没有相交，2、i-1列的空格数是不是偶数
                        // 表示这种方案是合法的，用1表示，0表示不合法
                        state[i][j] = 1;
                    }
                }
            }
            for(int i = 0 ; i < N ; i ++ ) {
                // 因为有多组数据，防止上一组数据的干扰，所以清零
                Arrays.fill(f[i],0);
            }
            // 什么都没有时候，空着表示一种方案
            f[0][0] = 1;
            //最后的dp部分
            //为什么从1开始呢，因为从0开始的话，我们定义的f[m][j]就是前i - 1列已经摆好
            //如果是0开始，就会从-1个开始摆好，因为我们没有-1列，所以从1开始
            for(int i = 1 ; i <= m ; i ++ ){
                //枚举i - 1 到 i的所有方案
                for(int j = 0 ; j < 1 << n ; j ++ ){
                    //枚举i - 2 到 i - 1 的所有方案
                    for(int k = 0 ; k < 1 << n ; k ++ ){
                        //现在的方案等于前面每种k方案的总和
                        if(state[j][k] == 1) {
                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }
}
