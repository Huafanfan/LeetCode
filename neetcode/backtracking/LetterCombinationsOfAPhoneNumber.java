package neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
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
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0){
            return ans;
        }
        backtrace(0, digits, new StringBuilder(), ans);
        return ans;
    }

    public void backtrace(int index, String digits, StringBuilder sb, List<String> ans){
        if (index == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            backtrace(index+1, digits, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations("23"));
    }
}
