package acwing.searchgraphtheory.dfs.acwing842;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/13 10:24 PM
 */
public class Main {
    static int N = 10;
    static int n;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        dfs(0);
    }
    static void dfs(int u){
        if (u == n){
            for (int i=0; i<n; i++){
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i=1; i<=n; i++){
            if (!st[i]){
                path[u] = i;
                st[i] = true;
                dfs(u+1);
                st[i] = false;
            }
        }
    }
}
