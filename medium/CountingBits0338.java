package medium;

public class CountingBits0338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i=1; i<=num; i++){
            int curNum = i;
            int count = 0;
            while (curNum!=0){
                count++;
                curNum &= curNum-1;
            }
            res[i] = count;
        }
        return res;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        int hightBit = 0;
        for (int i=1; i<=num; i++){
            //如果 i&(i−1)=0，则令 highBit=i，更新当前的最高有效位
            if ((i & (i-1)) == 0){
                hightBit = i;
            }
            res[i] = res[i - hightBit] + 1;
        }
        return res;
    }

    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public int[] countBits4(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
