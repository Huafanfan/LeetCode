package microsoft;

public class ReverseString0344 {
    public void reverseString(char[] s) {
        int len = s.length;
        int size = len/2;
        for (int i=0; i<size; i++){
            char tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }
    }
}
