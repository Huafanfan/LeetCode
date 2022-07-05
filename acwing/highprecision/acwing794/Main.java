package acwing.highprecision.acwing794;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 16:16
 */
public class Main {
    public static class Res {
        int r;
        List<Integer> C;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String a = in.next();
        int b = in.nextInt();
        if (b == 0){
            System.out.println(0);
            return;
        }
        List<Integer> A = new ArrayList<>();
        for (int i=a.length()-1; i>=0; i--){
            A.add(a.charAt(i) - '0');
        }
        Res res = div(A, b);
        for (int i=res.C.size()-1; i>=0; i--){
            System.out.print(res.C.get(i));
        }
        System.out.println();
        System.out.println(res.r);
    }

    public static Res div(List<Integer> A, int b){
        Res res = new Res();
        res.C = new ArrayList<>();
        for (int i=A.size()-1; i>=0; i--){
            res.r = res.r * 10 + A.get(i);
            res.C.add(res.r / b);
            res.r %= b;
        }
        Collections.reverse(res.C);
        while (res.C.size() > 1 && res.C.get(res.C.size()-1) == 0){
            res.C.remove(res.C.size()-1);
        }
        return res;
    }
}
