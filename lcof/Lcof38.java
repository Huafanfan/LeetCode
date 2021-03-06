package lcof;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 11:19
 */
public class Lcof38 {
    /**
     * 5.04%
     * 5.04%
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        Set<List<Character>> res = new HashSet<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, new ArrayList<Character>(), res);
        String[] result = new String[res.size()];
        Iterator<List<Character>> iterable = res.iterator();
        for (int i=0; i<result.length; i++){
            String tmp = iterable.next().toString();
            result[i] = tmp.substring(1, tmp.length()-1).replaceAll(", ", "");
        }
        return result;
    }

    public void dfs(char[] chars, int index, List<Character> path,  Set<List<Character>> res){
        if (index == chars.length){
            res.add(new ArrayList<>(path));
        }
        else {
            for (int i=index; i<chars.length; i++){
                swap(i, index, chars);
                path.add(chars[index]);
                dfs(chars, index+1, path, res);
                path.remove(path.size()-1);
                swap(i, index, chars);
            }
        }
    }

    /**
     * 94.45%
     * 43.29%
     * @param s
     * @return
     */
    public String[] permutation2(String s) {
        List<String> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        dfs2(chars, 0, res);
        return res.toArray(new String[0]);
    }

    public void dfs2(char[] chars, int index,  List<String> res){
        if (index == chars.length - 1){
            res.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=index; i<chars.length; i++){
            if (set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(i, index, chars);
            dfs2(chars, index + 1, res);
            swap(i, index, chars);
        }
    }
    void swap(int a, int b, char[] chars) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    List<String> rec;
    boolean[] vis;

    public String[] permutation3(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }


    public static void main(String[] args) {
        Lcof38 lcof38 = new Lcof38();
        System.out.println(Arrays.toString(lcof38.permutation2("abbc")));
    }
}
