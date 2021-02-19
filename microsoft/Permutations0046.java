package microsoft;

import java.util.ArrayList;
import java.util.List;

public class Permutations0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i<nums.length; i++){
            swap(nums, index, i);
            path.add(nums[index]);
            dfs(nums, index + 1, path, res);
            path.remove(path.size() - 1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
