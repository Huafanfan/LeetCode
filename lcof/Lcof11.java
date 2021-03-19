package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 13:51
 */
public class Lcof11 {
    /**
     * 100.00%
     * 44.17%
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            int mid = (right-left)/2 + left;
            if (numbers[mid]<numbers[right]){
                right = mid;
            }
            else if (numbers[mid]>numbers[right]){
                left = mid + 1;
            }
            else {
                //相等的情况需要单独考虑
                right--;
            }
        }
        return numbers[left];
    }
}
