package neetcode.tries;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/6 12:24
 */
public class WordSearchII {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie2 trie = new Trie2();
        for (String word : words){
            trie.insert(word);
        }

        Set<String> ans = new HashSet<String>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie2 now, int i1, int j1, Set<String> ans){
        if (!now.children.containsKey(board[i1][j1])){
            return;
        }
        char ch = board[i1][j1];
        now = now.children.get(ch);
        if (!"".equals(now.word)){
            ans.add(now.word);
        }
        board[i1][j1] = '#';
        for (int[] dir : dirs) {
            int i2 = i1 + dir[0], j2 = j1 + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, now, i2, j2, ans);
            }
        }
        board[i1][j1] = ch;
    }
}

class Trie2 {
    String word;
    Map<Character, Trie2> children;

    public Trie2() {
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie2 cur = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new Trie2());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}
