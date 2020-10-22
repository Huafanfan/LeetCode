package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/22 09:36
 */
public class PartitionLabels0763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] alphabet = new int[26];
        for (int i=0; i<S.length(); i++){
            alphabet[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = -1;
        for (int i=0; i<S.length(); i++){
            end = Math.max(end, alphabet[S.charAt(i) - 'a']);
            if (end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
