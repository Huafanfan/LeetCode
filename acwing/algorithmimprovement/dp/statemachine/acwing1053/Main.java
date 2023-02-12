package acwing.algorithmimprovement.dp.statemachine.acwing1053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author yifan.zhangyf
 * @date 2022/12/3 21:50
 */
public class Main {
    static int N = 1010;
    static int[][] tr = new int[N][4];
    static int[] ne = new int[N];
    static int[] ma = new int[N]; // 标记某个节点是否可以走 0: 不可以 1: 可以
    static int[] q = new int[N];
    static int[][] f = new int[N][N];
    static int idx;

    static int get(char c){
        if(c == 'A') {
            return 0;
        }
        if(c == 'T') {
            return 1;
        }
        if(c == 'G') {
            return 2;
        }
        return 3;
    }

    static void insert(String str){
        char[] arr = str.toCharArray();

        int p = 0;
        for(int i=0; i<arr.length; i++){
            int u = get(arr[i]);
            if(tr[p][u] == 0) {
                tr[p][u] = ++ idx;
            }
            p = tr[p][u];
        }
        ma[p] = 1;
    }

    static void build(){
        int hh = 0; int tt = -1;

        for(int i=0; i<4; i++){
            if(tr[0][i] != 0)
                q[++ tt] = tr[0][i];
        }

        while(hh <= tt){
            int t = q[hh ++];
            for(int i=0; i<4; i++){
                int p = tr[t][i];

                if(p==0) {
                    tr[t][i] = tr[ne[t]][i];
                } else{
                    ne[p] = tr[ne[t]][i];
                    q[++ tt] = p;
                    ma[p] |= ma[ne[p]];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int T = 1;
        while((n = Integer.parseInt(in.readLine())) != 0){
            // 进行初始化
            Arrays.fill(ne, 0);
            Arrays.fill(ma, 0);
            for(int i=0; i<N; i++) {
                Arrays.fill(tr[i], 0);
            }
            idx = 0;

            for(int i=0; i<n; i++){
                String cur = in.readLine();
                insert(cur);
            }

            build();

            String str = in.readLine();
            int m = str.length();
            for(int i=0; i<N; i++) {
                Arrays.fill(f[i], 0x3f3f3f3f);
            }
            f[0][0] = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<=idx; j++){
                    for(int k=0; k<4; k++){
                        int t = get(str.charAt(i)) == k? 0 : 1;
                        int p = tr[j][k];
                        if(ma[p] != 1) {
                            f[i+1][p] = Math.min(f[i+1][p], f[i][j] + t);
                        }
                    }
                }
            }

            int res = 0x3f3f3f3f;
            for(int i=0; i<=idx; i++) {
                res = Math.min(res, f[m][i]);
            }

            if(res == 0x3f3f3f3f) {
                System.out.printf("Case %d: %d\n", T ++, -1);
            } else {
                System.out.printf("Case %d: %d\n", T ++, res);
            }
        }
    }
}
