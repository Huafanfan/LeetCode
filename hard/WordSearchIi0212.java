package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/16 09:53
 */
public class WordSearchIi0212 {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie2 trie = new Trie2();
        for (String word : words){
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();
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

    Set<String> set = new HashSet<>();
    List<String> ans = new ArrayList<>();
    char[][] board;
    int n, m;
    boolean[][] vis = new boolean[15][15];
    public List<String> findWords2(char[][] _board, String[] words) {
        board = _board;
        m = board.length; n = board[0].length;
        set.addAll(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb);
                vis[i][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ans;
    }
    void dfs(int i, int j, StringBuilder sb) {
        if (sb.length() > 10) {
            return ;
        }
        if (set.contains(sb.toString())) {
            ans.add(sb.toString());
            set.remove(sb.toString());
        }
        for (int[] d : dirs) {
            int dx = i + d[0], dy = j + d[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                continue;
            }
            if (vis[dx][dy]) {
                continue;
            }
            vis[dx][dy] = true;
            sb.append(board[dx][dy]);
            dfs(dx, dy, sb);
            vis[dx][dy] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
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
