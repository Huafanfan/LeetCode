package acwing.algorithmbasic.math.inclusionexclusionprinciple.acwing890;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/22 10:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] p = new int[m];
        for (int i=0; i<m; i++){
            p[i] = in.nextInt();
        }
        int res = 0;
        for (int i=1; i< (1<<m); i++){
            long t = 1;
            int cnt = 0;
            for (int j=0; j<m; j++){
                if ((i >> j & 1) == 1){
                    cnt++;
                    if (t * p[j] > n){
                        t = -1;
                        break;
                    }
                    t *= p[j];
                }
            }
            if (t != -1){
                if (cnt % 2 == 1){
                    res += n/t;
                }else {
                    res -= n/t;
                }
            }
        }
        System.out.println(res);
    }
}
