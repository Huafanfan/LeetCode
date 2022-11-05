package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing1012;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/5 16:25
 */
public class Main {
    static class Pair{
        int x, y;
        public Pair(int _x , int _y){
            x = _x;
            y = _y;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Pair[] pairs = new Pair[n];
        int[] f = new int[n];
        for (int i=0; i<n; i++){
            pairs[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o.x));

        int res = 0;
        for (int i=0; i<n; i++){
            f[i] = 1;
            for (int j=0; j<i; j++){
                if (pairs[i].y > pairs[j].y){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}
