package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 14:03
 */
public class Lcof58I {
    /**
     * 24.23%
     * 71.91%
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strings = s.trim().replaceAll(" +"," ").split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=strings.length-1; i>=1; i--){
            stringBuilder.append(strings[i]).append(" ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }
}
