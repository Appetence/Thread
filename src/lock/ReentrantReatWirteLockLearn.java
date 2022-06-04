package lock;

import thread.thread0304.ThreadPoolCachLearn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，正对读的时候或写的时候枷锁
 *
 * 多线程同时读取一个资源时，没有问题，多线程同时写一个资源的时候需要进行枷锁
 *
 *      读-读  无需枷锁
 *      读-写  枷锁
 *      写-写  加锁
 */
public class ReentrantReatWirteLockLearn {

    public static void main(String[] args) {
        /**
         * 不加锁之前，由于读取顺序问题会导致每次结果不同
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5 ; i++) {
            int finalI = i;
            executorService.submit(()->{  myCache.put(finalI +"", finalI +"");});
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
           executorService.submit(()->{
                myCache.get(finalI+"");
            });
        }
        executorService.shutdown();
    }

}
//缓存类
class  MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    //put
    public void put(String key ,Object value) {
        //mq 异步入库，放到磁盘，入库
            //定时任务：定时线程发送，放到sender
            //非定时：直接放到mq，task 统一处理
        try {
            reentrantReadWriteLock.writeLock().lock();//锁定
            System.out.println(Thread.currentThread().getName() + "正在写入");
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入结束");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
    //get
    public void get(String key){

        try {
            reentrantReadWriteLock.readLock().lock();//锁定
            System.out.println(Thread.currentThread().getName()+"正在读取");
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName()+"读取结束："+map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }


}
