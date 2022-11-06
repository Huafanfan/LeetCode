package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing187;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/6 16:41
 */
public class Main {
    static int n;
    static int N = 60;
    static int[] h = new int[N];
    static int[] up = new int[N];
    static int[] down = new int[N];
    static boolean dfs(int depth,int u, int su, int sd){
        // 如果上升序列个数 + 下降序列个数 > 总个数是上限，则回溯
        if (depth < su + sd){
            return false;
        }
        if (u == n){
            return true;
        }
        // 枚举放到上升子序列
        boolean flag = false;
        for (int i=1; i<=su; i++){
            if (up[i] < h[u]){
                int t = up[i];
                up[i] = h[u];
                if (dfs(depth, u + 1, su, sd)){
                    return true;
                }
                up[i] = t;
                flag = true;
                // 注意由上述证明的贪心原理，只要找到第一个可以放的序列，就可以结束循环了
                break;
            }
        }
        // 如果不能放到任意一个序列后面，则单开一个新的序列
        if (!flag){
            up[su + 1] = h[u];
            if (dfs(depth, u + 1, su + 1, sd)){
                return true;
            }
        }

        // 枚举放到下降子序列
        flag = false;

        for (int i=1; i<=sd; i++){
            if (down[i] > h[u]){
                int t = down[i];
                down[i] = h[u];
                if (dfs(depth, u + 1, su, sd)){
                    return true;
                }
                down[i] = t;
                flag = true;
                break;
            }
        }
        if (!flag){
            down[sd + 1] = h[u];
            if (dfs(depth, u + 1, su, sd+1)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (true){
            n = in.nextInt();
            if (n == 0){
                return;
            }
            for (int i=0; i<n; i++){
                h[i] = in.nextInt();
            }
            int depth = 0;
            while (!dfs(depth, 0, 0, 0)){
                // 迭代加深搜索
                depth++;
            }
            System.out.println(depth);
        }
    }
}
