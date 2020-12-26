package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/25 15:32
 */
public class q02 {
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s1.length(); i++){
            Integer count = map.getOrDefault(s1.charAt(i), 0);
            count++;
            map.put(s1.charAt(i), count);
        }
        for (int i=0; i<s2.length(); i++){
            Integer count = map.getOrDefault(s2.charAt(i), 0);
            if (count<1){
                return false;
            }
            count--;
            if (count == 0){
                map.remove(s2.charAt(i));
            }
            else {
                map.put(s2.charAt(i), count);
            }
        }
        return true;
    }
}
