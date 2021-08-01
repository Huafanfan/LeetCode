package byteDance;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/8/1 21:49
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxLength = Math.max(maxLength, right * 2);
            }
            if (right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i=s.length() - 1; i>=0; i--){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxLength = Math.max(maxLength, left * 2);
            }
            if (left > right){
                left = right = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("())"));
    }
}
