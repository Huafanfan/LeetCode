package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 17:35
 */
public class LetterCombinationsOfAPhoneNumber0017 {
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        tracback(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void tracback(String digits, int index, StringBuilder path, List<String> res){
        if (index == digits.length()){
            res.add(path.toString());
            return;
        }
        String words = map.get(digits.charAt(index));
        for (int i=0; i<words.length(); i++){
            path.append(words.charAt(i));
            tracback(digits, index + 1, path, res);
            path.deleteCharAt(path.length()-1);
        }
    }
}
