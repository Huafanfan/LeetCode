package easy.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/3 10:52
 */
public class DiStringMatch0942 {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] result = new int[N+1];
        int minNum = 0, maxNum = N;
        for (int i=0; i<N; i++){
            if (S.charAt(i) == 'I') {
                result[i] = minNum++;
            }
            else {
                result[i] = maxNum--;
            }
        }
        result[N] = minNum;
        //if (S.charAt(S.length()-1) == 'I') {
        //    result[S.length()] = minNum;
        //}
        //else {
        //    result[S.length()] = maxNum;
        //}
        return result;
    }
}
