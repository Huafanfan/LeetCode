package byteDance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 15:56
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> big;
    PriorityQueue<Integer> small;
    public FindMedianFromDataStream() {
        big = new PriorityQueue<>();
        small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

    }

    public void addNum(int num) {
        if (big.size() == small.size()){
            small.add(num);
            big.add(small.poll());
        }
        else {
            big.add(num);
            small.add(big.poll());
        }
    }

    public double findMedian() {
        if (big.size() == small.size()){
            return 1.0 * big.peek() / small.peek();
        }
        else {
            return 1.0 * big.peek();
        }
    }

}
