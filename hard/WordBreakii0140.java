package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/1 09:15
 */
public class WordBreakii0140 {
    public List<String> wordBreakTimeOut(String s, List<String> wordDict) {
        StringBuffer path = new StringBuffer();
        List<String> result = new ArrayList<>();
        dfs(s, wordDict, 0, 0, result, path);
        return result;
    }

    public void dfs(String s, List<String> wordDict, int start, int end, List<String> result, StringBuffer path){
        if (start == s.length()){
            result.add(new String(path.substring(0, path.length()-1)));
            return;
        }
        if (end == s.length() + 1){
            return;
        }
        String tempString = s.substring(start, end);
        if (wordDict.contains(tempString)){
            int pathStart = path.length();
            path.append(tempString).append(" ");
            dfs(s, wordDict, start + tempString.length(), start + tempString.length(), result, path);
            path.delete(pathStart, path.length());
        }
        dfs(s, wordDict, start, end + 1, result, path);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrace(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrace (String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)){
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length){
                wordBreaks.add(new LinkedList<>());
            }
            for (int i=index + 1; i<=length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)){
                    List<List<String>> nextWordBreaks = backtrace(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks){
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public List<String> wordBreakDPDFS(String s, List<String> wordDict) {
        // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        // 第 1 步：动态规划计算是否有解
        // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
        // 长度包括 0 ，因此状态数组的长度为 len + 1
        boolean[] dp = new boolean[len + 1];
        // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for (int left = right - 1; left >= 0; left--) {
                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去
                    break;
                }
            }
        }

        // 第 2 步：回溯算法搜索所有符合条件的解
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, wordSet, dp, path, res);
            return res;
        }
        return res;
    }

    /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param s
     * @param len     长度为 len 的 s 的前缀子串
     * @param wordSet 单词集合，已经加入哈希表
     * @param dp      预处理得到的 dp 数组
     * @param path    从叶子结点到根结点的路径
     * @param res     保存所有结果的变量
     */
    private void dfs(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ",path));
            return;
        }

        // 可以拆分的左边界从 len - 1 依次枚举到 0
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }


    public static void main(String[] args) {
        //String s = "catsanddog";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = new ArrayList<String>();
        //wordDict.add("cat");
        //wordDict.add("cats");
        //wordDict.add("and");
        //wordDict.add("sand");
        //wordDict.add("dog");
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        WordBreakii0140 wordBreakii0140 = new WordBreakii0140();
        System.out.println(wordBreakii0140.wordBreak(s, wordDict));
    }
}
