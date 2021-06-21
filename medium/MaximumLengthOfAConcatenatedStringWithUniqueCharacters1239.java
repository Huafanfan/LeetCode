package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 {
    int maxL = Integer.MIN_VALUE;
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        traceback(masks, 0, 0);
        return maxL;
    }

    public void traceback(List<Integer> masks, int index, int mask){
        if (index == masks.size()){
            maxL = Math.max(maxL, Integer.bitCount(mask));
        }
        if ((masks.get(index) & mask) == 0){
            traceback(masks, index + 1, mask | masks.get(index));
        }
        else {
            traceback(masks, index + 1, mask);
        }
    }
}
