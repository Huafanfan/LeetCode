package acwing.intervalsum.acwing802;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/8/29 10:27 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        // 离散化
        int[] a = new int[300010];
        // 前缀和
        int[] s = new int[300010];

        Set<Integer> allsSet = new HashSet<>();
        List<int[]> add = new ArrayList<>();
        List<int[]> query = new ArrayList<>();
        for (int i=0; i<n; i++){
            int x = in.nextInt();
            int c = in.nextInt();
            add.add(new int[]{x, c});
            allsSet.add(x);
        }

        for (int i=0; i<m; i++){
            int l = in.nextInt();
            int r = in.nextInt();
            query.add(new int[]{l, r});
            allsSet.add(l);
            allsSet.add(r);
        }

        // 去重排序
        List<Integer> alls = new ArrayList<>(allsSet);
        Collections.sort(alls);

        // 处理插入
        for (int[] items : add){
            int x = find(items[0], alls);
            a[x] += items[1];
        }

        // 预处理前缀和
        for (int i=1; i<= alls.size(); i++){
            s[i] = s[i-1] + a[i];
        }

        // 处理查询
        for (int[] items : query){
            int l = find(items[0], alls);
            int r = find(items[1], alls);
            System.out.println(s[r] - s[l - 1]);
        }

    }

    public static int find(int x, List<Integer> list){
        int l = 0, r = list.size()-1;
        while (l < r){
            int mid = l + r >> 1;
            if (list.get(mid) >= x){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }
}
