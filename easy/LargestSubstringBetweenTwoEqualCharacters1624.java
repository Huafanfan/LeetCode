package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yifan.zhangyf
 * @date 2022/9/17 3:36 PM
 */
public class LargestSubstringBetweenTwoEqualCharacters1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++){
            if (map.containsKey(chars[i])){
                maxLength = Math.max(maxLength, i - 1 - (map.get(chars[i]) + 1) + 1);
            } else {
                map.put(chars[i], i);
            }
        }
        return maxLength;
    }
}
