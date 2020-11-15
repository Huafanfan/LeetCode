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
    private String minNum;
    public String removeKdigitsTimeOut(String num, int k) {
        if (num.length() == k){
            return "0";
        }
        minNum = num;
        StringBuffer nums = new StringBuffer(num);
        dfs(nums, k);
        int i = 0;
        for (;i<minNum.length(); i++){
            if (minNum.charAt(i) != '0'){
                break;
            }
        }
        return minNum.substring(i, minNum.length()).length() == 0 ? "0" : minNum.substring(i, minNum.length());
    }

    public void dfs(StringBuffer nums, int k){
        if (k == 0){
            if (minNum.length() > nums.length()){
                minNum = nums.toString();
            }
            else {
                int result = minNum.compareTo(nums.toString());
                if (result>0){
                    minNum = nums.toString();
                }
            }
        }
        else {
            for (int i=0; i<nums.length(); i++){
                StringBuffer temp = new StringBuffer(nums);
                temp.deleteCharAt(i);
                dfs(temp, k-1);
            }
        }
    }

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
