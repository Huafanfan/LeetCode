package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yifan.zhangyf
 * @date 2022/11/7 22:38
 */
public class AmbiguousCoordinates0816 {
    /**
     *
     * @param s = "(0123)"
     */
    String s;
    public List<String> ambiguousCoordinates(String _s) {
        s = _s.substring(1, _s.length()-1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        // 枚举逗号的位置 idx，枚举范围为 [0,n−1)，含义为在 s[idx] 后面追加逗号。
        for (int i=0; i<n-1; i++){
            List<String> a = search(0, i), b = search(i+1, n-1);
            for (String x : a){
                for (String y : b){
                    ans.add("(" + x + "," + y + ")");
                }
            }
        }
        return ans;
    }

    public List<String> search(int start, int end){
        List<String> ans = new ArrayList<>();
        if (start == end || s.charAt(start) != '0'){
            ans.add(s.substring(start, end + 1));
        }
        // 枚举小数点：在 i 后面追加小数点
        for (int i=start; i<end; i++){
            String a = s.substring(start, i+1), b = s.substring(i+1, end + 1);
            if (a.length() > 1 && a.charAt(0) == '0'){
                continue;
            }
            if (b.charAt(b.length() - 1) == '0'){
                continue;
            }
            ans.add(a + "." + b);
        }
        return ans;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates0816 a = new AmbiguousCoordinates0816();
        System.out.println(a.ambiguousCoordinates("(0123)"));
    }
}
