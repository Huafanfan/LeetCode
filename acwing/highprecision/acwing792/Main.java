package acwing.highprecision.acwing792;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/4 13:47
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
        if (cmp(aList, bList)){
            List<Integer> cList = sub(aList, bList);
            for (int i=cList.size()-1; i>=0; i--){
                System.out.print(cList.get(i));
            }
        } else {
            List<Integer> cList = sub(bList, aList);
            for (int i=cList.size()-1; i>=0; i--){
                System.out.print(cList.get(i));
            }
        }
    }

    public static boolean cmp(List<Integer> A, List<Integer> B){
        if (A.size() != B.size()) {
            return A.size() > B.size();
        }
        for (int i=A.size()-1; i>=0; i--){
            if (!A.get(i).equals(B.get(i))){
                return A.get(i) > B.get(i);
            }
        }
        return true;
    }

    public static List<Integer> sub(List<Integer> A, List<Integer> B){
        List<Integer> C = new ArrayList<>();
        int carry = 0;
        for (int i=0; i<A.size(); i++){
            carry = A.get(i) - carry;
            if (i < B.size()){
                carry -= B.get(i);
            }
            C.add((carry + 10) % 10);
            if (carry < 0){
                carry = 1;
            } else {
                carry = 0;
            }
        }
        while (C.size() > 1 && C.get(C.size()-1) == 0){
            C.remove(C.size()-1);
        }
        return C;
    }
}
