package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/12 15:18
 */
public class DeleteColumnsToMakeSorted0944 {
    public int minDeletionSize(String[] strs) {
        int length = strs[0].length();
        int num = strs.length;
        int res = 0;
        for (int i=0; i<length; i++){
            for (int j=1; j<num; j++){
                if (strs[j].charAt(i) < strs[j-1].charAt(i)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
