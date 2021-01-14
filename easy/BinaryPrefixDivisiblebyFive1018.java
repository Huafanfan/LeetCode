package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/14 09:06
 */
public class BinaryPrefixDivisiblebyFive1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        long num = 0;
        for (int j : A) {
            num = ((num << 1) + j) % 5;
            res.add(num == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryPrefixDivisiblebyFive1018 binaryPrefixDivisiblebyFive1018 = new BinaryPrefixDivisiblebyFive1018();
        int[] A = new int[]{1,1,1,0,1};
        System.out.println(binaryPrefixDivisiblebyFive1018.prefixesDivBy5(A));
    }
}
