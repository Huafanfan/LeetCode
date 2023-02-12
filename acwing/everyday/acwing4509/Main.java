package acwing.everyday.acwing4509;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/2/3 23:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n+1];
        double avg,sum = 0.0;
        double da,dd = 0.0;
        for (int i=0; i<n; i++){
            a[i]=in.nextInt();
            sum=sum+a[i];
        }
        avg = sum /n;
        for(int i=0;i<n;i++){
            dd=dd+(a[i]-avg)*(a[i]-avg);
        }
        da = dd /n;
        for(int i=0;i<n;i++){
            double f=(a[i]-avg)/Math.sqrt(da);
            System.out.println(f);
        }
    }
}
