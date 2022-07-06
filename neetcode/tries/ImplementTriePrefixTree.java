package neetcode.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/6 10:53
 */
public class ImplementTriePrefixTree {
    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean endOfWord = false;
    }
    TrieNode root;
    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            if (!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }
        return true;
    }
}
