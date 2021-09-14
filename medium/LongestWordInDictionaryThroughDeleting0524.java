package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/14 10:10
 */
public class LongestWordInDictionaryThroughDeleting0524 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        String res = "";
        for (int i=dictionary.size() - 1; i>=0; i--){
            if (dictionary.get(i).length() >= res.length()){
                String cur = dictionary.get(i);
                int left = 0;
                int right = cur.length() - 1;
                int matchCount = 0;
                int l = 0;
                int r = s.length() - 1;
                while (l <= r && left <= right){
                    if (s.charAt(l) == cur.charAt(left)){
                        left++;
                        matchCount++;
                    }
                    if (s.charAt(r) == cur.charAt(right)){
                        right--;
                        matchCount++;
                    }
                    l++;
                    r--;
                }
                if (matchCount >= cur.length()){
                    res = cur;
                }
            }
        }
        return res;
    }

    public String findLongestWord2(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }

    public String findLongestWord3(String s, List<String> dictionary) {
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                } else {
                    return word1.compareTo(word2);
                }
            }
        });
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }

    public String findLongestWord4(String s, List<String> dictionary) {
        int m = s.length();
        //f[i][j] 表示字符串 s 中从位置 i 开始往后字符 j 第一次出现的位置
        int[][] f = new int[m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() ||  (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting0524 longestWordInDictionaryThroughDeleting0524 = new LongestWordInDictionaryThroughDeleting0524();
        List<String> dictionary = new ArrayList<>();
        //"ale","apple","monkey","plea"
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(longestWordInDictionaryThroughDeleting0524.findLongestWord4("abpcplea", dictionary));
    }
}
