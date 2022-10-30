package acwing.algorithmbasic.greedy.pushformula.acwing125;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/29 16:59
 */
public class Main {
    static class Pair{
        int ws;
        int w;
        public Pair(int _a, int _b){
            ws = _a;
            w = _b;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Pair[] a = new Pair[n];
        for (int i=0; i<n; i++){
            int w = in.nextInt();
            int s = in.nextInt();
            a[i] = new Pair(w+s, w);
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o.ws));
        int res = Integer.MIN_VALUE;
        for (int i=0, sum = 0; i<n; i++){
            int w = a[i].w, s = a[i].ws - w;
            res = Math.max(res, sum - s);
            sum += w;
        }
        System.out.println(res);
    }
}
