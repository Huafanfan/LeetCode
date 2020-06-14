package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/6/14 20:34
 */
public class Permutations0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num:nums){
            output.add(num);
        }
        int n = nums.length;
        backtrace(n,output,res,0);
        return res;
    }
    public void backtrace(int n, ArrayList<Integer> output, List<List<Integer>> res, int first){
        if (first==n){
            //在特定位置进行拷贝，而不是添加进去引用
            res.add(new ArrayList<Integer>(output));
        }
        for (int i=first; i<n; i++){
            Collections.swap(output,first,i);
            backtrace(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
