package acwing.twopoints.acwing799;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/8/28 3:45 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0, j=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > 1){
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        System.out.println(maxLength);
    }
}
