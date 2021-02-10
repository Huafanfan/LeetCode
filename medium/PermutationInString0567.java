package medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/10 11:04
 */
public class PermutationInString0567 {

    public boolean checkInclusion(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = pattern.length;
        int tLen = text.length;

        int pCount = 0;
        int[] pFre = new int[26];
        for (char p : pattern){
            pFre[p - 'a']++;
        }
        for (int i=0; i<26; i++){
            if (pFre[i] > 0){
                pCount++;
            }
        }

        int[] winFre = new int[26];
        int winCount = 0;
        int left = 0;
        int right = 0;
        while (right < tLen){
            if (pFre[text[right] - 'a'] > 0 ) {
                if (++winFre[text[right] - 'a'] == pFre[text[right] - 'a']){
                    winCount++;
                }
            }
            right++;
            while (winCount == pCount){
                if (right - left == pLen){
                    return true;
                }
                else {
                    if (pFre[text[left] - 'a'] > 0 ) {
                        winFre[text[left] - 'a']--;
                        if (winFre[text[left] - 'a'] < pFre[text[left] - 'a']){
                            winCount--;
                        }
                    }
                    left++;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        PermutationInString0567 permutationInString0567 = new PermutationInString0567();
        System.out.println(permutationInString0567.checkInclusion("adc", "dcda"));
    }
}
