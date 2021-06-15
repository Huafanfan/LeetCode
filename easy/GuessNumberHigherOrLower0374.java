package easy;

public class GuessNumberHigherOrLower0374 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;
        //区间收缩到left == right
        while (left < right){
            mid = left + (right - left)/2;
            if (guess(mid) <= 0){
                //区间[left, mid]
                right = mid;
            }
            else if (gusee(mid) > 0){
                //区间[mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }
}
