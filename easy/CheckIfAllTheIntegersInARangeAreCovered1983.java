package easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/23 11:20
 */
public class CheckIfAllTheIntegersInARangeAreCovered1983 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int index = 0;
        int i = left;
        while (i <= right && index < ranges.length){
            if (i >= ranges[index][0] && i <= ranges[index][1]){
                i++;
            }
            else {
                index++;
            }
        }
        return i > right;
    }

    public boolean isCovered2(int[][] ranges, int left, int right) {
        int[] count = new int[51];
        for(int[] range:ranges){
            int l=Math.max(range[0],left);
            int r=Math.min(range[1],right);
            for(int i=l; i<=r;i++){
                count[i]=1;
            }
        }
        for(int i=left; i<=right; i++){
            if(count[i]==0){
                return false;
            }
        }
        return true;
    }
}
