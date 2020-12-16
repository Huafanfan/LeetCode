package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 09:40
 */
public class MonotoneIncreasingDigits0738 {
    /**
     * 超时
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        for (int i=N; i>=9; i--){
            String num = String.valueOf(i);
            if (num.length() < 2){
                return i;
            }
            boolean isSatify = true;
            for (int j=num.length()-1; j>0; j--){
                if (num.charAt(j) < num.charAt(j-1)){
                    isSatify = false;
                    break;
                }
            }
            if (isSatify) {
                return i;
            }
        }
        return -1;
    }

    public int monotoneIncreasingDigits2(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        int length = chars.length;
        for (int i=length-1;i>0;i--){
            if (chars[i]<chars[i-1]){
                chars[i-1]--;
                for (int j=i;j<length;j++){
                    chars[j]='9';
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits0738 monotoneIncreasingDigits0738 = new MonotoneIncreasingDigits0738();
        System.out.println(monotoneIncreasingDigits0738.monotoneIncreasingDigits(10));
    }
}
