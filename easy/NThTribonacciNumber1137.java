package easy;

public class NThTribonacciNumber1137 {
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n <= 2){
            return 1;
        }
        int n0;
        int n1 = 0;
        int n2 = 1;
        int res = 1;
        for (int i=3; i<=n; i++){
            n0 = n1;
            n1 = n2;
            n2 = res;
            res = n0 + n1 + n2;

        }
        return res;
    }
}
