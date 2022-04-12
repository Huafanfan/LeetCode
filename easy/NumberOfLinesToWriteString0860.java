package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/12 09:00
 */
public class NumberOfLinesToWriteString0860 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        char[] chars = s.toCharArray();
        int row = 1;
        int cur = 0;
        for (char c : chars){
            int length = widths[c - 'a'];
            if (cur + length <= 100){
                cur += length;
            }
            else {
                row++;
                cur =  widths[c - 'a'];
            }
        }
        res[0] = row;
        res[1] = cur;
        return res;
    }
}
