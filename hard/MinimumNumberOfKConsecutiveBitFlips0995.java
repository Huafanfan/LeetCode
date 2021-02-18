package hard;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumNumberOfKConsecutiveBitFlips0995 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

    public int minKBitFlips2(int[] A, int K) {
        int res=0;
        Deque<Integer> que = new LinkedList<>();
        for (int i=0; i<A.length; i++) {
            if (que.size()>0 && i>que.peek()+K-1){
                que.removeFirst();
            }
            //1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            //2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (que.size()%2==A[i]){
                if (i+K>A.length) {
                    return -1;
                }
                que.add(i);
                res+=1;
            }
        }
        return res;
    }
}
