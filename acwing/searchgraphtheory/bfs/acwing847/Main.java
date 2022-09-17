package acwing.searchgraphtheory.bfs.acwing847;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/17 4:46 PM
 */
public class Main {
    static int N = 100010;
    static int n, m;
    static int[] h = new int[N];
    static int idx;
    static int[] e = new int[N];
    static int[] ne = new int[N];

    static int[] d = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }
        System.out.println(bfs());
    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    static int bfs(){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        Arrays.fill(d, -1);
        d[1] = 0;
        while (!q.isEmpty()){
            int t = q.pollFirst();
            for (int index = h[t]; index != -1; index = ne[index]){
                int j = e[index];
                if (d[j] == -1){
                    d[j] = d[t] + 1;
                    q.addLast(j);
                }
            }
        }
        return d[n];
    }
}
