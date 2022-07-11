package learn.threadJoin;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-07-11 16:31
 */
public class ThreadJoinLearn {
    public static void delay() {
        int j = 1;
        for (int i = 0; i < 10; i++) {
            j = j + i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static Thread thread2 = null;
    static Thread thread = null;

    public static void main(String[] args) {
        thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                delay();
                System.out.println("t2 线程状态" + thread2.getState());
                n();
                System.out.println("t1 运行结束");
            }
        });
        thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                delay();
                System.out.println("t1 线程状态" + thread.getState());
                try {
                    /**
                     * thread.join()
                     * thread优先执行 thread2 进入waiting状态
                     * 底层为wait 阻塞的是当前线程
                     */
                    thread.join();
//                    w();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 运行结束");
            }
        });
        thread.setName("thread1");
        thread2.setName("thread2");
        thread2.start();
        thread.start();
    }

    private static void n() {
        // 想要唤醒需要用wait sync中lock的对账进行操作
        synchronized (thread2) {
            System.out.println("开始notify");
            thread2.notifyAll();
            System.out.println("结束notify");
        }
    }

    private static void w() throws InterruptedException {
        synchronized (thread2) {
            System.out.println("开始sleep");
            // 必须拥有锁，wait会释放获取到的锁
            thread2.wait();
//          sleep无法被notify唤醒，因为不会释放
//          Thread.sleep(10000);
            System.out.println("结束sleep");
        }
        /**
         * // IllegalMonitorStateException
         *ReentrantLock reentrantLock = new ReentrantLock();
         *try {
         *reentrantLock.lock();
         *thread2.wait();
         *} finally {
         *reentrantLock.unlock();
         *}
         */

      /*  LockSupport reentrantLock = new LockSupport();
        try {
            reentrantLock.lock();
            thread2.wait();
        } finally {
            reentrantLock.unlock();
        }*/


    }

}
