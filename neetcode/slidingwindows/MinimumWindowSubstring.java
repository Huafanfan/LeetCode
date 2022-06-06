package neetcode.slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/6 10:48
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.equals("")){
            return "";
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = mapT.size();
        int l = 0, r = 0;
        int start = 0, end = 0, length = Integer.MAX_VALUE;
        while (r != s.length()){
            char c = s.charAt(r);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
            if (mapT.containsKey(c) && mapS.get(c).equals(mapT.get(c))){
                have++;
            }
            while (have == need){
                if (r - l + 1 < length){
                    start = l;
                    end = r;
                    length = r - l + 1;
                }
                char cc = s.charAt(l);
                mapS.put(cc, mapS.get(cc) - 1);
                if (mapT.containsKey(cc) && mapS.get(cc) < mapT.get(cc)){
                    have--;
                }
               l++;
            }
            r++;
        }
        if (length == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
