package byteDance;

public class SqrtX {
    public double mySqrt(int x) {
        double p=1e-6;
        double left = 0;
        double right = x;
        double mid = (right - left) / 2 + left;
        while (Math.abs(mid * mid - x) > p){
            if (mid * mid > x){
                right = mid;
            }
            else if (mid * mid < x){
                left = mid;
            }
            else {
                return Math.round(mid*1)/1.0;
            }
            mid = (right - left) / 2 + left;
        }
        return Math.round(mid*1)/1.0;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(2));
    }
}
