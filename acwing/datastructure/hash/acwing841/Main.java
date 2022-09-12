package acwing.datastructure.hash.acwing841;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author yifan.zhangyf
 * @date 2022/9/12 5:15 PM
 */
public class Main {
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter log  = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        String[] s = read.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int t = Integer.parseInt(s[1]);
        String w = read.readLine();
        int P = 131;
        long[] h = new long[n + 10];
        long[] p = new long[n + 10];
        p[0] = 1;
        for(int i = 1; i <= n; i++){
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + w.charAt(i - 1);
        }
        while(t-- > 0){
            s = read.readLine().split(" ");
            int l1 = Integer.parseInt(s[0]);
            int r1 = Integer.parseInt(s[1]);
            int l2 = Integer.parseInt(s[2]);
            int r2 = Integer.parseInt(s[3]);
            String out = h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1] ?
                    "Yes" : "No";
            log.write(out + "\n");

        }
        log.flush();
    }
}
