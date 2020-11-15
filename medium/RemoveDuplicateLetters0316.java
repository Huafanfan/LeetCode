package medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/15 10:34
 */
public class RemoveDuplicateLetters0316 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }
        Deque<Character> deque = new LinkedList<Character>();
        int length = s.length();
        for (int i=0; i<length; i++){
            char tempChar = s.charAt(i);
            map.put(tempChar, map.get(tempChar) - 1);
            if (deque.contains(tempChar)){
                continue;
            }
            while (!deque.isEmpty() && map.get(deque.peekLast()) > 0 && deque.peekLast().charValue() > tempChar) {
                deque.pollLast();
            }
            deque.addLast(tempChar);
        }
        StringBuilder ret = new StringBuilder();
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            ret.append(digit);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters0316 removeDuplicateLetters0316 = new RemoveDuplicateLetters0316();
        System.out.println(removeDuplicateLetters0316.removeDuplicateLetters("cbacdcbc"));
    }
}
