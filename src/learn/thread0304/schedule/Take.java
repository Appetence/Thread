package learn.thread0304.schedule;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-07-18 16:46
 */
public class Take {
    private final static transient ReentrantLock lock = new ReentrantLock();

    private static final Condition available = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        lock.lockInterruptibly();
/*        for(;;){
            System.out.println("open await");
            available.await();
            System.out.println("end");
        }*/
        int k = 9;// 1000
        int parent = (k - 1) >>> 1;
        System.out.println(parent);

    }
}
