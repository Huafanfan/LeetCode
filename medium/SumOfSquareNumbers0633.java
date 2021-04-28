package medium;

public class SumOfSquareNumbers0633 {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int right = (int)Math.sqrt(c);
        int left = 0;
        while (left <= right){
            int num = left * left + right * right;
            if (num == c){
                return true;
            }
            else if (num > c){
                right--;
            }
            else {
                left ++;
            }
        }
        return false;
    }
}
