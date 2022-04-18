package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/18 09:21
 */
public class LexicographicalNumbers0386 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i=1; i<=9 && i<=n; i++){
            traversal(i, n);
        }
        return res;
    }

    public void traversal(int cur, int n){
        if (cur > n){
            return;
        }
        res.add(cur);
        traversal(cur * 10, n);
        cur = cur * 10 + 1;
        for (int i=9; i>=1 && cur<=n; i--,cur++){
            traversal(cur, n);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LexicographicalNumbers0386 lexicographicalNumbers0386 = new LexicographicalNumbers0386();
        System.out.println(lexicographicalNumbers0386.lexicalOrder(100));
    }
}
