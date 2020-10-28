package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/28 09:35
 */
public class UniqueNumberofOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        int offset = 1000;
        for (int num : arr){
            count[num+offset]++;
        }
        Set<Integer> result = new HashSet<>();
        for (int num : count){
            if (num > 0){
                if (!result.contains(num)){
                    result.add(num);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
