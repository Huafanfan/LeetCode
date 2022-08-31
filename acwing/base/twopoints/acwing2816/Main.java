package acwing.base.twopoints.acwing2816;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/8/28 4:56 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        for (int i=0; i<m; i++){
            b[i] = in.nextInt();
        }
        int i=0, j=0;
        while (i<n && j<m){
            if (a[i] == b[j]){
                i++;
            }
            j++;
        }
        if (i == n){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
