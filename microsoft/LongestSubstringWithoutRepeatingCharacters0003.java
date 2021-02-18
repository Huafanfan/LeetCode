package microsoft;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters0003 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int rk = -1;
        for (int i=0; i<len; i++){
            if (i != 0) {
                set.remove(chars[i-1]);
            }
            while (rk + 1 < len && set.add(chars[rk + 1])) {
                ++rk;
            }
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }
}
