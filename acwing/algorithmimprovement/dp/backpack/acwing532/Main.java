package acwing.algorithmimprovement.dp.backpack.acwing532;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/12 17:01
 */
public class Main{
    static int N = 110,M = 25010;
    static int n;
    static int[] f = new int[M];
    static int[] a = new int[M];
    public static void main(String[] ars){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            n = scan.nextInt();
            for(int i = 1 ; i <= n ; i ++ ){
                a[i] = scan.nextInt();
            }
            Arrays.sort(a,1,n + 1);

            // 因为有多组数据
            Arrays.fill(f,0);
            f[0] = 1;

            int res = 0;
            //前i-1个数中选，体积能不能恰好等于a[i]的方案
            for(int i = 1; i <= n ; i ++ ){
                if(f[a[i]] == 0) {
                    //最主要就是这一句体现整个的答案的思路，其他就是一个完全背包问题
                    res ++;
                }
                //小于我们的最大值，最大不能超过a[n],排完序之后最大
                for(int j = a[i]; j <= a[n]; j++ ){
                    f[j] += f[j - a[i]];
                }
            }
            System.out.println(res);
        }
    }
}
