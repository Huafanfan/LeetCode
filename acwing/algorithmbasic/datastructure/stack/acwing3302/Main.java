package acwing.algorithmbasic.datastructure.stack.acwing3302;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 4:41 PM
 * 2*10-1000+24-(5*3)+(3*2)
 */
public class Main {
    static void eval(Deque<Integer> num, Deque<Character> op){
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int x;
        if (c == '+'){
            x = a + b;
        } else if (c == '-'){
            x = a - b;
        } else if (c == '*'){
            x = a * b;
        } else {
            x = a / b;
        }
        num.push(x);
    }
    public static void main(String[] args) {
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();
        Map<Character, Integer> pr = new HashMap<>(4);
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String cmd = in.next();
        char[] chars = cmd.toCharArray();
        for (int i=0; i<chars.length; i++){
            char c = chars[i];
            if (Character.isDigit(c)){
                int x = 0, j=i;
                while (j < chars.length && Character.isDigit(chars[j])){
                    x = x * 10 + (chars[j++] - '0');
                }
                num.push(x);
                i = j - 1;
            } else if (c == '('){
                op.push(c);
            } else if (c == ')'){
                while (op.peek() != '('){
                    eval(num, op);
                }
                op.pop();
            } else {
                while (!op.isEmpty() && op.peek() != '(' && pr.get(op.peek()) >= pr.get(c)){
                    eval(num, op);
                }
                op.push(c);
            }
        }
        while (!op.isEmpty()){
            eval(num, op);
        }
        System.out.println(num.peek());
    }
}
