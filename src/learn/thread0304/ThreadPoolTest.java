package learn.thread0304;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    static BlockingQueue blockingQueue = new LinkedBlockingQueue<String>();
    private volatile static boolean flage = true;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final int flag = 20000;
        executorService.execute(() -> {
            for (int i = 0; i < flag; i++) {
                try {
                    System.out.println("放入数据：" + Thread.currentThread().getName() + i + "数据");
                    blockingQueue.put(i + "数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                try {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + "::" + blockingQueue.take() + "queue size " + blockingQueue.size());
                       // atomicInteger
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        long end = System.currentTimeMillis();
        System.out.println(" thread  info " + executorService.isTerminated());
        executorService.shutdown();


        System.out.println("end:::" +(end - start));
    }
    public static void stop(){
        flage = false;
    }
}
