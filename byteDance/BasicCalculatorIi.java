package byteDance;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorIi {
    int index = 0;
    String expression;
    public int calculate(String s) {
        expression = s;
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> symbolStack = new LinkedList<>();
        while (index < s.length()){
            if (s.charAt(index) != ' '){
                if (s.charAt(index) == '+' || s.charAt(index) == '-'){
                    symbolStack.add(s.charAt(index++));
                }
                else if (s.charAt(index) == '*' || s.charAt(index) == '/'){
                    char symbol = s.charAt(index++);
                    int nextNum = getNum();
                    int lastNum = numStack.pollLast();
                    if (symbol == '*'){
                        numStack.offerLast(lastNum * nextNum);
                    }
                    else {
                        numStack.offerLast(lastNum / nextNum);
                    }
                }
                else {
                    numStack.offerLast(getNum());
                }
            }
            else {
                index++;
            }
        }
        while (!symbolStack.isEmpty()){
            char symbol = symbolStack.pollFirst();
            if (symbol == '+'){
                numStack.offerFirst(numStack.pollFirst() + numStack.pollFirst());
            }
            else {
                numStack.offerFirst(numStack.pollFirst() - numStack.pollFirst());
            }
        }
        return numStack.peek();
    }

    public int getNum(){
        int num = 0;
        while (index < expression.length()){
            if (expression.charAt(index) == ' '){
                index++;
            }
            else if (expression.charAt(index) >= '0' && expression.charAt(index) <= '9'){
                num = num * 10 + (expression.charAt(index) - '0');
                index++;
            }
            else {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        BasicCalculatorIi basicCalculatorIi = new BasicCalculatorIi();
        System.out.println(basicCalculatorIi.calculate(" 3+5 / 200+5 "));
    }
}
