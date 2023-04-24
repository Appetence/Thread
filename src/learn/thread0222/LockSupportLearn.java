package learn.thread0222;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-07-13 16:01
 */
public class LockSupportLearn {
    private final static int USER_MAX = 1;

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread thread = Thread.currentThread();
        for (int i = 0; i < USER_MAX; i++) {
            Thread park = new Thread(() -> {
                System.out.println("park");
                LockSupport.park(o);
                try {
                    System.out.println(Thread.currentThread().getId() + "进来啦ß" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getId() + "释放啦ß" + Thread.currentThread().getName());
                }
            });
            park.start();
            TimeUnit.SECONDS.sleep(1);
            LockSupport.unpark(park);
        }
        System.out.println(">>>>>> unpark");
    }
}
