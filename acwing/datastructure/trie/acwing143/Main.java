package acwing.datastructure.trie.acwing143;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/5 10:09 PM
 */
public class Main {
    static int M  = 3000000;
    static int[][] son = new int[M][2];

    /**
     * 当前用到的下标。 下标是0的点，既是根节点，又是空节点。
     */
    static int idx;

    static void insert(int x){
        int p = 0;
        for (int i=30; i>=0; i--){
            int u = x >> i & 1;
            if (son[p][u] == 0){
                son[p][u] = ++ idx;
            }
            p = son[p][u];
        }
    }

    static int query(int x){
        int res = 0, p = 0;
        for (int i=30; i>=0; i--){
            int u = x >> i & 1;
            if (son[p][(u + 1) % 2] != 0){
                res += 1 << i;
                p = son[p][(u + 1) % 2];
            }else {
                p = son[p][u];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
            insert(a[i]);
        }

        int res = 0;
        for (int i=0; i<n; i++){
            res = Math.max(res, query(a[i]));
        }
        System.out.println(res);
    }
}
