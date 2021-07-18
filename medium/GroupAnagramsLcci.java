package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/18 08:56
 */
public class GroupAnagramsLcci {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newKey = Arrays.toString(chars);
            List<String> list = map.getOrDefault(newKey, new ArrayList<>());
            list.add(str);
            map.put(newKey, list);
        }
        return new ArrayList<>(map.values());
    }
}
