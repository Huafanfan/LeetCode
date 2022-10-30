package acwing.algorithmbasic.datastructure.monotonicstack.acwing830;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 6:04 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] stk = new int[n];
        int tt = 0;
        for (int i=0; i<n; i++){
            int x = in.nextInt();
            while (tt > 0 && stk[tt] >= x){
                tt--;
            }
            if (tt == 0){
                System.out.print(-1 + " ");
            } else {
                System.out.print(stk[tt] + " ");
            }
            stk[++tt] = x;
        }
    }
}
