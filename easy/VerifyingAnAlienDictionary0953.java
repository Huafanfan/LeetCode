package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/17 10:34
 */
public class VerifyingAnAlienDictionary0953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = order.toCharArray();
        for (int i=0; i<chars.length; i++){
            map.put(chars[i], i);
        }
        for (int i=1; i<words.length; i++){
            int length = Math.min(words[i-1].length(),words[i].length());
            boolean isMatch = false;
            for (int j=0; j<length; j++){
                char c1 = words[i-1].charAt(j);
                char c2 = words[i].charAt(j);
                if (c1 != c2){
                    if (map.get(c1) > map.get(c2)){
                        return false;
                    }
                    else {
                        isMatch = true;
                        break;
                    }
                }
            }
            if (!isMatch && words[i-1].length() > words[i].length()){
                return false;
            }
        }
        return true;
    }
}
