package learn.thread0304;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * workstealingpool//工作窃取线程池
 * 
 * 每个线程监听自己的队列，当当前队列任务执行均结束，则去别的队列拉取任务执行
 * 
 * @author liuhao
 *
 */
public class ThreadPoolWorkStealingPool {
	public static void main(String[] args) throws IOException, InterruptedException {
		ExecutorService executorService = Executors.newWorkStealingPool(3);
		System.out.println(Runtime.getRuntime().availableProcessors());
		executorService.execute(new AddTask(100));// 精灵线程，后台线程，daemon，主线程不阻塞看不到输出
		executorService.execute(new AddTask(200));
		executorService.execute(new AddTask(300));
		executorService.execute(new AddTask(400));
		executorService.execute(new AddTask(500));
		executorService.execute(new AddTask(600));
		System.out.println(executorService);
		TimeUnit.MICROSECONDS.sleep(6000);
		System.out.println(executorService);
		System.in.read();
	}

	static class AddTask implements Runnable {
		long time;

		public AddTask(long time) {
			super();
			this.time = time;
		}

		@Override
		public void run() {
			try {
				TimeUnit.MICROSECONDS.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(time+"///123" + Thread.currentThread().getName());
		}

	}
}
