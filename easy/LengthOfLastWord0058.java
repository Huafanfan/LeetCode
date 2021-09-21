package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/21 14:56
 */
public class LengthOfLastWord0058 {
    public int lengthOfLastWord(String s) {
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i) != ' '){
                int j;
                for (j=i; j>=0; j--){
                    if (s.charAt(j) == ' '){
                        break;
                    }
                }
                return i-j;
            }
        }
        return 0;
    }
}
