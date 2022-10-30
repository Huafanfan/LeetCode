package acwing.algorithmbasic.base.twopoints.acwing800;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/8/28 3:45 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        for (int i=0; i<m; i++){
            b[i] = in.nextInt();
        }
        for (int i=0, j=m-1; i<n; i++){
            while (j > 0 && a[i] + b[j] > x){
                j--;
            }
            if (a[i] + b[j] == x){
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
