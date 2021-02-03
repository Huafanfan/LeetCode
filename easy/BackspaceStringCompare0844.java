package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/20 09:55
 */
public class BackspaceStringCompare0844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuffer S1 = new StringBuffer();
        StringBuffer T1 = new StringBuffer();
        for (int i=0; i<S.length(); i++){
            if (S.charAt(i) != '#'){
                S1.append(S.charAt(i));
            }
            else {
                if (S1.length()>0){
                    S1.deleteCharAt(S1.length()-1);
                }
            }
        }
        for (int i=0; i<T.length(); i++){
            if (T.charAt(i) != '#'){
                T1.append(T.charAt(i));
            }
            else {
                if (T1.length()>0){
                    T1.deleteCharAt(T1.length()-1);
                }
            }
        }
        return S1.toString().equals(T1.toString());
        //if (S1.length() != T1.length()){
        //    return false;
        //}
        //if (S1.length() == 0){
        //    return true;
        //}
        //for (int i=0; i<S1.length(); i++){
        //    if (S1.charAt(i) != T1.charAt(i)){
        //        return false;
        //    }
        //}
        //return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare0844 backspaceStringCompare0844 = new BackspaceStringCompare0844();
        String S = "ab##";
        String T = "c#b#";
        System.out.println(backspaceStringCompare0844.backspaceCompare(S,T));
    }
}
