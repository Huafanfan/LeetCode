package medium;

import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/27 11:56
 */
public class FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        int res = words.length;
        int index1 = -1, index2 = -1;
        for (int i=0; i<words.length; i++){
            if (words[i].equals(word1)){
                index1 = i;
            } else if (words[i].equals(word2)){
                index2 = i;
            }
            if (index1 > -1 && index2 > -1){
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
