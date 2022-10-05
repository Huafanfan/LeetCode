package acwing.dynamicprogramming.backpack.acwing5;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/5 16:52
 */
public class Main {
    static class Good{
        public Good(int v, int w){
            this.v = v;
            this.w = w;
        }
        int v, w;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] f = new int[m+1];
        List<Good> goods = new ArrayList<>();
        for (int i=1; i<=n; i++){
            int v = in.nextInt();
            int w = in.nextInt();
            int s = in.nextInt();
            for (int k=1; k<=s; k*=2){
                s -= k;
                goods.add(new Good(k*v, k*w));
            }
            if (s > 0){
                goods.add(new Good(s*v, s*w));
            }
        }

        for (Good good : goods){
            for (int j = m; j>=good.v; j--){
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
            }
        }
        System.out.println(f[m]);
    }
}
