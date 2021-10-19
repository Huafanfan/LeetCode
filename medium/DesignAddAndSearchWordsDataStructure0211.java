package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/19 10:46
 */
public class DesignAddAndSearchWordsDataStructure0211 {
    private Trie root;
    public DesignAddAndSearchWordsDataStructure0211() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Trie node){
        if (index == word.length()){
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)){
            int childrenIndex = ch - 'a';
            Trie child = node.getChildren()[childrenIndex];
            if (child != null && dfs(word, index+1, child)){
                return true;
            }
        }else {
            for (int i=0; i<26; i++){
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index+1, child)){
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie node = this;
        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie[] getChildren(){
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
