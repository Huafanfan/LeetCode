package neetcode.slidingwindows;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/2 11:24
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0;
        int l = 0;
        for (int r=0; r<s.length(); r++){
            count[s.charAt(r) - 'A']++;
            while ((r - l + 1) - Arrays.stream(count).max().getAsInt()> k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int characterReplacement2(String s, int k) {
        int[] count = new int[26];
        int res = 0;
        int l = 0;
        int maxf = 0;
        for (int r=0; r<s.length(); r++){
            count[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, count[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxf> k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
