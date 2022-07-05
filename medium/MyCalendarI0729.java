package medium;

import java.util.TreeSet;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 09:28
 */
public class MyCalendarI0729 {
    TreeSet<int[]> booked;

    public MyCalendarI0729() {
        booked = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        if (booked.isEmpty()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        // 返回第一个比tmp大的
        int[] arr = booked.ceiling(tmp);
        // lower 第一个比tmp小的
        if (arr == booked.first() || booked.lower(tmp)[1] <= start) {
            booked.add(new int[]{start, end});
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendarI0729 myCalendarI0729 = new MyCalendarI0729();
        System.out.println(myCalendarI0729.book(10,20));
        // System.out.println(myCalendarI0729.book(15,25));
        System.out.println(myCalendarI0729.book(20,30));
        System.out.println(myCalendarI0729.book(15,20));
    }
}
