package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/7 11:21
 */
public class ReplaceWords0648 {
    public static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        boolean endOfWord = false;
        public void insert(String word){
            Trie cur = this;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.endOfWord = true;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    public String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.endOfWord) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}
