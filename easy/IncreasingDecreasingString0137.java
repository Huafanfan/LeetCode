package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/25 09:13
 */
public class IncreasingDecreasingString0137 {
    public String sortString(String s) {
        int[] charSets = new int[26];
        for (int i=0; i<s.length(); i++){
            charSets[s.charAt(i) - 'a']++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean up = true;
        while (stringBuffer.length() < s.length()){
            if (up){
                for (int i=0; i<26; i++){
                    if (charSets[i]>0){
                        char temp = (char)('a'+ i);
                        stringBuffer.append(temp);
                        charSets[i]--;
                    }
                }
                up = false;
            }
            else {
                for (int i=25; i>=0; i--){
                    if (charSets[i]>0){
                        char temp = (char)('a' + i);
                        stringBuffer.append(temp);
                        charSets[i]--;
                    }
                }
                up = true;
            }
        }
        return stringBuffer.toString();
    }
    //public boolean isEmpty(int[] charSets){
    //    for (int i=0; i<26; i++){
    //        if (charSets[i]>0){
    //            return false;
    //        }
    //    }
    //    return true;
    //}

    public static void main(String[] args) {
        IncreasingDecreasingString0137 increasingDecreasingString0137 = new IncreasingDecreasingString0137();
        System.out.println(increasingDecreasingString0137.sortString("spo"));
    }
}
