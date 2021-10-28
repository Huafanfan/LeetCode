package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/28 10:10
 */
public class ReorderedPowerOf20869 {
    Set<String> powerOf2Digits = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public void init(){
        for (int i=1; i<=1e9; i<<=1){
            powerOf2Digits.add(countDigits(i));
        }
    }

    public String countDigits(int n){
        char[] nums = new char[10];
        while (n!=0){
            nums[n % 10]++;
            n /= 10;
        }
        return new String(nums);
    }

    boolean[] vis;
    public boolean reorderedPowerOf22(int n){
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        return dfs(nums, 0, 0);
    }

    public boolean dfs(char[] nums, int index, int num){
        if (index == nums.length){
            return isPowerOf2(num);
        }
        for (int i=0; i<nums.length; i++){
            if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i-1] && nums[i-1] == nums[i])){
                continue;
            }
            vis[i] = true;
            if (dfs(nums, index + 1, num*10 + nums[i] - '0')){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    public boolean isPowerOf2(int num){
        return (num & (num-1)) == 0;
    }
}
