package acwing.prefixsum.acwing795;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 17:08
 */
public class Main {
    // 前缀和 下表一定从1开始
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> a = new ArrayList<>(n+1);
        List<Integer> S = new ArrayList<>(n+1);
        // 从1开始
        a.add(0);
        S.add(0);
        for (int i=0; i<n; i++){
            a.add(in.nextInt());
        }
        for (int i=1; i<=n; i++){
            S.add(S.get(i-1) + a.get(i));
        }
        while (m-- > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(S.get(r) - S.get(l-1));
        }

    }

}
