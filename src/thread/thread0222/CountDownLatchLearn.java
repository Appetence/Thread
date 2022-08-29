package thread.thread0222;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 门栓，  秦扫六合
 */
public class CountDownLatchLearn {
    private final static int USER_MAX = 5;

    public static void main(String[] args) {


        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();//增加一
        atomicInteger.compareAndSet(1,1);
        CountDownLatch cdl = new CountDownLatch(USER_MAX);
        for(int i = 0 ; i < USER_MAX ; i++){
            new Thread(()->{
                try {
                    cdl.await();
                    System.out.println("进来啦ß"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            cdl.countDown();
        }
    }
}
