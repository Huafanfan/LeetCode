package byteDance;

public class MinimumWindowSubstring {
    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] windows = new int[128];
        int[] need = new int[128];
        for (char ch : t.toCharArray()){
            need[ch]++;
        }
        int charNum = 0;
        for (int num : need){
            if (num > 0){
                charNum++;
            }
        }
        int left = 0, right = 0, begin = 0, end = 0, match = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            if (need[c] != 0){
                windows[c]++;
                if (windows[c] == need[c]){
                    match++;
                }
            }
            right++;
            //right指向下一个位置，可保证substring的左闭右开
            while (match == charNum){
                if (right - left < minLength){
                    minLength = right - left;
                    end = right;
                    begin = left;
                }
                char leftChar = s.charAt(left);
                if (need[leftChar] != 0){
                    if (windows[leftChar] == need[leftChar]){
                        match--;
                    }
                    windows[leftChar]--;
                }
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "":s.substring(begin, end);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
