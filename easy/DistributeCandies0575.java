package com.huafanfan.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/22 15:14
 */
public class DistributeCandies0575 {
    public int distributeCandies1(int[] candies) {
        Arrays.sort(candies);
        int count =1;
        for (int i=1; i<candies.length; i++){
            if(candies[i]!=candies[i-1]){
                count++;
            }
        }
        return Math.min(count, candies.length >> 1);
    }
    public int distributeCandies2(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length>>1);
    }
}
