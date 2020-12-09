package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/9 09:18
 */
public class SplitArrayIntoFibonacciSequence0842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev){
        if (index == length){
            return list.size()>=3;
        }
        long currLong = 0;
        for (int i=index; i<length; i++){
            if (i>index && S.charAt(index) == '0'){
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE){
                break;
            }
            int curr = (int)currLong;
            if (list.size()>=2){
                if (curr < sum){
                    continue;
                }
                else if (curr > sum){
                    break;
                }
            }

            list.add(curr);
            if (backtrack(list, S, length, i+1, prev+curr, curr)){
                return true;
            }
            list.remove(list.size()-1);

        }
        return false;
    }
}
