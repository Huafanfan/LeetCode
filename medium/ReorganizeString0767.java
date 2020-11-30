package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/30 09:18
 */
public class ReorganizeString0767 {
    public String reorganizeString(String S) {
        String result = "";
        result = dfs(new StringBuffer(S), new StringBuffer(), S.length());
        return result;
    }

    public String dfs(StringBuffer SB, StringBuffer current, int N){
        if (current.length() == N){
            return current.toString();
        }
        else {
            boolean flag = false;
            String result = "";
            for (int i=0; i<SB.length(); i++){
                if (current.length()>0){
                    if (current.charAt(current.length()-1) != SB.charAt(i)){
                        flag = true;
                        char temp = SB.charAt(i);
                        current.append(temp);
                        SB.delete(i, i+1);
                        result = dfs(SB, current, N);
                        if (result.length() == N) {
                            return result;
                        }
                        SB.insert(i, temp);
                        current.deleteCharAt(current.length()-1);
                    }
                }
                else {
                    char temp = SB.charAt(i);
                    current.append(temp);
                    SB.delete(i, i+1);
                    result = dfs(SB, current, N);
                    if (result.length() == N) {
                        return result;
                    }
                    SB.insert(i, temp);
                    current.deleteCharAt(current.length()-1);
                }
            }
            if (!flag){
                return "";
            }
            else {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        ReorganizeString0767 reorganizeString0767 = new ReorganizeString0767();
        System.out.println(reorganizeString0767.reorganizeString("aaab"));
    }
}
