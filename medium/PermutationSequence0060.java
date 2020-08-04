package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/4 11:45
 * 太复杂，下面的方法只是一个全排列，并未安装字典顺序
 */
public class PermutationSequence0060 {
    public String getPermutation(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i=1; i<=n; i++){
            output.add(i);
        }
        backtrace(n,output,res,0);
        StringBuilder result = new StringBuilder();
        for (int i=0; i<res.get(k-1).size();i++){
            result.append(res.get(k - 1).get(i));
        }
        return result.toString();
    }
    public void backtrace(int n, ArrayList<Integer> output, List<List<Integer>> res, int first){
        if(first == n){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i=first; i<n; i++){
            Collections.swap(output,first,i);
            backtrace(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
