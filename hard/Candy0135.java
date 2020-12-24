package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 09:19
 */
public class Candy0135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i=0; i<ratings.length; i++){
            if (i>0 && ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
            else {
                candies[i] = 1;
            }
        }

        int right = 0;
        int result = 0;
        for (int i=ratings.length-1; i >=0; i--){
            if (i<ratings.length-1 && ratings[i] > ratings[i+1]){
                right ++;
            }
            else {
                right = 1;
            }
            result += Math.max(candies[i],right);
        }
        return result;
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1,0,2,4,1};
        Candy0135 candy0135 = new Candy0135();
        System.out.println(candy0135.candy(ratings));
    }
}
