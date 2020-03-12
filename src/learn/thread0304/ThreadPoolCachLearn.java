package learn.thread0304;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * cach线程池
 * @author liuhao
 *
 */
public class ThreadPoolCachLearn {
public static void main(String[] args) throws InterruptedException {
	ExecutorService executorService = Executors.newCachedThreadPool();//缓存线程池，有仍无进来，new，有空的
	System.out.println(executorService);
		for(int i =  0; i < 5 ; i++ ) {

			executorService.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		System.out.println(executorService);
		TimeUnit.SECONDS.sleep(10);
		System.out.println(executorService);
		for(int i = 0;i<3;i++) {
			executorService.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		TimeUnit.SECONDS.sleep(1);
		System.out.println(executorService.isTerminated());
		System.out.println(executorService);
		executorService.shutdown();
}
}
