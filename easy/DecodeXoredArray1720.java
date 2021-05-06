package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/6 11:12
 */
public class DecodeXoredArray1720 {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] decoded = new int[n];
        decoded[0] = first;
        for (int i = 1; i < n; i++) {
            decoded[i] = decoded[i - 1] ^ encoded[i - 1];
        }
        return decoded;
    }

    public static void main(String[] args) {
        DecodeXoredArray1720 decodeXoredArray1720 = new DecodeXoredArray1720();
        int[] encoded = new int[]{1,2,3};
        decodeXoredArray1720.decode(encoded, 1);
    }
}
