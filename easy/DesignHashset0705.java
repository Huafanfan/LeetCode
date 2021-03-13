package easy;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/13 10:18
 */
public class DesignHashset0705 {
    private LinkedList[] data;
    int size;
    public DesignHashset0705() {
        size = 512;
        data = new LinkedList[size];
    }

    public void add(int key) {
        int index = getIndex(key);
        if (data[index] == null){
            data[index] = new LinkedList<Integer>();
        }
        for (Object o : data[index]) {
            Integer element = (Integer) o;
            if (element == key) {
                return;
            }
        }
        data[index].offer(key);
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (data[index] == null){
            return;
        }
        for (Object o : data[index]) {
            Integer element = (Integer) o;
            if (element == key) {
                data[index].remove(index);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        if (data[index] == null){
            return false;
        }
        for (Object o : data[index]) {
            Integer element = (Integer) o;
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(int key){
        return (new Integer(key).hashCode() & (size-1));
    }
}
