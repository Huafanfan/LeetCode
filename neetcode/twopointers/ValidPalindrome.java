package neetcode.twopointers;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/24 11:11
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0){
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(chars[left])){
                left++;
            }
            while (right > left && !Character.isLetterOrDigit(chars[right])){
                right--;
            }
            if (chars[left++] != chars[right--]){
                return false;
            }
        }
        return true;
    }
}
