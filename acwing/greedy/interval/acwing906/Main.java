package acwing.greedy.interval.acwing906;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/10/23 16:06
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
        Arrays.sort(ranges, Comparator.comparingInt(o -> o.l));
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<n; i++){
            Range r = ranges[i];
            if (heap.isEmpty() || heap.peek() >= r.l){
                heap.add(r.r);
            } else {
                heap.poll();
                heap.add(r.r);
            }
        }
        System.out.println(heap.size());
    }
}
