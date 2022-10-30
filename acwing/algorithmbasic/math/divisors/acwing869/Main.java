package acwing.algorithmbasic.math.divisors.acwing869;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/1 16:37
 */
public class Main {
    static List<Integer> getDivisors(int n){
        List<Integer> res = new ArrayList<>();
        for (int i=1; i <= n / i; i++){
            if (n % i == 0){
                res.add(i);
                if (i != n/i){
                    res.add(n/i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- != 0){
            List<Integer> res = getDivisors(in.nextInt());
            for (int num : res){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
