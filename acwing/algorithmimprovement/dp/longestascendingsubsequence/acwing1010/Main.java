package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing1010;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/6 16:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        List<Integer> q = new ArrayList<>();
        while (in.hasNext()){
            q.add(in.nextInt());
        }
        int n = q.size();
        int[] f = new int[n];
        int res = 0;
        for (int i=0; i<n; i++){
            f[i] = 1;
            for (int j=0;j<i; j++){
                if (q.get(j) >= q.get(i)){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);

        int cnt = 0;
        // g数组保证单调递增
        int[] g = new int[n];
        for (int i=0; i<n; i++){
            int k = 0;
            while (k < cnt && g[k] < q.get(i)){
                k++;
            }
            g[k] = q.get(i);
            if (k >= cnt){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
