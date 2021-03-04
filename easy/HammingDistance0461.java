package easy;

public class HammingDistance0461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0){
            res++;
            xor &= xor-1;
        }
        return res;
    }
}
