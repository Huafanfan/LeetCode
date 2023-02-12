package acwing.everyday.acwing4653;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/1/4 22:27
 */
public class Main {
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        PrintWriter op = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = ip.nextInt(), m = ip.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; ++i) {
            a[i] = i + 1;
        }
        Arrays.sort(a, Comparator.comparingInt((Integer o) -> {
            int ans = 0;
            for (; o != 0; o /= 10) {
                ans += o % 10;
            }
            return ans;
        }).thenComparingInt(o -> o));
        op.println(a[m - 1]); op.flush();
    }
}

class InputReader {
    private final BufferedReader buf;
    private StringTokenizer tkl;

    public InputReader(InputStream is) {
        buf = new BufferedReader(new InputStreamReader(is));
    }

    public boolean hasNext() {
        try {
            while (tkl == null || !tkl.hasMoreElements()) {
                tkl = new StringTokenizer(buf.readLine());
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String next() {
        return hasNext() ? tkl.nextToken() : null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
