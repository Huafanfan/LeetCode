package neetcode.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/6 12:23
 */
public class DesignAddAndSearchWordsDataStructure {
    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean endOfWord = false;
    }
    TrieNode root;
    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (!cur.map.containsKey(c)){
                cur.map.put(c, new TrieNode());
            }
            cur = cur.map.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }
    public boolean dfs(int index, String word, TrieNode root){
        TrieNode cur = root;
        for (int i=index; i<word.length(); i++){
            char c = word.charAt(i);
            if (c == '.'){
                for (TrieNode v : cur.map.values()) {
                    if (dfs(i+1, word, v)){
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
        }
        return cur.endOfWord;
    }
}
