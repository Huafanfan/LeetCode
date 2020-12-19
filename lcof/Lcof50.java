package lcof;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/19 14:02
 */
public class Lcof50 {
    /**
     * 99.38%
     * 63.79%
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars){
            arr[ch -'a'] ++;
        }
        for (char c:chars){
            if (arr[c-'a'] == 1){
                return c;
            }
        }
        return ' ';
    }

    /**
     * 64.96%
     * 89.49%
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for(char c : sc) {
            if(dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Lcof50 lcof50 = new Lcof50();
        System.out.println(lcof50.firstUniqChar("leetcode"));
    }
}
