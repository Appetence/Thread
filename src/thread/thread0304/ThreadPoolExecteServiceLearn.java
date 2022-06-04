package thread.thread0304;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 线程池学习  executorservice
 * @author liuhao
 *
 */
public class ThreadPoolExecteServiceLearn {
	volatile ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

	public static void main(String[] args) throws InterruptedException {

	ReentrantLock reentrantLock = new ReentrantLock();
	reentrantLock.lock();
	reentrantLock.tryLock();
	reentrantLock.unlock();
	ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	ExecutorService executorService = Executors.newFixedThreadPool(5);//定义一个线程池
	for(int i = 0 ; i < 6; i ++) {
		executorService.execute(()->{
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		});
		//俩种放入方式，第一种只能放runnable,第二种可以让runnable和collable（又返回值）executorService.submit(()->{});
	}
	executorService.shutdown();
	System.out.println(executorService);//线程池详细属性
	System.out.println(executorService.isTerminated());//所有任务是否均执行
	System.out.println(executorService.isShutdown());//是否停止线程池
	
	TimeUnit.SECONDS.sleep(5);
	
	System.out.println(executorService.isTerminated());
	System.out.println(executorService.isShutdown());//停止线程池
	System.out.println(executorService);//线程池详细属性
}
}
