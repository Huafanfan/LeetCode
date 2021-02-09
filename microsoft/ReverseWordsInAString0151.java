package microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/8 16:44
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 */
public class ReverseWordsInAString0151 {
    public String reverseWords(String s) {
        List<String> stringList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<s.length();){
            if (chars[i] != ' '){
                int j = i+1;
                while (j<s.length() && chars[j] != ' '){
                    j++;
                }
                stringList.add(s.substring(i, j));
                i = j+1;
            }
            else {
                i++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = stringList.size()-1; i>0; i--){
            res.append(stringList.get(i)).append(" ");
        }
        res.append(stringList.get(0));
        return res.toString();
    }
}
