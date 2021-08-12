package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LexicographicallySortedSmallestFluctuatingArray {
    public List<Integer> func(String s){
        for (int i=1; i<=s.length() + 1; i++){
            List<Integer> path = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            path.add(i);
            set.add(i);
            if (dfs(i, set, path, s, 0)){
                return path;
            }
        }
        return null;
    }

    public boolean dfs(int cur, Set<Integer> set, List<Integer> path, String s, int index){
        if (index == s.length()){
            return true;
        }
        if (s.charAt(index) == 'D'){
            for (int i=cur-1; i>0; i--){
                if (!set.contains(i)){
                    set.add(i);
                    path.add(i);
                    if (dfs(i, set, path, s, index+1)){
                        return true;
                    }
                    set.remove(i);
                    path.remove(path.size() - 1);
                }
            }
        }
        else {
            for (int i=cur+1; i<=s.length()+1; i++){
                if (!set.contains(i)){
                    set.add(i);
                    path.add(i);
                    if (dfs(i, set, path, s, index+1)){
                        return true;
                    }
                    set.remove(i);
                    path.remove(path.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LexicographicallySortedSmallestFluctuatingArray lexicographicallySortedSmallestFluctuatingArray = new LexicographicallySortedSmallestFluctuatingArray();

        System.out.println(lexicographicallySortedSmallestFluctuatingArray.func("IDIDID"));
    }
}
