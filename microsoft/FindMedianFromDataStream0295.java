package microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream0295 {
    PriorityQueue<Integer> big;
    PriorityQueue<Integer> small;
    public FindMedianFromDataStream0295() {
        big = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        small = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() == big.size()){
            big.add(num);
            small.add(big.poll());
        }
        else {
            small.add(num);
            big.add(small.poll());
        }
    }

    public double findMedian() {
        return small.size() == big.size() ? (small.size() == 0 ? 0.0 : 1.0 * (small.peek() + big.peek())/2) : small.peek();
    }
}
