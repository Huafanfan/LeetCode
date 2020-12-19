package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/19 10:37
 */
public class Lcof46 {
    /**
     * 100.00%
     * 85.36%
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String numString = String.valueOf(num);
        int lastTow = 1;
        int lastOne = 1;
        for (int i=1; i<numString.length(); i++){
            int cur = 0;
            if (numString.charAt(i-1)=='1' || (numString.charAt(i-1)=='2' && numString.charAt(i)>='0' && numString.charAt(i)<='5')){
                cur += lastTow;

            }
            cur += lastOne;
            lastTow = lastOne;
            lastOne = cur;
        }
        return lastOne;
    }

    public static void main(String[] args) {
        Lcof46 lcof46 = new Lcof46();
        System.out.println(lcof46.translateNum(18580));
    }
}
