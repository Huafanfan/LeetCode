package easy;

public class ReverseVowelsOfAString0345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while (left < right){
            while (left < chars.length && !isVowel(chars[left])){
                left++;
            }
            while (right >= 0 && !isVowel(chars[right])){
                right--;
            }
            if (left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    public boolean isVowel(char ch){
        return "aoeiuAOEIU".indexOf(ch) >= 0;
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
