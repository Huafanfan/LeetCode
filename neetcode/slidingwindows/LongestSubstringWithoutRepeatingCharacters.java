package neetcode.slidingwindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/31 11:09
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int longest = 0;
        char[] chars = s.toCharArray();
        for (int r=0; r<chars.length; r++){
            while (set.contains(chars[r])){
                set.remove(chars[l++]);
            }
            set.add(chars[r]);
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("tmmzuxt"));
    }
}
