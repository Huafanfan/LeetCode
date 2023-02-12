package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/6 22:32
 */
public class NumberOfDifferentIntegersInAString1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<word.length();){
            if (Character.isDigit(word.charAt(i))){
                int j=i;
                while (j<word.length() && word.charAt(j) == '0'){
                    j++;
                }
                StringBuilder sb = new StringBuilder();
                for (;j<word.length() && Character.isDigit(word.charAt(j)); j++){
                    sb.append(word.charAt(j));
                }
                set.add(sb.toString());
                i=j;
            } else {
                i++;
            }
        }
        return set.size();
    }
}
