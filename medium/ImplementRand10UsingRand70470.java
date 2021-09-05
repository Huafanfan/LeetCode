package medium;

import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/5 11:08
 */
public class ImplementRand10UsingRand70470 {
    public int rand10() {
        int res;
        do {
            int row = rand7();
            int col = rand7();
            res = (row - 1) * 7 + col;
        }while (res > 40);
        return 1 + (res - 1) % 10;

    }

    public int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
