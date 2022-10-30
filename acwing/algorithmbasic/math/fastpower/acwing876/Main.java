package acwing.algorithmbasic.math.fastpower.acwing876;

import java.io.*;

/**
 * @author yifan.zhangyf
 * @date 2022/10/2 16:53
 */
public class Main {
    static long qmi(int a, int k, int p){
        long res = 1;
        while (k != 0){
            if ((k & 1) != 0){
                res = res * a % p;
            }
            k >>= 1;
            a = (int) ((long) a * a % p);
        }

        return res;
    }
    public static void main(String[] args) throws IOException {
        StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int n = (int)in.nval;
        while (n-- != 0){
            in.nextToken();
            int a = (int)in.nval;
            in.nextToken();
            int p = (int)in.nval;

            if (a % p != 0){
                out.println(qmi(a, p-2, p));
            } else {
                out.println("impossible");
            }
            out.flush();
        }
    }
}
