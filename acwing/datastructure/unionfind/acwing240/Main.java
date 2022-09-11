package acwing.datastructure.unionfind.acwing240;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/11 5:06 PM
 */
public class Main {
    static int[] p;
    /**
     * 当前元素到父元素的距离
     */
    static int[] d;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        p = new int[n+1];
        d = new int[n+1];
        for (int i=1; i<=n; i++){
            p[i] = i;
            d[i] = 0;
        }
        int res = 0;
        while (m-- > 0){
            int t, x, y;
            t = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            if (x > n || y > n){
                res++;
            } else {
                int px = find(x);
                int py = find(y);
                if (t == 1){
                    if (px == py && ((d[x] - d[y]) % 3 != 0)){
                        res++;
                    } else if (px != py){
                        p[px] = py;
                        // (d[x] + ? - d[y]) % 3 == 0
                        // ? = d[y] - d[x]
                        d[px] = d[y] - d[x];
                    }
                } else {
                    if (px == py && ((d[x] - d[y] - 1) % 3 != 0)){
                        res++;
                    } else if (px != py){
                        p[px] = py;
                        // (d[x] + ? - d[y] - 1) % 3 == 0
                        // ? = d[y] + 1 - d[x]
                        d[px] = d[y] - d[x] + 1;
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static int find(int x){
        if (p[x] != x){
            int root = find(p[x]);
            d[x] += d[p[x]];
            p[x] = root;

        }
        return p[x];
    }
}
