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
    ImplementTriePrefixTree0208 []child = new ImplementTriePrefixTree0208[26];
    boolean isEnd = false;
    /** Initialize your data structure here. */
    public ImplementTriePrefixTree0208() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        ImplementTriePrefixTree0208 t = find(word,true);
        t.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        ImplementTriePrefixTree0208 t = find(word,false);
        return t!=null && t.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        ImplementTriePrefixTree0208 t = find(prefix,false);
        return t!=null;
    }

    private ImplementTriePrefixTree0208 find(String word, boolean insertMode){
        ImplementTriePrefixTree0208 t = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(t.child[index]==null){
                if(insertMode){
                    t.child[index] = new ImplementTriePrefixTree0208();
                }else{
                    return null;
                }
            }
            t = t.child[index];
        }
        return t;
    }
}
