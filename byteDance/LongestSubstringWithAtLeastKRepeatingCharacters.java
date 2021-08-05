package byteDance;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length()-1, k);
    }
    public int dfs(String s, int left, int right, int k){
        int[] cnt = new int[26];
        for (int i=left; i<=right; i++){
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i=0; i<26; i++){
            if (cnt[i] > 0 && cnt[i] < k){
                split = (char)(i + 'a');
            }
        }
        if (split == 0){
            return right - left + 1;
        }
        int i = left;
        int res = 0;
        while (i <= right){
            while (i <= right && s.charAt(i) == split){
                i++;
            }
            if (i > right){
                break;
            }
            int start = i;
            while (i <= right && s.charAt(i) != split){
                i++;
            }
            int length = dfs(s, start, i-1, k);
            res = Math.max(res, length);
        }
        return res;
    }
}
