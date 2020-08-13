package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/13 16:33
 */
//public class ImplementTriePrefixTree0208 {
//    private List<String> stringList;
//    /** Initialize your data structure here. */
//    public ImplementTriePrefixTree0208() {
//        this.stringList = new ArrayList<>();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        stringList.add(word);
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        for (String s : stringList){
//            if (s.equals(word)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        for (String s : stringList){
//            if (s.startsWith(prefix)){
//                return true;
//            }
//        }
//        return false;
//    }
//}
public class ImplementTriePrefixTree0208 {
    private boolean isString =false;
    private final ImplementTriePrefixTree0208[] next =new ImplementTriePrefixTree0208[26];

    public ImplementTriePrefixTree0208(){}

    public void insert(String word){//插入单词
        ImplementTriePrefixTree0208 root=this;
        char[] w =word.toCharArray();
        for (char c : w) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new ImplementTriePrefixTree0208();
            }
            root = root.next[c - 'a'];
        }
        root.isString =true;
    }

    public boolean search(String word){//查找单词
        ImplementTriePrefixTree0208 root=this;
        char[] w =word.toCharArray();
        for (char c : w) {
            if (root.next[c - 'a'] == null) {
                return false;
            }
            root = root.next[c - 'a'];
        }
        return root.isString;
    }

    public boolean startsWith(String prefix){//查找前缀
        ImplementTriePrefixTree0208 root=this;
        char[] p =prefix.toCharArray();
        for (char c : p) {
            if (root.next[c - 'a'] == null) {
                return false;
            }
            root = root.next[c - 'a'];
        }
        return true;
    }
}
