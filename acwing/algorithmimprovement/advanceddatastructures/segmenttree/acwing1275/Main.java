package acwing.algorithmimprovement.advanceddatastructures.segmenttree.acwing1275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/1/2 15:30
 */
public class Main {
    static int N = 200010;
    static Node[] tr = new Node[4 * N];
    static int m, p;
    //记录上一次询问的值
    static long pre;

    static void pushup(int u){
        tr[u].maxv = Math.max(tr[u*2].maxv, tr[u*2+1].maxv);
    }

    static void build(int u, int l, int r){
        tr[u] = new Node();
        tr[u].l = l;
        tr[u].r = r;

        if (l == r){
            return;
        }

        int mid = l + r >> 1;
        build(u*2, l, mid);
        build(u*2+1, mid+1, r);
    }

    static long query(int u, int l, int r){
        if (tr[u].l >= l && tr[u].r <= r){
            return tr[u].maxv;
        }

        int mid = tr[u].l + tr[u].r >> 1;
        long maxv = 0;
        if (l <= mid){
            maxv = query(u*2, l ,r);
        }
        if (r >mid){
            maxv = Math.max(maxv, query(u*2+1, l, r));
        }
        return maxv;
    }

    static void modify(int u, int x, int maxv){
        if (tr[u].l == x && tr[u].r == x){
            tr[u].maxv = maxv;
        }else {
            int mid = tr[u].l + tr[u].r >> 1;
            if (x <= mid){
                modify(u*2, x, maxv);
            } else {
                modify(u*2+1, x, maxv);
            }
            pushup(u);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split(" ");
        m = Integer.parseInt(arr[0]);
        p = Integer.parseInt(arr[1]);

        //初始时，数组中没有元素
        int n = 0;
        build(1, 1, m);

        while(m-->0){
            String[] cur = in.readLine().split(" ");
            String op = cur[0];

            if(op.equals("Q")){
                int x = Integer.parseInt(cur[1]);
                pre = query(1, n-x+1, n);
                System.out.println(pre);
            }else{
                int num = Integer.parseInt(cur[1]);
                int a = (int) ((num + pre) % p);
                modify(1, ++n, a);
            }
        }
    }
}

class Node {
    int l, r;
    long maxv;
    public Node(){

    }
    public Node(int l, int r, long maxv){
        this.l = l;
        this.r = r;
        this.maxv = maxv;
    }
}
