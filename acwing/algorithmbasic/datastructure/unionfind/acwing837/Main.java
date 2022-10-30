package acwing.algorithmbasic.datastructure.unionfind.acwing837;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/11 4:48 PM
 */
public class Main {
    static int[] p;
    static int[] size;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        p = new int[n+1];
        size = new int[n+1];
        for (int i=0; i<=n; i++){
            p[i] = i;
            size[i] = 1;
        }
        while (m-- > 0){
            String cmd = in.next();
            int a, b;
            if ("C".equals(cmd)){
                a = in.nextInt();
                b = in.nextInt();
                if (find(a) == find(b)){
                    continue;
                }
                size[find(b)] += size[find(a)];
                p[find(a)] = find(b);
            }else if ("Q1".equals(cmd)){
                a = in.nextInt();
                b = in.nextInt();
                if (find(a) == find(b)){
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }else {
                a = in.nextInt();
                System.out.println(size[find(a)]);
            }
        }
    }

    /**
     * 返回x的祖宗节点 + 路径压缩
     * @param x
     * @return
     */
    public static int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
