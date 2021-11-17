package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/11/17 10:12
 */
public class MaximumProductOfWordLengths0318 {
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i=0; i<words.length; i++){
            char[] chars = words[i].toCharArray();
            for (char aChar : chars) {
                masks[i] |= 1 << (aChar - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}
