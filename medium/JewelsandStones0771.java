package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/4 10:56
 */
public class JewelsandStones0771 {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        int[] alphabet = new int[52];
        for (int i = 0; i < J.length(); i++){
            if (isUpper(J.charAt(i))){
                alphabet[J.charAt(i) - 'A'] = 1;
            }
            else {
                alphabet[26 + J.charAt(i) - 'a'] = 1;
            }
        }
        for (int i = 0; i < S.length(); i++){
            if (isUpper(S.charAt(i))){
                if (alphabet[S.charAt(i) - 'A'] == 1){
                    result++;
                }
            }
            else {
                if (alphabet[26 + S.charAt(i) - 'a'] == 1){
                    result++;
                }
            }
        }
        return result;
    }
    public boolean isUpper(char alpha){
        return alpha - 'a' < 0;
    }

    public int numJewelsInStonesHash(String J, String S) {
        int jewelsCount = 0;
        Set<Character> jewelsSet = new HashSet<Character>();
        int jewelsLength = J.length(), stonesLength = S.length();
        for (int i = 0; i < jewelsLength; i++) {
            char jewel = J.charAt(i);
            jewelsSet.add(jewel);
        }
        for (int i = 0; i < stonesLength; i++) {
            char stone = S.charAt(i);
            if (jewelsSet.contains(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }

    public static void main(String[] args) {
        JewelsandStones0771 jewelsandStones0771 = new JewelsandStones0771();
        String J = "z";
        String S = "ZZ";
        System.out.println(jewelsandStones0771.numJewelsInStones(J, S));
    }
}
