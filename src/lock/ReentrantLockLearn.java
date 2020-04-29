package lock;

import com.sun.tools.doclint.Entity;

import java.util.concurrent.locks.ReentrantLock;

import static com.sun.tools.doclint.Entity.ge;

/**
 * 可重入锁，方法上锁后，可以调用其他需要上锁的方法
 * 理解为同一个锁，方法1获取了该锁的钥匙可以直接调用被该锁锁定的方法二，外层方法获取锁后内层方法会自动获取锁
 * 优点：
 *       避免死锁
 */
public class ReentrantLockLearn {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        myLock.get01();
        myLock.get03();

    }

}
class MyLock{
   volatile  ReentrantLock reentrantLock = new ReentrantLock();
    public void get01(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getId()+"走了1");
        get02();
        reentrantLock.unlock();
        System.out.println(Thread.currentThread().getId()+"结束了");
    }
    public void get02(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getId()+"走了2");
        reentrantLock.unlock();
        System.out.println(Thread.currentThread().getId()+"结束了");
    }
    public synchronized void get03(){
        System.out.println(Thread.currentThread().getId()+"走了3");
        get04();
        System.out.println(Thread.currentThread().getId()+"结束了3");
    }
    public synchronized void get04(){
        System.out.println(Thread.currentThread().getId()+"走了4");
        System.out.println(Thread.currentThread().getId()+"结束了4");
    }
}