package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 09:15
 */
public class WordPattern0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i=0; i<pattern.length(); i++){
            Character key = pattern.charAt(i);
            String value = map.get(key);
            if ((value) == null){
                if (map2.get(strings[i]) != null){
                    return false;
                }
                map.put(key, strings[i]);
                map2.put(strings[i], key);
            }
            else {
                if (!value.equals(strings[i])){
                    return false;
                }
                else if (!map2.get(value).equals(key)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern0290 wordPattern0290 = new WordPattern0290();
        System.out.println(wordPattern0290.wordPattern("abc", "a b a"));
    }
}
