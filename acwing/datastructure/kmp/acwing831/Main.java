package acwing.datastructure.kmp.acwing831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yifan.zhangyf
 * @date 2022/9/4 3:15 PM
 * 需要背模版
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] p = new char[n + 1];
        char[] tmp = br.readLine().toCharArray();
        System.arraycopy(tmp, 0, p, 1, n);

        int m = Integer.parseInt(br.readLine());
        char[] s = new char[m + 1];
        tmp = br.readLine().toCharArray();
        System.arraycopy(tmp, 0, s, 1, m);

        // next
        // next(1) == 0, 表示第一个字符失败了，从0开始
        int[] ne = new int[n + 1];
        for (int i=2, j=0; i<=n; i++){
            while (j != 0 && p[i] != p[j+1]){
                j = ne[j];
            }
            if (p[i] == p[j+1]){
                j++;
            }
            // ! 优化
            ne[i] = j;
        }

        // kmp 匹配过程
        StringBuilder sb = new StringBuilder();
        for (int i=1, j=0; i<=m; i++){
            while (j != 0 && s[i] != p[j+1]){
                j = ne[j];
            }
            if (s[i] == p[j+1]){
                j++;
            }
            if (j == n){
                sb.append(i - n + 1 - 1).append(" ");
                j = ne[j];
            }
        }
        System.out.println(sb.toString());

    }
}
