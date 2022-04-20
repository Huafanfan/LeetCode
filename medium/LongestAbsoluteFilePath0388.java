package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/20 09:17
 */
public class LongestAbsoluteFilePath0388 {
    public int lengthLongestPath(String input) {
        Map<Integer, String> map = new HashMap<>();
        char[] chars = input.toCharArray();
        int n = chars.length;
        String res = null;
        for (int i=0; i<n;){
            int level = 0;
            while (i < n && chars[i] == '\t' && ++level > 0){
                i++;
            }
            int j = i;
            boolean isDir = true;
            while (j < n && chars[j] != '\n'){
                if (chars[j++] == '.'){
                    isDir = false;
                }
            }
            String cur = input.substring(i,j);
            String pre = map.getOrDefault(level-1, null);
            String path = pre == null ? cur : pre + "/" + cur;
            if (isDir){
                map.put(level, path);
            }
            else if (res == null || path.length() > res.length()){
                res = path;
            }
            i = j+1;
        }
        return res == null ? 0 : res.length();
    }

    static int[] hash = new int[10010];
    public int lengthLongestPath2(String s) {
        Arrays.fill(hash, -1);
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; ) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t' && ++level >= 0) {
                i++;
            }
            int j = i;
            boolean isDir = true;
            while (j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') {
                    isDir = false;
                }
            }
            int cur = j - i;
            int prev = level - 1 >= 0 ? hash[level - 1] : -1;
            int path = prev + 1 + cur;
            if (isDir) {
                hash[level] = path;
            } else if (path > ans) {
                ans = path;
            }
            i = j + 1;
        }
        return ans;
    }
}
