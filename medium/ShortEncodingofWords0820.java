package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/7 15:11
 */
public class ShortEncodingofWords0820 {
    public static void main(String[] args) {
        //ShortEncodingofWords0820 shortEncodingofWords0820 = new ShortEncodingofWords0820();
        //System.out.println(shortEncodingofWords0820.minimumLengthEncoding(words));
    }

    /**
     * 打怪
     * @return
     */
    public int solution(){
        Scanner reader = new Scanner(System.in) ;
        int n = reader.nextInt();
        int[] loss = new int[2*n+1];
        int[] get = new int[2*n+1];
        for (int i=0; i<2*n+1;i++){
            if (i==n){
                loss[i] = 0;
            }
            else {
                loss[i] = -reader.nextInt();
            }
        }
        for (int i=0; i<2*n+1;i++){
            if (i==n){
                get[i] = 0;
            }
            else {
                get[i] = reader.nextInt();
            }
        }
        int rightMin = -loss[2*n] + 1;
        int rightFinal = get[2*n];
        for (int i=2*n-1;i>n;i--){
            rightMin = rightMin - get[i] -loss[i];
        }
        int leftMin = -loss[0] + 1;
        int leftFinal = get[0];
        for (int i=1;i<n;i++){
            leftMin = leftMin - get[i] -loss[i];
        }
        if (rightMin>0&&leftMin>0){
            return Math.min(rightMin+(leftMin-rightFinal),leftMin+(rightMin-leftFinal));
        }
        else{
            if (rightMin>0){
                for (int i=0;i<n;i++){
                    rightMin = rightMin - (get[i] + loss[i]);
                }
                return rightMin;
            }
            else if (leftMin>0){
                for (int i=n+1;i<2*n+1;i++){
                    leftMin = leftMin - (get[i] + loss[i]);
                }
                return leftMin;
            }
            else {
                return Math.min(-loss[n-1],-loss[n+1]);
            }
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet<>(Arrays.asList(words));
        for (String word : words){
            for (int i=1; i<word.length(); i++){
                good.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
    public int minimumLengthEncodingTree(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }

}
class TrieNode {
    TrieNode[] children;
    int count;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrieNode trieNode = (TrieNode) o;
        return count == trieNode.count &&
                Arrays.equals(children, trieNode.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
}

