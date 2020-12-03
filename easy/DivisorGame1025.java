package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/3 10:36
 */
public class DivisorGame1025 {
    public boolean divisorGame(int N) {
        return N%2 == 0;
    }

    public boolean divisorGame2(int N) {
        boolean[] f = new boolean[N + 2];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[N];
    }
}
