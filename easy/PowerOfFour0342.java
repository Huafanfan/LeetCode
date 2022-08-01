package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/21 12:00
 */
public class PowerOfFour0342 {
    public static Powers p = new Powers();

    /**
     * 暴力法 + 预计算
     * @param num
     * @return
     */
    public boolean isPowerOfFour1(int num) {
        return p.nums.contains(num);
    }

    static class Powers {
        private int n = 15;
        public List<Integer> nums = new ArrayList();
        Powers() {
            int lastNum = 1;
            nums.add(lastNum);
            for (int i = 1; i < n + 1; ++i) {
                lastNum = lastNum * 4;
                nums.add(lastNum);
            }
        }
    }

    /**
     * 数学运算
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
    }

    /**
     * 位操作
     * @param num
     * @return
     */
    public boolean isPowerOfFour3(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }

    /**
     * 位运算 + 数学运算
     * @param num
     * @return
     */
    public boolean isPowerOfFour4(int num) {
        return ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}
