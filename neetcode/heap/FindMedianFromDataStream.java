package neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/16 17:24
 */
public class FindMedianFromDataStream {
    // 还有进阶问题
    Queue<Integer> big;
    Queue<Integer> small;
    public FindMedianFromDataStream() {
        big = new PriorityQueue<>((o1, o2) -> o2 - o1);
        small = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (big.size() == small.size()){
            big.add(num);
            small.add(big.poll());
        }else {
            small.add(num);
            big.add(small.poll());
        }
    }

    public double findMedian() {
        if (big.size() == small.size()){
            if (small.size() == 0){
                return 0.0;
            } else {
                return 1.0 * (small.peek() + big.peek())/2;
            }
        } else {
            return small.peek();
        }
    }
}
