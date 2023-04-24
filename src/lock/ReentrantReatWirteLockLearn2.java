package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，正对读的时候或写的时候枷锁
 * <p>
 * 多线程同时读取一个资源时，没有问题，多线程同时写一个资源的时候需要进行枷锁
 * <p>
 * 读-读  无需枷锁
 * 读-写  枷锁
 * 写-写  加锁
 */
public class ReentrantReatWirteLockLearn2 {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();


        /**
         * 不加锁之前，由于读取顺序问题会导致每次结果不同
         */
//        ExecutorService executorService = Executors.newFixedThreadPool(4);

       /* Thread t2 = new Thread(() -> {

            writeLock.lock();
            System.out.println("thiread2" + Thread.currentThread().getName() + "持有写锁");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            writeLock.unlock();

        });*/
        Thread t = new Thread(() -> {

            readLock.lock();
            System.out.println("thiread1" + Thread.currentThread().getName() + "持有读锁");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readLock.unlock();

        });

        Thread t3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readLock.lock();
            System.out.println("thiread3" + Thread.currentThread().getName() + "持有读锁");

        });
        Thread t4 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readLock.lock();
            System.out.println("thiread4" + Thread.currentThread().getName() + "持有读锁");
        });

//        t2.start();
        t.start();
        t3.start();
        t4.start();
//        executorService.shutdown();
    }

}
