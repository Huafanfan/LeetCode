package acwing.algorithmimprovement.dp.statecompression.acwing292;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/4 12:11
 */
public class Main {
    static int N = 110, M = 1 << 10;
    static int n, m;
    static int[] g = new int[N];
    static List<Integer> state = new ArrayList<>();
    static int[] cnt = new int[M];
    static int[][][] f = new int[2][M][M];

    /**
     * 同一行不能互相攻击
     * @param state
     * @return
     */
    static boolean check(int state) {
        for (int i=0; i<m; i++){
            if ((state >> i & 1) == 1 && ((state >> i + 1 & 1) == 1 | (state >> i + 2 & 1) == 1)){
                return false;
            }
        }
        return true;
    }

    static int count(int state){
        int res = 0;
        for (int i=0; i<m; i++){
            res += state >> i & 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i=1; i<=n; i++){
            String t = in.next();
            for (int j=0; j<m; j++){
                if (t.charAt(j) == ('H')){
                    g[i] += 1 << j;
                }

            }
        }

        for (int i=0; i< 1<<m; i++){
            if (check(i)){
                state.add(i);
                cnt[i] = count(i);
            }
        }

        for (int i=1; i<=n+2; i++){
            for (int j=0; j<state.size(); j++){
                for (int k=0; k<state.size(); k++){
                    for (int u=0; u<state.size(); u++){
                        // i-1
                        int a = state.get(j);
                        // i
                        int b = state.get(k);
                        // i-2
                        int c = state.get(u);
                        if ((a & b) != 0 | (b & c) != 0 | (a & c) != 0){
                            continue;
                        }
                        if ((g[i-1] & a) != 0 | (g[i] & b) != 0){
                            continue;
                        }
                        f[i & 1][j][k] = Math.max(f[i & 1][j][k], f[i-1 & 1][u][j] + cnt[b]);

                    }
                }
            }
        }

        System.out.println(f[n+2 & 1][0][0]);
    }
}
