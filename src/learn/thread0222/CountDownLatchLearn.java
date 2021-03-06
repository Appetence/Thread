package learn.thread0222;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CountDownLatchLearn {
    private final static int USER_MAX = 10000;

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
