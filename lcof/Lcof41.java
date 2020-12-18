package lcof;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 16:01
 */
public class Lcof41 {
    Queue<Integer> A,B;
    /** initialize your data structure here. */
    public Lcof41() {
        //小根堆，存大数
        A = new PriorityQueue<>();
        //大根堆，存小数
        B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }
        else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
