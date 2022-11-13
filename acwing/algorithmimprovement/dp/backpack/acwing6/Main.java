package acwing.algorithmimprovement.dp.backpack.acwing6;

import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/13 16:11
 */
public class Main{
    static int N = 1010,M = 20010;
    static int[][] f = new int[N][M];//所有从前i个物品中选，总体积不超过j的所有方案
    static int[] v = new int[M];//体积
    static int[] w = new int[M];//价值
    static int[] s = new int[M];//个数
    static int[] q = new int[M];//队列
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品个数
        int m = scan.nextInt();//背包容量
        for(int i = 1 ; i <= n ; i ++ ){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }

        for(int i = 1 ; i <= n ; i ++ ){
            //表示的是余数，j%v的结果肯定是小于v的所以枚举每一种r的情况
            for(int r = 0;r < v[i]; r ++ ){
                int hh = 0,tt = -1;//每一次初始化新的队列
                //体积都是按照逐加v，常规是加1，但是我们这个可不是常规哈哈
                for(int j = r;j <= m ; j += v[i]){
                    f[i][j] = f[i - 1][j];  // 不放物品i

                    //如果滑动窗口滑出了队头，那么将队头删了,队头就成了第二位置的hh+1
                    //你要记得hh是在队头，所以下标小，用最长的j 减去 队列的长s，就得出队头的下标
                    //然后跟q[hh]进行比较，因为q存的是下标

                    while(hh <= tt && q[hh] < j - v[i] * s[i]) {
                        ++hh;
                    }

                    //这里是比较新加入队列的值是不是比队尾大，如果大就要将队尾删了，将所有比他小的都删了
                    //然后将他存到队尾
                    //f[i - 1][q[tt]] + (j - q[tt]) / v[i] * w[i] ,还记得我们在过程中暂时忽略的价值w
                    //现在要重新吧它加上，然后我们由推导公式中得出
                    //加了几个v就加几个w，所以我们将枚举到的j减去我们队尾的坐标
                    //就是我们单调队列现在的长度，然后这个长度 除以 我们的价值v得出加了多少个v
                    //然后就用这个多少个乘以w，就得出这一层中需要加多少个w

                    while(hh <= tt && f[i - 1][q[tt]] + (j - q[tt]) / v[i] * w[i] <= f[i - 1][j]) {
                        tt --;
                    }

                    q[++tt] = j;//更新队列

                    // 由公式可得: 当队尾下标和当前最大值的下标之间差了x个v，那么就要加上x个w;
                    //多重背包问题用的是上一层的值，完全背包才是用的当前同层的值
                    f[i][j] = f[i - 1][q[hh]] + (j - q[hh]) / v[i] * w[i];
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
