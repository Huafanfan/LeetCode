package acwing.highprecision.acwing791;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/4 12:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String a = in.next();
        String b = in.next();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int i=a.length()-1; i>=0; i--){
            aList.add(a.charAt(i) - '0');
        }
        for (int i=b.length()-1; i>=0; i--){
            bList.add(b.charAt(i) - '0');
        }
        List<Integer> cList = add(aList, bList);
        for (int i=cList.size()-1; i>=0; i--){
            System.out.print(cList.get(i));
        }
    }

    public static List<Integer> add(List<Integer> A, List<Integer> B){
        List<Integer> C = new ArrayList<>();
        int carry = 0;
        for (int i=0; i<A.size() || i<B.size(); i++){
            if (i < A.size()){
                carry += A.get(i);
            }
            if (i < B.size()){
                carry += B.get(i);
            }
            C.add(carry % 10);
            carry /= 10;
        }
        if (carry > 0){
            C.add(carry);
        }
        return C;
    }
}
