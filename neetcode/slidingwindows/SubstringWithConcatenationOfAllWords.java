package neetcode.slidingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/23 11:47
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0){
            return ans;
        }
        int wordLength = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (int i=0; i<wordLength; i++){
            int left = i, right = i;
            Map<String, Integer> tmpMap = new HashMap<>();
            int count = 0;
            while (right + wordLength <= s.length()){
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (!map.containsKey(word)){
                    count = 0;
                    left = right;
                    tmpMap.clear();
                } else {
                    count++;
                    tmpMap.put(word, tmpMap.getOrDefault(word, 0) + 1);
                    while (tmpMap.get(word) > map.get(word)){
                        String first = s.substring(left, left + wordLength);
                        tmpMap.put(first, tmpMap.get(first) - 1);
                        count--;
                        left += wordLength;
                    }
                }
                if (count == words.length){
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
