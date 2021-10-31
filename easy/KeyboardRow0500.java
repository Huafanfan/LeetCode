package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/31 10:06
 */
public class KeyboardRow0500 {
    public String[] findWords(String[] words) {
        Map<Character, Integer> lineMap = new HashMap<>();
        char[] firstLine = "qwertyuiop".toCharArray();
        char[] secondLine = "asdfghjkl".toCharArray();
        char[] thirdLine = "zxcvbnm".toCharArray();
        for (char c : firstLine) {
            lineMap.put(c, 1);
        }
        for (char c : secondLine) {
            lineMap.put(c, 2);
        }
        for (char c : thirdLine) {
            lineMap.put(c, 3);
        }
        List<String> res = new ArrayList<>();
        for (String word : words){
            char[] chars = word.toLowerCase().toCharArray();
            int level = lineMap.get(chars[0]);
            boolean match = true;
            for (char c : chars){
                if (lineMap.get(c) != level){
                    match = false;
                    break;
                }
            }
            if (match){
                res.add(word);
            }
        }
        String[] result = new String[res.size()];
        for (int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
