package hard;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorIi0227 {
    public int calculate(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char preSign = '+';
        for (int i=0; i<len; i++){
            if (Character.isDigit(chars[i])){
                num = num * 10 + (chars[i] - '0');
            }
            if (!Character.isDigit(chars[i]) && chars[i] != ' ' || i == len -1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = chars[i];
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
