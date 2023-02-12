package acwing.algorithmimprovement.dp.statecompression.acwing1064;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/4 12:10
 */
public class Main {
    static int N = 12, M = 1 << 10, K = 110;
    static int n, m;
    /**
     * 所有合法状态
     */
    static List<Integer> state = new ArrayList<>();
    /**
     * 当前状态中的1的个数
     */
    static int[] cnt = new int[M];

    /**
     * 每个状态(下标)可以转移到的其他的状态(下标)
     */
    static ArrayList<Integer>[] head = new ArrayList[M];

    static long[][][] f = new long[N][K][M];

    /**
     * 检查是否存在两个连续的1
     * @param state
     * @return
     */
    static boolean check(int state) {
        for (int i=0; i<n; i++){
            if ((state >> i & 1) == 1 && (state >> i + 1 & 1) == 1){
                return false;
            }
        }
        return true;
    }

    static int count(int state){
        int res = 0;
        for (int i=0; i<n; i++){
            if ((state >> i & 1) == 1){
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i=0; i< 1<<n; i++){
            if (check(i)){
                state.add(i);
                cnt[i] = count(i);
            }
        }
        for (int i=0; i<state.size(); i++){
            for (int j=0; j<state.size(); j++) {
                int a = state.get(i);
                int b = state.get(j);
                if ((a & b) == 0 && check(a | b)) {
                    if(head[i] == null){
                        head[i] = new ArrayList<>();
                    }
                    head[i].add(j);
                }
            }
        }

        ////所有都不选，一个都不放，状态是0的情况  存在
        f[0][0][0] = 1;
        // n+1是为了最后直接输出
        for (int i=1; i<=n+1; i++){
            for (int j=0; j<=m; j++){
                // a表示第i行
                for (int a=0; a<state.size(); a++){
                    // b表示第i-1行
                    for (Integer b : head[a]){
                        int c = cnt[state.get(a)];
                        if (j >= c){
                            f[i][j][a] += f[i-1][j-c][b];
                        }
                    }
                }
            }
        }
        System.out.println(f[n+1][m][0]);
    }
}
