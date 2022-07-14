package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/14 09:41
 */
public class PrefixAndSuffixSearch0745 {
    //Map<String, Integer> dictionary;
    //
    //public PrefixAndSuffixSearch0745(String[] words) {
    //    dictionary = new HashMap<String, Integer>();
    //    for (int i = 0; i < words.length; i++) {
    //        String word = words[i];
    //        int m = word.length();
    //        for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
    //            for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
    //                dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
    //            }
    //        }
    //    }
    //}
    //
    //public int f(String pref, String suff) {
    //    return dictionary.getOrDefault(pref + "#" + suff, -1);
    //}

    Trie trie;
    String weightKey;

    public PrefixAndSuffixSearch0745(String[] words) {
        trie = new Trie();
        weightKey = "##";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = trie;
            int m = word.length();
            for (int j = 0; j < m; j++) {
                Trie tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = String.valueOf(word.charAt(k)) + '#';
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = "#" + word.charAt(m - k - 1);
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                String key = String.valueOf(word.charAt(j)) + word.charAt(m - j - 1);
                if (!cur.children.containsKey(key)) {
                    cur.children.put(key, new Trie());
                }
                cur = cur.children.get(key);
                cur.weight.put(weightKey, i);
            }
        }
    }

    public int f(String pref, String suff) {
        Trie cur = trie;
        int m = Math.max(pref.length(), suff.length());
        for (int i = 0; i < m; i++) {
            char c1 = i < pref.length() ? pref.charAt(i) : '#';
            char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
            String key = String.valueOf(c1) + c2;
            if (!cur.children.containsKey(key)) {
                return -1;
            }
            cur = cur.children.get(key);
        }
        return cur.weight.get(weightKey);
    }

    static class Trie {
        Map<String, Trie> children;
        Map<String, Integer> weight;

        public Trie() {
            children = new HashMap<String, Trie>();
            weight = new HashMap<String, Integer>();
        }
    }
}
