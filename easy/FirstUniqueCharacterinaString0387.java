package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 09:19
 */
public class FirstUniqueCharacterinaString0387 {
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        for (int i=0; i<s.length(); i++){
            index[s.charAt(i) - 'a']++;
        }
        int min = -1;
        for (int i=0; i<s.length(); i++){
            if (index[s.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        FirstUniqueCharacterinaString0387 firstUniqueCharacterinaString0387 = new FirstUniqueCharacterinaString0387();
        System.out.println(firstUniqueCharacterinaString0387.firstUniqChar2("leetcode"));
    }
}
