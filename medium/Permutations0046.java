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
        int n = nums.length;
        if (n == 0){
            return res;
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num:nums){
            output.add(num);
        }
        backtrace(n,output,res,0);

        //boolean[] used = new boolean[n];
        //List<Integer> path = new ArrayList<>();
        //dfs(nums, n, 0, path, used, res);

        return res;
    }

    /**
     * 简略了visit数组
     * @param n
     * @param output
     * @param res
     * @param first
     */
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

    /**
     * 最传统的方式
     * @param nums
     * @param length
     * @param deep
     * @param path
     * @param used
     * @param res
     */
    public void dfs(int[] nums, int length, int deep, List<Integer> path, boolean[] used, List<List<Integer>> res){
        if (deep == length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < length; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, length, deep+1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
