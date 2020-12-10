package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/10 09:20
 */
public class LemonadeChange0860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five < 1) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else {
                if (ten > 0) {
                    if (five > 0) {
                        ten--;
                        five--;
                    } else {
                        return false;
                    }
                } else {
                    if (five > 2) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange0860 lemonadeChange0860 = new LemonadeChange0860();
        int[] bills = new int[]{5,5,5,10,20};
        System.out.println(lemonadeChange0860.lemonadeChange(bills));
    }
}
