package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/18 13:49
 */
public class NumberComplement0476 {
    public int findComplement(int num) {
        int index = -1;
        for (int i=31; i>=0; i--){
            if (((num >> i) & 1) != 0){
                index = i;
                break;
            }
        }
        int ans = 0;
        for (int i=0; i<index; i++){
            if (((num >> i) & 1) == 0){
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public int findComplement2(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
