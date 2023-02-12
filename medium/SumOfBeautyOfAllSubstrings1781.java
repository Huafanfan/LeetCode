package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/12 22:06
 */
public class SumOfBeautyOfAllSubstrings1781 {
    public int beautySum(String s) {
        int res = 0;
        // i 起点， j 终点
        for (int i=0; i<s.length(); i++){
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j=i; j<s.length(); j++){
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k=0; k<26; k++){
                    if (cnt[k] > 0){
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}
