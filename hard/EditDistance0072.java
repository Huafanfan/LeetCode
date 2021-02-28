package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/28 11:35
 */
public class EditDistance0072 {
    Map<String, Integer> map = new HashMap<>();
    public int minDistance(String word1, String word2) {
        if (map.containsKey(word1 + word2)){
            return map.get(word1 + word2);
        }
        if (word1.length() == 0 || word2.length() == 0){
            map.put(word1 + word2, word1.length() + word2.length());
            return word1.length() + word2.length();
        }
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)){
            int value = minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length()-1));
            map.put(word1.substring(0, word1.length() - 1) + word2.substring(0, word2.length()-1), value);
            return value;
        }
        //对应word1增加一个字母（word2的最后一个字母），word1删除一个字母，word1替换一个字母
        return 1 + Math.min(
                   Math.min(minDistance(word1, word2.substring(0, word2.length() - 1)),
                            minDistance(word1.substring(0, word1.length()-1), word2)),
                            minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length()-1)));
    }

    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i=0; i<=len1; i++){
            for (int j=0; j<=len2; j++){
                if (i == 0){
                    dp[i][j] = j;
                }
                else if (j == 0){
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for (int i=0; i<len1; i++){
            for (int j=0; j<len2; j++){
                if (chars1[i] == chars2[j]){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
