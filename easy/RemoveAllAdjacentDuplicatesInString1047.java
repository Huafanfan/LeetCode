package easy;

public class RemoveAllAdjacentDuplicatesInString1047 {
    public String removeDuplicates(String S) {
        StringBuilder str = new StringBuilder();
        int index = -1;
        int len = S.length();
        char[] chars = S.toCharArray();
        for (int i=0; i<len; i++){
            if (index >= 0 && str.charAt(index) == chars[i]){
                str.deleteCharAt(index);
                index--;
            }
            else {
                str.append(chars[i]);
                index++;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString1047 removeAllAdjacentDuplicatesInString1047 = new RemoveAllAdjacentDuplicatesInString1047();
        System.out.println(removeAllAdjacentDuplicatesInString1047.removeDuplicates("aaaaaa"));
    }
}
