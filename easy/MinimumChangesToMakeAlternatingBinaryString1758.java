package easy;

/**
 * @author yifan.zhangyf
 * @date 2022/11/29 21:42
 */
public class MinimumChangesToMakeAlternatingBinaryString1758 {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
