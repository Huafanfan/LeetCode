package acwing.highprecision.acwing793;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 12:11
 */
public class Main {
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
        List<Integer> cList = mul(A, b);
        for (int i=cList.size()-1; i>=0; i--){
            System.out.print(cList.get(i));
        }
    }

    public static List<Integer> mul(List<Integer> A, int b){
        List<Integer> C = new ArrayList<>();
        int carry = 0;
        for (int i=0; i<A.size() || carry != 0; i++){
            if (i < A.size()){
                carry += A.get(i) * b;
            }
            C.add(carry % 10);
            carry /= 10;
        }
        return C;
    }
}
