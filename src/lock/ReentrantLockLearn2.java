package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @description: 公平锁，非公平锁
 * @author: liuhao
 * @date: 2023-03-14 13:11
 */
public class ReentrantLockLearn2 {

    static volatile ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("执行对应的方法" + Thread.currentThread().getName());
            reentrantLock.unlock();
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.lock();
            System.out.println("执行对应的方法" + Thread.currentThread().getName());
        });
        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.lock();
            System.out.println("执行对应的方法" + Thread.currentThread().getName());
        });

        thread.start();
        thread2.start();
        thread3.start();

        TimeUnit.SECONDS.sleep(10);
        System.out.println("执行完毕");

    }
}
