package medium;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DecodeString0394 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        int ptr = 0;
        while (ptr<len){
            char cur = chars[ptr];
            if (Character.isDigit(cur)){
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(chars[ptr])) {
                    ret.append(s.charAt(ptr++));
                }
                stack.addLast(ret.toString());
            }
            else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(cur));
                ptr++;
            }
            else {
                //跳过 ]
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addFirst(stack.removeLast());
                }
                StringBuffer ret = new StringBuffer();
                for (String st : sub) {
                    ret.append(st);
                }
                String o = ret.toString();

                // 左括号出栈
                stack.removeLast();

                int repTime = Integer.parseInt(stack.removeLast());
                StringBuffer t = new StringBuffer();
                while (repTime-- > 0) {
                    t.append(o);
                }
                stack.addLast(t.toString());
            }
        }
        StringBuffer ret = new StringBuffer();
        for (String st : stack) {
            ret.append(st);
        }
        return ret.toString();
    }

    public String decodeString2(String s) {
        Deque<Integer> stackNum = new LinkedList<>();
        Deque<String> stackString = new LinkedList<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        int ptr = 0;
        while (ptr<len){
            if (Character.isDigit(chars[ptr])){
                int num = 0;
                while (Character.isDigit(chars[ptr])) {
                    num = num * 10 + (s.charAt(ptr++) - '0');
                }
                stackNum.addLast(num);
            }
            else if (Character.isLetter(chars[ptr]) || chars[ptr] == '[') {
                stackString.addLast(String.valueOf(chars[ptr]));
                ptr++;
            }
            else {
                //此时的char是 ]
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stackString.peekLast())) {
                    sub.addFirst(stackString.removeLast());
                }
                stackString.removeLast();

                StringBuffer tmp = new StringBuffer();
                for (String t : sub) {
                    tmp.append(t);
                }
                String subString = tmp.toString();
                int repTime = stackNum.removeLast();
                tmp = new StringBuffer();
                while (repTime-- > 0) {
                    tmp.append(subString);
                }
                stackString.addLast(tmp.toString());

                ptr++;
            }
        }
        StringBuffer ret = new StringBuffer();
        for (String t : stackString) {
            ret.append(t);
        }
        return ret.toString();
    }
}
