package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/7/31 14:25
 */
public class GroupAnagrams0049 {
    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(test));
    }

    /**
     * 不对，只考虑了字母的权值，未考虑存在字母不同，权值相同
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Character,Integer> numberMapper = new HashMap<>();
        Map<Integer,Integer> sumKind = new HashMap<>();
        int kind = 0;
        for (int i=0;i<26 ; i++){
            int a = 'a' + i;
            numberMapper.put((char)a,a);
        }
        for (String str : strs){
            char[] str_char = str.toCharArray();
            int sum=0;
            for (int i = 0; i< str_char.length; i++){
                sum += numberMapper.get(str_char[i]);
            }
            if (!sumKind.containsKey(sum)){
                sumKind.put(sum,kind);
                result.add(kind++,new ArrayList<>());
            }
            int index = sumKind.get(sum);
            result.get(index).add(String.valueOf(str_char));

        }
        return result;
    }
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
