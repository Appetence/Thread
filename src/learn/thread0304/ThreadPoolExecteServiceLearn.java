package learn.thread0304;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 线程池学习  executorservice
 * @author liuhao
 *
 */
public class ThreadPoolExecteServiceLearn {
public static void main(String[] args) throws InterruptedException {
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
