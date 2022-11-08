package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yifan.zhangyf
 * @date 2022/11/8 21:46
 */
public class CountTheNumberOfConsistentStrings1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()){
            set.add(c);
        }
        int ans = 0;
        for (String s : words){
            boolean flag = true;
            for (Character c : s.toCharArray()){
                if (!set.contains(c)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                ans++;
            }
        }
        return ans;
    }
}
