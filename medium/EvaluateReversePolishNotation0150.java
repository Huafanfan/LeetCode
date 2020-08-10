package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/10 11:53
 */
public class EvaluateReversePolishNotation0150 {
    public static void main(String[] args) {
        EvaluateReversePolishNotation0150 evaluateReversePolishNotation0150 = new EvaluateReversePolishNotation0150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evaluateReversePolishNotation0150.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<>();
        for (String tmp:tokens){
            if ("+".equals(tmp)||"-".equals(tmp)||"*".equals(tmp)||"/".equals(tmp)){
                Integer num_2 = nums.pollLast();
                Integer num_1 = nums.pollLast();
                switch (tmp){
                    case "+" :
                        nums.addLast(num_1+num_2);
                        break;
                    case "-" :
                        nums.addLast(num_1-num_2);
                        break;
                    case "*" :
                        nums.addLast(num_1*num_2);
                        break;
                    case "/" :
                        nums.addLast(num_1/num_2);
                        break;
                    default:
                        break;
                }
            }
            else {
                nums.addLast(Integer.valueOf(tmp));
            }
        }
        return nums.pollLast();
    }


    /**
     * 用数组更快
     * @param tokens
     * @return
     */
    public static int evalRPN2(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    numStack[index - 2] = numStack[index - 2] + numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    // numStack[index++] = Integer.valueOf(s);
                    //valueOf改为parseInt，减少自动拆箱装箱操作
                    numStack[index++] = Integer.parseInt(s);
                    break;
            }
        }
        return numStack[0];
    }
}
