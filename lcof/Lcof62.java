package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 15:32
 */
public class Lcof62 {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

    public static void main(String[] args) {
        Lcof62 lcof62 = new Lcof62();
        System.out.println(lcof62.lastRemaining(5,3));
    }
}
