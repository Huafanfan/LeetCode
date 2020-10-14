package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/14 09:27
 */
public class FindCommonCharacters1002 {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        for (int i=0; i<A[0].length(); i++){
            count[A[0].charAt(i)-'a']++;
        }
        for (int i=1; i<A.length; i++){
            int[] temp = new int[26];
            for (int j=0; j<A[i].length(); j++){
                temp[A[i].charAt(j)-'a']++;
            }
            for (int k=0; k<count.length; k++){
                count[k] = Math.min(count[k],temp[k]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i=0; i<count.length; i++){
            if (count[i]>0){
                while (count[i]>0){
                    result.add(String.valueOf((char) ('a' + i)));
                    count[i]--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters1002 findCommonCharacters1002 = new FindCommonCharacters1002();
        String[] A = new String[]{"cool","lock","cook"};
        System.out.println(findCommonCharacters1002.commonChars(A));
    }
}
