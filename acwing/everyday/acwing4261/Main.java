package acwing.everyday.acwing4261;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/29 21:54
 */
public class Main {
    static int N = 500010;
    static int n;
    static int[] l = new int[N], r = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String s = in.next();
        char[] str = s.toCharArray();
        for (int i=0, h=0, g=0; i<n; i++){
            if (str[i] == 'G'){
                l[i] = h;
                h = 0;
                g++;
            }else {
                l[i] = g;
                g = 0;
                h++;
            }
        }
        for (int i=n-1, h=0, g=0; i>=0; i--){
            if (str[i] == 'G'){
                r[i] = h;
                h = 0;
                g++;
            }else {
                r[i] = g;
                g = 0;
                h++;
            }
        }

        long res = 0;
        for (int i=0; i<n; i++){
            res += (long) l[i] * r[i] + Math.max(l[i]-1, 0) + Math.max(r[i]-1, 0);
        }
        System.out.println(res);
    }
}
