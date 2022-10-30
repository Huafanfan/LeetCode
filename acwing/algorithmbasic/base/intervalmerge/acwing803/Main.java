package acwing.algorithmbasic.base.intervalmerge.acwing803;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/8/30 11:20 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        List<int[]> segs = new ArrayList<>();
        while (n-- > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            segs.add(new int[]{l, r});
        }
        segs.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        int st = Integer.MIN_VALUE;
        int ed = Integer.MIN_VALUE;
        for (int[] seg : segs){
            if (seg[0] > ed){
                if (st != Integer.MIN_VALUE){
                    ans.add(new int[]{st, ed});
                }
                st = seg[0];
                ed = seg[1];
            } else {
                ed = Math.max(ed, seg[1]);
            }
        }
        if (st != Integer.MIN_VALUE){
            ans.add(new int[]{st, ed});
        }
        System.out.println(ans.size());
    }
}
