package medium;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/15 09:18
 */
public class RemoveKDigits0402 {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            //Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits0402 removeKDigits0402 = new RemoveKDigits0402();
        String num = "1432219";
        System.out.println(removeKDigits0402.removeKdigits(num, 3));
    }
}
