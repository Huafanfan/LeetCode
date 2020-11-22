package easy;

import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/22 09:19
 */
public class ValidAnagram0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            int count = map.getOrDefault(s.charAt(i), 0);
            count++;
            map.put(s.charAt(i), count);
        }
        for (int i=0; i<t.length(); i++){
            int count = map.getOrDefault(t.charAt(i), 0);
            count--;
            if (count<0){
                return false;
            }
            else {
                map.put(t.charAt(i), count);
            }
        }
        return true;
    }
}
