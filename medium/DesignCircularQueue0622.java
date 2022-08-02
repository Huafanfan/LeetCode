package medium;

public class DesignCircularQueue0622 {
    int[] queue;
    int capacity;
    int start;
    int end;

    /**
     * 在循环队列中，当队列为空，可知 front=rear；
     * 而当所有队列空间全占满时，也有 front=rear。
     * 为了区别这两种情况，假设队列使用的数组有 capacity 个存储空间，则此时规定循环队列最多只能有 capacity−1 个队列元素，当循环队列中只剩下一个空存储单元时，则表示队列已满。
     * 根据以上可知，队列判空的条件是 front=rear，而队列判满的条件是 front=(rear+1) mod capacity。
     */
    public DesignCircularQueue0622(int k) {
        capacity = k + 1;
        queue = new int[capacity];
        start = end = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        queue[end] = value;
        end = (end + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        start = (start + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return queue[start];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return queue[(end - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return (end + 1) % capacity == start;
    }
}
