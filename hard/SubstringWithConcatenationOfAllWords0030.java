package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/10 11:03
 */
public class SubstringWithConcatenationOfAllWords0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        int wordsLength = wordCount * wordLength;
        Map<String, Integer> map = new HashMap<>(wordCount);
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int offset = 0;
        while (offset + wordsLength <= s.length()){
            String curString = s.substring(offset, offset + wordsLength);
            Map<String, Integer> tmpMap = new HashMap<>(wordCount);
            for (int i=0; i<curString.length(); i+= wordLength){
                String curWord = curString.substring(i, i + wordLength);
                tmpMap.put(curWord, tmpMap.getOrDefault(curWord, 0) + 1);
            }
            if (tmpMap.equals(map)){
                res.add(offset);
            }
            offset++;
        }
        return res;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            // 统计所有次数
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            // 左闭右开
            int left = i, right = i;
            HashMap<String, Integer> subMap = new HashMap<>();
            int count = 0;
            // 可以获取下一个单词
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                // 当前单词不在words中
                if (!wordMap.containsKey(word)) {
                    left = right;
                    // 清空统计情况
                    subMap.clear();
                    count = 0;
                } else {
                    count++;
                    //更新统计情况
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    // 如果该单词的次数超了
                    while (subMap.get(word) > wordMap.get(word)) {
                        // 窗口的第一个单词
                        String firstWord = s.substring(left, left + wordLen);
                        // 该单词统计次数-1
                        subMap.put(firstWord, subMap.get(firstWord) - 1);
                        count--;
                        left += wordLen;
                    }
                }
                if (count == words.length) {
                    res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords0030 substringWithConcatenationOfAllWords0030 = new SubstringWithConcatenationOfAllWords0030();
        String[] words = new String[]{"bar","foo","the"};
        System.out.println(substringWithConcatenationOfAllWords0030.findSubstring2("barbarbarbarfoofoobarthefoobarman", words));
    }
}
