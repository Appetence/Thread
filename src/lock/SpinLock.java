package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 尝试获得锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁
 * 优点：
 * 自旋锁  spinlock ,减少上下文之间线程切换的资源浪费，
 * 缺点：
 * 但是会消耗cpu
 */
public class SpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        //当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "/t" + "加锁了O_O");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void umMyLock() {
        //当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "用户取消了锁");
        atomicReference.compareAndSet(thread, null);//将线程设置为空
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            spinLock.myLock();
            try {
                TimeUnit.MILLISECONDS.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLock.umMyLock();
            }
        });
        TimeUnit.SECONDS.sleep(1);
        executorService.submit(() -> {
            spinLock.myLock();
            spinLock.umMyLock();
        });


    }
}
