package acwing.greedy.interval.acwing905;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/23 15:31
 */
public class Main {
    static int N = 100010;

    static int n;

    static class Range{
        int l, r;
        public Range(int _l, int _r){
            l = _l;
            r = _r;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        Range[] ranges = new Range[n];
        for (int i=0; i<n; i++){
            ranges[i] = new Range(in.nextInt(), in.nextInt());
        }
        Arrays.sort(ranges, Comparator.comparingInt(o -> o.r));

        int res = 0;
        int ed = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            if (ranges[i].l > ed){
                res++;
                ed = ranges[i].r;
            }
        }
        System.out.println(res);
    }
}
