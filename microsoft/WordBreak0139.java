package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1] 是否能被空格拆分成若干个字典中出现的单词
        //dp[i]=dp[j] && check(s[j..i−1])
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i=1; i<len; i++){
            for (int j=0; j<i; j++){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        WordBreak0139 wordBreak0139 = new WordBreak0139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak0139.wordBreak("applepenapple", wordDict));
    }
}
