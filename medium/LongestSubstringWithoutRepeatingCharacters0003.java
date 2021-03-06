package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/23 13:26
 */
public class LongestSubstringWithoutRepeatingCharacters0003 {
    public int lengthOfLongestSubstring1(String s){
        Set<Character> occ = new HashSet<>();
        int rk=0,ans=0;
        for (int i=0; i<s.length(); i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            while (rk<s.length()&&!occ.contains(s.charAt(rk))){
                occ.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans,rk-i);
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j=0; j<s.length(); j++){
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
