package neetcode.arrayandhash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/23 12:36
 */
public class EncodeandDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.length()).append("@").append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int i=0;
        char[] chars = str.toCharArray();
        while (i < str.length()){
            int j=i;
            while (chars[j] != '@'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            // 3@qqq4@asdf
            res.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return res;
    }
}
