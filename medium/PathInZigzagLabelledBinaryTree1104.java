package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        while ((int)Math.pow(2, level) > label || (int)Math.pow(2, level + 1) - 1 < label){
            level++;
        }
        int index = 0;
        if ((level & 1) == 1){
            int start = (int)Math.pow(2, level + 1) - 1;
            while (start != label){
                start--;
                index++;
            }
        }
        else {
            int start = (int)Math.pow(2, level);
            while (start != label){
                start++;
                index++;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i=level; i>=0; i--){
            int start;
            if ((i & 1) == 1){
                start = (int)Math.pow(2, i + 1) - 1;
                res.add(0, start - index);
            }
            else {
                start = (int)Math.pow(2, i);
                res.add(0, start + index);
            }
            index = index / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree1104 pathInZigzagLabelledBinaryTree1104 = new PathInZigzagLabelledBinaryTree1104();
        System.out.println(pathInZigzagLabelledBinaryTree1104.pathInZigZagTree(14));
    }
}
