package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/2 19:04
 */
public class LongestRepeatingCharacterReplacement0424 {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (int i=0; i<s.length(); i++){
            for (int j=i+1;j<s.length(); j++){
                int[] count = new int[26];
                for (int m=i; m<=j; m++){
                    count[s.charAt(m) - 'A']++;
                }
                int max = 0;
                char ch = 0;
                for (int n=0; n<26; n++){
                    if (count[n] > max){
                        max = count[n];
                        ch = (char)('A' + n);
                    }
                }
                int cou = 0;
                for (int m=i; m<=j; m++){
                    if (s.charAt(m) != ch){
                        cou++;
                    }
                }
                if (cou == k){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public int characterReplacement2(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len){
            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k){
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
