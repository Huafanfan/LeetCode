package acwing.greedy.huffman.acwing148;

import java.io.BufferedInputStream;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/29 16:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Queue<Integer> heap = new PriorityQueue<>();
        while (n -- != 0){
            heap.add(in.nextInt());
        }
        int res = 0;
        while (heap.size() > 1){
            int x = heap.poll();
            int y = heap.poll();
            res += x + y;
            heap.add(x + y);
        }
        System.out.println(res);
    }
}
