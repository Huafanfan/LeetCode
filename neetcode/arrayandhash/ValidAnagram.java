package neetcode.arrayandhash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/19 11:27
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        char[] chars2 = t.toCharArray();
        for (char c : chars2){
            Integer count = map.get(c);
            if (count == null){
                return false;
            }
            count--;
            if (count == 0){
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }
        return map.size() == 0;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars2);
        return Arrays.equals(chars, chars2);
    }
}
