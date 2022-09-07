package acwing.datastructure.unionfind.acwing836;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/7 10:45 PM
 */
public class Main {
    static List<Integer> p = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i=0; i<=n; i++){
           p.add(i);
        }
        while (m-- > 0){
            String cmd = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            if ("M".equals(cmd)){
                p.set(find(a), find(b));
            }else {
                if (find(a) == find(b)){
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    /**
     * 返回x的祖宗节点 + 路径压缩
     * @param x
     * @return
     */
    public static int find(int x){
        if (p.get(x) != x){
            p.set(x, find(p.get(x)));
        }
        return p.get(x);
    }
}
