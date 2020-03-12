package learn.thread0304;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFutureTaskLearn {
/**
 * futuretack未来执行线程，实现了callable接口
 * @throws ExecutionException 
 * @throws InterruptedException 
 * 
 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				//自己的业务逻辑
				TimeUnit.SECONDS.sleep(3);
				return 999;
			}
			 
		});
		new Thread(future).start();//启动线程，thread内可以放tesk不能放callable
		System.out.println("123123"+future.get());
		/*************/
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<Integer> futures = executorService.submit(()->{
			TimeUnit.SECONDS.sleep(2);
			return 000;
		});
		System.out.println(futures.isDone());
		System.out.println(futures.get());//阻塞等待结果，，callable无此方法
		System.out.println(futures.isDone());
		executorService.shutdown();
	}
}
