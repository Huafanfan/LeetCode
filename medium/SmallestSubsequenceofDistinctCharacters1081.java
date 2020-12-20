package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 09:46
 */
public class SmallestSubsequenceofDistinctCharacters1081 {
    public String smallestSubsequence(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] charIndex = new int[26];
        boolean[] visited = new boolean[26];
        for (int i=0; i<len; i++){
            charIndex[chars[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<len; i++){
            if (visited[chars[i] - 'a']){
                continue;
            }
            while (!stack.isEmpty() && charIndex[stack.peekLast() - 'a'] > i && stack.peekLast() > chars[i]){
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.offerLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }

        StringBuilder res = new StringBuilder();
        for (char c : stack){
            res.append(c);
        }
        return res.toString();
    }
}
