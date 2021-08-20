package easy;

public class ReverseStringIi0541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
//        int i = 0;
//        while (i < chars.length){
//            if (i + k - 1 < chars.length){
//                reverse(chars,i, i+k-1);
//                i += k;
//                if (i + k -1 < chars.length){
//                    i += k;
//                }else {
//                    i = chars.length;
//                }
//            }
//            else {
//                reverse(chars, i, chars.length-1);
//                i = chars.length;
//            }
//        }
        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, Math.min(i + k, chars.length) - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right){
        while (left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseStringIi0541 reverseStringIi0541 = new ReverseStringIi0541();
        System.out.println(reverseStringIi0541.reverseStr("abcdefg", 4));
        System.out.println(reverseStringIi0541.reverseStr("abcd", 2));
    }
}
