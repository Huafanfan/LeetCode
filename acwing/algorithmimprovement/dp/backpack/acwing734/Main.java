package acwing.algorithmimprovement.dp.backpack.acwing734;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author yifan.zhangyf
 * @date 2022/11/26 18:17
 */
public class Main {
    static int N = 10010;
    static Node[] a = new Node[N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int cnt = 0;
        while (T-- != 0){
            cnt ++;
            int n = Integer.parseInt(in.readLine());
            int m = 0;
            for (int i=1;i <=n; i++){
                String[] cur = in.readLine().split(" ");
                int s = Integer.parseInt(cur[0]);
                int e = Integer.parseInt(cur[1]);
                int l = Integer.parseInt(cur[2]);
                a[i] = new Node(s, e, l);
                m += s;
            }
            Arrays.sort(a, 1, n+1);
            Arrays.fill(f, -0x3f3f3f3f);
            f[0] = 0;

            for (int i=1; i<=n; i++){
                int s = a[i].s;
                int e = a[i].e;
                int l = a[i].l;

                for (int j=m; j>=s; j--){
                    f[j] = Math.max(f[j], f[j-s] + e - (j-s) *l);
                }
            }
            int res = -1;
            for(int i=0; i<=m; i++) {
                res = Math.max(res, f[i]);
            }
            System.out.printf("Case #%d: %d\n",cnt, res);
        }

    }
}

class Node implements Comparable<Node> {
    int s, e, l;
    public Node(int s, int e, int l){
        this.s = s;
        this.e = e;
        this.l = l;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.s * o.l, this.l * o.s);
    }
}
