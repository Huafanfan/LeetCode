package microsoft;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 20:59
 */
public class GroupAnagrams0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
