package bishi;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/6 09:46
 */
public class Solution {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> edge = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        edge.put(1, new ArrayList<>(list));

        list.clear();
        list.add(1);
        list.add(3);
        edge.put(2, new ArrayList<>(list));

        list.clear();
        list.add(2);
        list.add(6);
        list.add(4);
        edge.put(3, new ArrayList<>(list));

        list.clear();
        list.add(3);
        list.add(5);
        edge.put(4, new ArrayList<>(list));

        list.clear();
        list.add(4);
        list.add(6);
        edge.put(5, new ArrayList<>(list));

        list.clear();
        list.add(1);
        list.add(3);
        list.add(5);
        edge.put(6, new ArrayList<>(list));

        Solution solution = new Solution();
        System.out.println(solution.func(6, edge));

    }

    Set<Set<Integer>> mark = new HashSet<>();
    public int func(int n,Map<Integer, List<Integer>> edge){
        for (int i=1; i<=n; i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            dfs(i, edge, set);
        }
        return mark.size();
    }

    public void dfs(int cur, Map<Integer, List<Integer>> edge, Set<Integer> set){
        if (set.size() == 5){
            mark.add(new HashSet<>(set));
            return;
        }
        for (int i=0; i<edge.get(cur).size(); i++){
            int next = edge.get(cur).get(i);
            if (!set.contains(next)){
                set.add(next);
                dfs(next, edge, set);
                set.remove(next);
            }
        }
    }
}
