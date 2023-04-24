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
public class ReentrantLockLearn3 {

    static volatile ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        Condition condition = reentrantLock.newCondition();

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            锁重入，会释放所有持有的锁
//            reentrantLock.lock();
            System.out.println("执行对应的方法" + Thread.currentThread().getName());
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
            System.out.println("执行对应的方法完毕" + Thread.currentThread().getName());
//        condition.signalAll();

        });
        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
//            锁重入，会释放所有持有的锁
//            reentrantLock.lock();
            System.out.println("执行对应的方法" + Thread.currentThread().getName());
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
            System.out.println("执行对应的方法完毕" + Thread.currentThread().getName());
        });
        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.lock();
            condition.signal();
            reentrantLock.unlock();
            System.out.println("执行对应的方法完毕" + Thread.currentThread().getName());
        });

        thread.start();
        thread2.start();
        thread3.start();

        TimeUnit.SECONDS.sleep(10);
        System.out.println("执行完毕");

    }
}
