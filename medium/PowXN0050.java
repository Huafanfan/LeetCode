package medium;

import java.util.regex.Pattern;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/7/31 15:30
 */
public class PowXN0050 {

    double quickMul1(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul1(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    double quickMul2(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul1(x, N) : 1.0 / quickMul1(x, N);
    }

    public static void main(String[] args) {
        System.out.println(isDigit("12312SS3123"));
    }

    private static boolean isDigit(String string) {
        if (string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }
}
