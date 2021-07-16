package byteDance;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    int longestSubstring(String s, int k) {
        if (s.length() == 0 || k <= 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int maxLen = 1;
        while (right < s.length()){
            if (!map.containsKey(s.charAt(right))){
                count++;
            }
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            right++;
            while (count > k){
                if (map.get(s.charAt(left)) == 1){
                    count--;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters longestSubstringWithAtMostKDistinctCharacters = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(longestSubstringWithAtMostKDistinctCharacters.longestSubstring("eceba", 2));
    }
}
