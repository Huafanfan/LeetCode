package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/21 15:33
 */
public class GoatLatin0824 {
    public String toGoatLatin(String sentence) {
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('o');
        set.add('O');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('u');
        set.add('U');
        for (int i=0; i<strings.length; i++){
            if (set.contains(strings[i].charAt(0))){
                sb.append(strings[i]).append("ma");
            }
            else {
                sb.append(strings[i].substring(1, strings[i].length())).append(strings[i].charAt(0)).append("ma");
            }
            for (int j=0; j<=i; j++){
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
