package acwing.everyday.acwing3443;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/30 18:09
 */
public class Main {
    static int N = 20;
    static int[] keys = new int[]{0, 60, 64, 68, 72, 75, 78, 82, 85, 90};
    static double[] value = new double[]{0, 1.0, 1.5, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0};

    static int[] a = new int[N];
    static int[] b = new int[N];

    static double get(int x){
        for (int i=9; i>=0; i--){
            if (x >= keys[i]){
                return value[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        for (int i=0; i<n; i++){
            b[i] = in.nextInt();
        }

        double sum = 0, cnt = 0;
        for (int i=0; i<n; i++){
            sum += get(b[i]) * a[i];
            cnt += a[i];
        }

        System.out.printf("%.2f\n", sum / cnt);

    }
}
