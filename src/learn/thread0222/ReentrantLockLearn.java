package learn.thread0222;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @description: condition.await signal  类似于wait notify
 * @author: liuhao
 * @date: 2022-07-13 16:21
 */
public class ReentrantLockLearn {
    private final static int USER_MAX = 5;

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < USER_MAX; i++) {
            Thread park = new Thread(() -> {
                reentrantLock.lock();
                // 多次调用需要unPark多次
//                reentrantLock.lock();
                try {
                    System.out.println(Thread.currentThread().getId() + "进来啦ß" + Thread.currentThread().getName());
                    condition.await();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getId() + "释放啦ß" + Thread.currentThread().getName());
                    reentrantLock.unlock();
                }
            });
            threads.add(park);
            park.start();
        }
        while (true) {
            for (Thread thread : threads) {
                System.out.println(thread.getName() + "当前线程所处状态  " + thread.getState());
            }
            TimeUnit.SECONDS.sleep(2);
            Thread park = new Thread(() -> {
                reentrantLock.lock();
                condition.signalAll();
                reentrantLock.unlock();
            });
            park.start();

        }
    }
}
