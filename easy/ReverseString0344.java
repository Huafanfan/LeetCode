package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/8 09:24
 */
public class ReverseString0344 {
    public void reverseString(char[] s) {
        int n = s.length / 2;
        for (int i=0; i<n; i++){
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString0344 reverseString0344 = new ReverseString0344();
        char[] s1 = new char[]{'h','e','l','l','o'};
        char[] s2 = new char[]{'H','a','n','n','a','h'};
        reverseString0344.reverseString(s2);
        System.out.println(s2);
    }
}
