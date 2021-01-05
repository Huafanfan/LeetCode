package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/5 14:17
 */
public class PositionsofLargeGroups0830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<s.length();){
            int j = i;
            while (j<s.length() && s.charAt(j) == s.charAt(i)){
                j++;
            }
            if (j - i >= 3){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j-1);
                res.add(tmp);
            }
            i = j;
        }
        return res;
    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        PositionsofLargeGroups0830 positionsofLargeGroups0830 = new PositionsofLargeGroups0830();
        System.out.println(positionsofLargeGroups0830.largeGroupPositions("abbxxxxzzy"));
    }
}
