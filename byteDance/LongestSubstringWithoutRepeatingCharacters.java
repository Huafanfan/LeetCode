package byteDance;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/23 11:30
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                res = Math.max(res, right - left + 1);
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
}
