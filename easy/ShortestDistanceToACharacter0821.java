package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/19 08:46
 */
public class ShortestDistanceToACharacter0821 {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        List<Integer> index = new ArrayList<>();
        for (int i=0; i<chars.length; i++){
            if (chars[i] == c){
                index.add(i);
            }
        }
        int[] res = new int[chars.length];
        for (int i=0; i<chars.length; i++){
            int min = Integer.MAX_VALUE;
            for (Integer integer : index) {
                if (Math.abs(integer - i) < min) {
                    min = Math.abs(integer - i);
                } else {
                    break;
                }
            }
            res[i] = min;
        }
        return res;
    }

    public int[] shortestToChar2(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}
