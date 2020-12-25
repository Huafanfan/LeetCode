package draft;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 13:15
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int[] counter = {0};
        ReentrantLock lock = new ReentrantLock();
        for (int i= 0; i < 50; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        int a = counter[0];
                        counter[0] = a + 1;
                    }finally {
                        lock.unlock();
                    }
                }
            }).start();}
        // 主线程休眠，等待结果
        Thread.sleep(5000);
        System.out.println(counter[0]);

    }
}
