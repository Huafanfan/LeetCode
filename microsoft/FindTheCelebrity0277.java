package microsoft;

public class FindTheCelebrity0277 {
    public int findCelebrity(int n) {
        int result = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(result, i)) {
                result = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (result == i) {
                continue;
            }
            if (knows(result, i) || !knows(i, result)) {
                return -1;
            }
        }
        return result;
    }

    public boolean knows(int i, int j){
        return false;
    }
}
