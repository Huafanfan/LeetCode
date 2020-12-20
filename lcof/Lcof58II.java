package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 14:12
 */
public class Lcof58II {
    /**
     * 26.96%
     * 93.01%
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=n; i<s.length(); i++){
            stringBuilder.append(s.charAt(i));
        }
        for (int i=0; i<n ; i++){
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * 100.00%
     * 86.32%
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0,n);
    }
}
