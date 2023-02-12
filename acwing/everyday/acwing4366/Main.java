package acwing.everyday.acwing4366;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/30 17:35
 */
public class Main {
    static int N = 100010;
    static int n;
    static int[] w = new int[N];

    static boolean check(int cnt){
        for (int i=0, s=0; i<n; i++){
            s += w[i];
            if (s > cnt){
                return false;
            }
            if (s == cnt){
                s = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- != 0){
            n = in.nextInt();
            int sum = 0;
            for (int i=0; i<n; i++){
                w[i]  = in.nextInt();
                sum += w[i];
            }
            // 这里的i指合并玩最多有i堆，每堆大小为 sum / i
            for (int i=n; i!=0; i--){
                if (sum % i == 0 && check(sum / i)){
                    System.out.println(n-i);
                    break;
                }
            }
        }
    }
}
