package easy.array;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/26 23:54
 */
public class LongestCommonPrefix0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            boolean isMathch = true;
            for (int j=1; j<strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != ch){
                    isMathch = false;
                    break;
                }
            }
            if (!isMathch){
                return sb.toString();
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
