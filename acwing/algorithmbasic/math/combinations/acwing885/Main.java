package acwing.algorithmbasic.math.combinations.acwing885;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/4 17:21
 */
public class Main {
    static int N = 2010;
    static int mod = 1000000007;
    static int[][] c = new int[N][N];

    static void init(){
        for (int i=0; i<N; i++){
            for (int j=0; j<=i; j++){
                if (j == 0){
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i-1][j] + c[i-1][j-1]) % mod;
                }
            }
        }
    }

    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- != 0){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(c[a][b]);
        }
    }
}
