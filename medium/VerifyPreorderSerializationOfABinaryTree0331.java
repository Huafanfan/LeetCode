package medium;

import bishi.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyPreorderSerializationOfABinaryTree0331 {
    public boolean isValidSerialization(String preorder) {
        String[] preorderList = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        int len = preorderList.length;
        String cur = null;
        for (int i=0; i<len; i++){
            if (!preorderList[i].equals("#")){
                cur = preorderList[i];
                stack.push(preorderList[i]);
            }
            else {
                if (!stack.isEmpty()){
                    cur = stack.poll();
                }
                else {
                    cur = "#";
                }
            }
            if (cur == "#" && i != len-1){
                return false;
            }
        }
        return  cur == "#" && stack.isEmpty();
    }

    public boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree0331 verifyPreorderSerializationOfABinaryTree0331 = new VerifyPreorderSerializationOfABinaryTree0331();
        verifyPreorderSerializationOfABinaryTree0331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
