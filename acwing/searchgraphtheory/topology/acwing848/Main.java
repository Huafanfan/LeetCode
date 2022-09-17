package acwing.searchgraphtheory.topology.acwing848;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/9/17 6:12 PM
 */
public class Main {
    static int N = 100010;
    static int n, m;
    static int[] h = new int[N];
    static int idx;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    /**
     * 入度
     */
    static int[] d = new int[N];
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            d[b]++;
        }
        if (topSort()){
            for (int i=0; i<n; i++){
                System.out.print(ans.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean topSort(){
        int count = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=1; i<=n; i++){
            if (d[i] == 0){
                q.addLast(i);
                ans.add(i);
            }
        }
        while (!q.isEmpty()){
            int t = q.pollFirst();
            for (int index = h[t]; index != -1; index = ne[index]){
                int j = e[index];
                d[j]--;
                if (d[j] == 0){
                    q.addLast(j);
                    ans.add(j);
                }
            }
        }
        return ans.size() == n;
    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }
}
